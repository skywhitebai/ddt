package com.sky.ddt.service;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.financialDocument.request.ChangeFinancialDocumentStatusRequest;
import com.sky.ddt.dto.financialDocument.request.ListFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.request.SaveFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.response.ListFinancialDocumentResponse;
import com.sky.ddt.dto.response.BaseResponse;

/**
 * @author sky
 * @Description 财务票据管理
 * @date 2022/2/15 23:16
 */
public interface IFinancialDocumentService {
    PageInfo<ListFinancialDocumentResponse> listFinancialDocument(ListFinancialDocumentRequest params);

    BaseResponse saveFinancialDocument(SaveFinancialDocumentRequest params, Integer dealUserId);

    BaseResponse changeFinancialDocumentStatus(ChangeFinancialDocumentStatusRequest params, Integer dealUserId);
}
