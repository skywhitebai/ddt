package com.sky.ddt.entity;

import java.util.Date;

public class LabelPrint {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.title
     *
     * @mbg.generated
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.create_by
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column label_print.update_by
     *
     * @mbg.generated
     */
    private Integer updateBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.id
     *
     * @return the value of label_print.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.id
     *
     * @param id the value for label_print.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.title
     *
     * @return the value of label_print.title
     *
     * @mbg.generated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.title
     *
     * @param title the value for label_print.title
     *
     * @mbg.generated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.remark
     *
     * @return the value of label_print.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.remark
     *
     * @param remark the value for label_print.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.create_time
     *
     * @return the value of label_print.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.create_time
     *
     * @param createTime the value for label_print.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.create_by
     *
     * @return the value of label_print.create_by
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.create_by
     *
     * @param createBy the value for label_print.create_by
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.update_time
     *
     * @return the value of label_print.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.update_time
     *
     * @param updateTime the value for label_print.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column label_print.update_by
     *
     * @return the value of label_print.update_by
     *
     * @mbg.generated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column label_print.update_by
     *
     * @param updateBy the value for label_print.update_by
     *
     * @mbg.generated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}