package com.sky.ddt.dao.custom;

import com.sky.ddt.dao.generate.FinancialDocumentMapper;
import com.sky.ddt.dto.financialDocument.request.ListFinancialDocumentRequest;
import com.sky.ddt.dto.financialDocument.response.ListFinancialDocumentResponse;

import java.util.List;

/**
 * @author sky
 * @Description 财务票据
 * @date 2022/2/15 23:13
 */
public interface CustomFinancialDocumentMapper extends FinancialDocumentMapper {
    List<ListFinancialDocumentResponse> listFinancialDocument(ListFinancialDocumentRequest params);
}
