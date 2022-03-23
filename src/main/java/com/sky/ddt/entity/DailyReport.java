package com.sky.ddt.entity;

import java.util.Date;

public class DailyReport {
    private Integer id;

    private Date reportDay;

    private String todayWorkContent;

    private String tomorrowWorkPlan;

    private Integer userId;

    private Byte type;

    private Integer createBy;

    private Date createTime;

    private Integer updateBy;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getReportDay() {
        return reportDay;
    }

    public void setReportDay(Date reportDay) {
        this.reportDay = reportDay;
    }

    public String getTodayWorkContent() {
        return todayWorkContent;
    }

    public void setTodayWorkContent(String todayWorkContent) {
        this.todayWorkContent = todayWorkContent == null ? null : todayWorkContent.trim();
    }

    public String getTomorrowWorkPlan() {
        return tomorrowWorkPlan;
    }

    public void setTomorrowWorkPlan(String tomorrowWorkPlan) {
        this.tomorrowWorkPlan = tomorrowWorkPlan == null ? null : tomorrowWorkPlan.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}