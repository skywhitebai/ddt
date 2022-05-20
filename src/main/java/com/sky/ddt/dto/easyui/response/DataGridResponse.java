package com.sky.ddt.dto.easyui.response;

import com.github.pagehelper.PageInfo;
import com.sky.ddt.dto.finance.response.FinancialStatementExport;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class DataGridResponse<T> {
    Long total;
    List<T> rows;

    private static DataGridResponse instance;

    static {
        instance = new DataGridResponse();
        instance.setTotal(0L);
        instance.setRows(new ArrayList());
    }

    public static DataGridResponse create(PageInfo page) {
        DataGridResponse dataGridResponse = new DataGridResponse();
        dataGridResponse.setTotal(page.getTotal());
        dataGridResponse.setRows(page.getList());
        return dataGridResponse;
    }

    public DataGridResponse() {
    }

    public DataGridResponse(PageInfo page) {
        this.total = page.getTotal();
        this.rows = page.getList();
    }

    public static DataGridResponse getInstance() {
        return instance;
    }

    public static DataGridResponse create(List list) {
        DataGridResponse dataGridResponse = new DataGridResponse();
        if (list != null) {
            dataGridResponse.setTotal((long) list.size());
        }
        dataGridResponse.setRows(list);
        return dataGridResponse;
    }
}
