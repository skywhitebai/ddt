package com.sky.ddt.dto.easyui.response;

import com.github.pagehelper.PageInfo;
import lombok.Data;

import java.util.List;

@Data
public class DataGridResponse<T> {
    Long total;
    List<T> rows;

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
}
