package com.sky.ddt.task;

import com.alibaba.fastjson.JSON;
import com.amazon.spapi.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.spapi.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.spapi.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.amazon.spapi.api.FbaInventoryApi;
import com.amazon.spapi.client.ApiException;
import com.amazon.spapi.model.fbainventory.GetInventorySummariesResponse;
import com.amazon.spapi.model.fbainventory.Granularity;
import com.amazon.spapi.model.fbainventory.InventorySummary;
import com.amazon.spapi.model.fbainventory.ResearchingQuantityEntry;
import com.sky.ddt.dao.custom.CustomAmazonAuthMapper;
import com.sky.ddt.dao.custom.CustomAmazonFbaInventoryMapper;
import com.sky.ddt.dao.custom.CustomAmazonSyncInfoMapper;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.entity.AmazonAuth;
import com.sky.ddt.entity.AmazonFbaInventory;
import com.sky.ddt.entity.AmazonFbaInventoryExample;
import com.sky.ddt.entity.AmazonSyncInfo;
import com.sky.ddt.common.enums.AmazonSyncInfoTypeEnum;
import com.sky.ddt.service.amazon.IAmazonAuthService;
import com.sky.ddt.service.amazon.IAmazonSyncInfoService;
import com.sky.ddt.util.DateUtil;
import com.sky.ddt.util.OffsetDateTimeTool2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.threeten.bp.OffsetDateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@Component
public class FbaInventoryJob {
    @Autowired
    CustomAmazonAuthMapper customAmazonAuthMapper;
    @Autowired
    CustomAmazonFbaInventoryMapper customAmazonFbaInventoryMapper;
    @Autowired
    IAmazonSyncInfoService amazonSyncInfoService;
    @Autowired
    CustomAmazonSyncInfoMapper customAmazonSyncInfoMapper;
    @Autowired
    IAmazonAuthService amazonAuthService;

    @Scheduled(cron = "0 0/5 * * * ?")
    //@Scheduled(cron = "0/2 * * * * ?")
    public void scheduled() {
        //获取获取订单信息
        log.info("{}，获取库存信息", DateUtil.getFormatDateStr(new Date()));
        List<AmazonAuth> amazonAuthList = amazonAuthService.listAmazonAuth();
        //获取店铺信息 遍历店铺信息
        for (AmazonAuth amazonAuth :
                amazonAuthList) {
            if (StringUtils.isEmpty(amazonAuth.getMarketplaceId())) {
                continue;
            }
            log.info("{}，获取店铺{}的库存信息", DateUtil.getFormatDateStr(new Date()),amazonAuth.getMerchantId());
            try {
                syncFbaInventoryInfo(amazonAuth);
            } catch (ApiException e) {
                if(AmazonConfig.INSTANCE.getLimitErroCode().equals(e.getCode())){
                    log.info("OrderItemJob fail,limit max,e:{}",e.getResponseBody());
                    continue;
                }
                log.info("FbaInventoryJob fail,e:{}", JSON.toJSONString(e));
                e.printStackTrace();
                continue;
            }
        }
    }

    private void syncFbaInventoryInfo(AmazonAuth amazonAuth) throws ApiException {
        FbaInventoryApi fbaInventoryApi = getFbaInventoryApi(amazonAuth);
        AmazonSyncInfo amazonSyncInfo = amazonSyncInfoService.getAmazonSyncInfo(AmazonSyncInfoTypeEnum.FBA_INVENTORY, amazonAuth.getMerchantId());
        Date lastYearNow=DateUtil.plusYear(-1,new Date());
        if(amazonSyncInfo.getLastUpdateAfter()==null||amazonSyncInfo.getLastUpdateAfter().before(lastYearNow)){
            amazonSyncInfo.setLastUpdateAfter(lastYearNow);
        }
        GetInventorySummariesResponse response = getInventory(amazonAuth, fbaInventoryApi, amazonSyncInfo);
        if (response == null || response.getPayload() == null) {
            return;
        }
        dealFbaInventoryInfo(fbaInventoryApi, amazonAuth, response, amazonSyncInfo);
    }

    private FbaInventoryApi getFbaInventoryApi(AmazonAuth amazonAuth) {
        AWSAuthenticationCredentials awsAuthenticationCredentials = AWSAuthenticationCredentials.builder()
                //IAM user的accessKeyId
                .accessKeyId(AmazonConfig.INSTANCE.getAmazonIamUserAccessKeyId())
                //IAM user的secretKey
                .secretKey(AmazonConfig.INSTANCE.getAmazonIamUserSecretKey())
                //这里按照amazon对不同region的分区填写，例子是北美地区的
                .region("us-east-1")
                .build();
        AWSAuthenticationCredentialsProvider awsAuthenticationCredentialsProvider = AWSAuthenticationCredentialsProvider.builder()
                //IAM role，特别注意：最好用IAM role当做IAM ARN去申请app
                // 而且IAM user需要添加内联策略STS关联上IAM role，具体操作看：https://www.spapi.org.cn/cn/model2/_2_console.html
                .roleArn(AmazonConfig.INSTANCE.getAmazonIamRoleArn())
                .roleSessionName(AmazonConfig.INSTANCE.getAmazonIamRoleSessionName())
                .build();
        LWAAuthorizationCredentials lwaAuthorizationCredentials = LWAAuthorizationCredentials.builder()
                //申请app后LWA中的clientId
                .clientId(AmazonConfig.INSTANCE.getAmazonAppClientId())
                //申请app后LWA中的clientSecret
                .clientSecret(AmazonConfig.INSTANCE.getAmazonAppClientSecret())
                //店铺授权时产生的refreshToken或者app自授权生成的
                .refreshToken(amazonAuth.getRefreshToken())
                .endpoint("https://api.amazon.com/auth/o2/token")
                .build();
        return new FbaInventoryApi.Builder().awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
                .endpoint("https://sellingpartnerapi-na.amazon.com")
                .build();
    }

    private GetInventorySummariesResponse getInventory(AmazonAuth amazonAuth, FbaInventoryApi fbaInventoryApi, AmazonSyncInfo amazonSyncInfo) throws ApiException {
        GetInventorySummariesResponse response = null;
        String granularityType = Granularity.GranularityTypeEnum.MARKETPLACE.getValue();
        String granularityId = amazonAuth.getMarketplaceId();
        List<String> marketplaceIds = new ArrayList<>();
        marketplaceIds.add(amazonAuth.getMarketplaceId());
        Boolean details = true;
        OffsetDateTime startDateTime = OffsetDateTimeTool2.getOffsetDateTime(amazonSyncInfo.getLastUpdateAfter());
        List<String> sellerSkus = null;
        String nextToken = null;
        if (StringUtils.isEmpty(amazonSyncInfo.getNextToken())) {
                //startDateTime = OffsetDateTimeTool2.getOffsetDateTime(amazonSyncInfo.getLastUpdateAfter());
        } else {
            nextToken = amazonSyncInfo.getNextToken();
        }
        response = fbaInventoryApi.getInventorySummaries(granularityType, granularityId, marketplaceIds, details, startDateTime, sellerSkus, nextToken);
        return response;
    }

    private void dealFbaInventoryInfo(FbaInventoryApi fbaInventoryApi, AmazonAuth amazonAuth, GetInventorySummariesResponse getInventorySummariesResponse, AmazonSyncInfo amazonSyncInfo) throws ApiException {
        if (getInventorySummariesResponse == null) {
            return;
        }
        log.info("dealTime:{},dealFbaInventoryInfo fbaInventoryISize:{}", DateUtil.getFormatSSS(new Date()), getInventorySummariesResponse.getPayload().getInventorySummaries().size());
        getInventorySummariesResponse.getPayload().getInventorySummaries().forEach(item -> {
            AmazonFbaInventory amazonFbaInventory = getAmazonFbaInventoryBySellerSku(item.getSellerSku());
            if (amazonFbaInventory == null) {
                amazonFbaInventory = new AmazonFbaInventory();
                amazonFbaInventory.setMerchantId(amazonAuth.getMerchantId());
                setFbaInventoryInfo(amazonFbaInventory, item);
                amazonFbaInventory.setCreateTime(new Date());
                amazonFbaInventory.setUpdateTime(new Date());
                customAmazonFbaInventoryMapper.insertSelective(amazonFbaInventory);
            } else {
                setFbaInventoryInfo(amazonFbaInventory, item);
                amazonFbaInventory.setUpdateTime(new Date());
                customAmazonFbaInventoryMapper.updateByPrimaryKeySelective(amazonFbaInventory);
            }
        });
        if (getInventorySummariesResponse.getPagination() == null || StringUtils.isEmpty(getInventorySummariesResponse.getPagination().getNextToken())|| CollectionUtils.isEmpty(getInventorySummariesResponse.getPayload().getInventorySummaries())) {
            //没有nextToken表示同步完成
            amazonSyncInfo.setUpdateTime(new Date());
            amazonSyncInfo.setNextToken(null);
            amazonSyncInfo.setLastUpdateAfter(DateUtil.getDateNowUtc());
            customAmazonSyncInfoMapper.updateByPrimaryKey(amazonSyncInfo);
        } else {
            amazonSyncInfo.setNextToken(getInventorySummariesResponse.getPagination().getNextToken());
            amazonSyncInfo.setUpdateTime(new Date());
            customAmazonSyncInfoMapper.updateByPrimaryKey(amazonSyncInfo);
            //获取下页
            GetInventorySummariesResponse response = getInventory(amazonAuth, fbaInventoryApi, amazonSyncInfo);
            if (response == null) {
                return;
            }
            dealFbaInventoryInfo(fbaInventoryApi, amazonAuth, response, amazonSyncInfo);
        }
    }


    private void setFbaInventoryInfo(AmazonFbaInventory amazonFbaInventory, InventorySummary inventorySummary) {
        BeanUtils.copyProperties(inventorySummary, amazonFbaInventory);
        amazonFbaInventory.setConditionStr(inventorySummary.getCondition());
        if(inventorySummary.getInventoryDetails()==null){
            return;
        }
        amazonFbaInventory.setFulfillableQuantity(inventorySummary.getInventoryDetails().getFulfillableQuantity());
        amazonFbaInventory.setInboundReceivingQuantity(inventorySummary.getInventoryDetails().getInboundReceivingQuantity());
        amazonFbaInventory.setInboundWorkingQuantity(inventorySummary.getInventoryDetails().getInboundWorkingQuantity());
        if(inventorySummary.getInventoryDetails().getReservedQuantity()!=null){
            amazonFbaInventory.setTotalReservedQuantity(inventorySummary.getInventoryDetails().getReservedQuantity().getTotalReservedQuantity());
            amazonFbaInventory.setPendingCustomerOrderQuantity(inventorySummary.getInventoryDetails().getReservedQuantity().getPendingCustomerOrderQuantity());
            amazonFbaInventory.setPendingTransshipmentQuantity(inventorySummary.getInventoryDetails().getReservedQuantity().getPendingTransshipmentQuantity());
            amazonFbaInventory.setFcProcessingQuantity(inventorySummary.getInventoryDetails().getReservedQuantity().getFcProcessingQuantity());
        }
        if(inventorySummary.getInventoryDetails().getResearchingQuantity()!=null){
            amazonFbaInventory.setTotalResearchingQuantity(inventorySummary.getInventoryDetails().getResearchingQuantity().getTotalResearchingQuantity());
            amazonFbaInventory.setResearchingQuantityInShortTerm(getResearchingQuantityTerm(inventorySummary.getInventoryDetails().getResearchingQuantity().getResearchingQuantityBreakdown(),ResearchingQuantityEntry.NameEnum.RESEARCHINGQUANTITYINSHORTTERM));
            amazonFbaInventory.setResearchingQuantityInMidUerm(getResearchingQuantityTerm(inventorySummary.getInventoryDetails().getResearchingQuantity().getResearchingQuantityBreakdown(),ResearchingQuantityEntry.NameEnum.RESEARCHINGQUANTITYINMIDTERM));
            amazonFbaInventory.setResearchingQuantityInLongTerm(getResearchingQuantityTerm(inventorySummary.getInventoryDetails().getResearchingQuantity().getResearchingQuantityBreakdown(),ResearchingQuantityEntry.NameEnum.RESEARCHINGQUANTITYINLONGTERM));
        }
        amazonFbaInventory.setUnfulfillableQuantity(inventorySummary.getInventoryDetails().getFulfillableQuantity());
        amazonFbaInventory.setLastUpdatedTime(OffsetDateTimeTool2.getDateTime(inventorySummary.getLastUpdatedTime()));
    }

    private Integer getResearchingQuantityTerm(List<ResearchingQuantityEntry> researchingQuantityBreakdown, ResearchingQuantityEntry.NameEnum nameEnum) {
        Optional<ResearchingQuantityEntry> optional= researchingQuantityBreakdown.stream().filter(item->item.getName().equals(nameEnum)).findFirst();
        if(optional.isPresent()){
            return optional.get().getQuantity();
        }
        return null;
    }

    private AmazonFbaInventory getAmazonFbaInventoryBySellerSku(String sellerSku) {
        AmazonFbaInventoryExample example = new AmazonFbaInventoryExample();
        example.createCriteria().andSellerSkuEqualTo(sellerSku);
        List<AmazonFbaInventory> list = customAmazonFbaInventoryMapper.selectByExample(example);
        if (CollectionUtils.isEmpty(list)) {
            return null;
        }
        return list.get(0);
    }
}
