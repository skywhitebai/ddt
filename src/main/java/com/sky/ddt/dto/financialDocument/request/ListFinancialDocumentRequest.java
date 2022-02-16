package com.sky.ddt.dto.financialDocument.request;

import com.sky.ddt.dto.easyui.request.DataGridRequest;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author sky
 * @Description TODO
 * @date 2022/2/16 22:23
 */
@Data
public class ListFinancialDocumentRequest extends DataGridRequest {
    String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date financialDateStart;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date financialDateEnd;
    String title;
    Integer status;
}
