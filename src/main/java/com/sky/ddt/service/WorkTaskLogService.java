package com.sky.ddt.service;

/**
 * @author sky
 * @Description
 * @date 2022/9/12 0:15
 */
public interface WorkTaskLogService {
    void addWorkTaskLog(Integer id, String content, Integer dealUserId);
}
