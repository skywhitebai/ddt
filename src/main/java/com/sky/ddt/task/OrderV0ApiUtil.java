package com.sky.ddt.task;

import com.amazon.spapi.SellingPartnerAPIAA.AWSAuthenticationCredentials;
import com.amazon.spapi.SellingPartnerAPIAA.AWSAuthenticationCredentialsProvider;
import com.amazon.spapi.SellingPartnerAPIAA.LWAAuthorizationCredentials;
import com.amazon.spapi.api.OrdersV0Api;
import com.sky.ddt.dto.amazon.AmazonConfig;
import com.sky.ddt.entity.AmazonAuth;

public class OrderV0ApiUtil {
    public static OrdersV0Api getOrdersV0Api(AmazonAuth amazonAuth) {
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
        return new OrdersV0Api.Builder()
                .awsAuthenticationCredentials(awsAuthenticationCredentials)
                .lwaAuthorizationCredentials(lwaAuthorizationCredentials)
                .awsAuthenticationCredentialsProvider(awsAuthenticationCredentialsProvider)
                .endpoint("https://sellingpartnerapi-na.amazon.com")
                .build();
    }
}
