package com.sky.ddt.entity;

import java.util.Date;

public class WarehousingOrder {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.type
     *
     * @mbg.generated
     */
    private Integer type;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.warehousing_time
     *
     * @mbg.generated
     */
    private Date warehousingTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.batch_number
     *
     * @mbg.generated
     */
    private String batchNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.shop_id
     *
     * @mbg.generated
     */
    private Integer shopId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.produce_order_id
     *
     * @mbg.generated
     */
    private Integer produceOrderId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.status
     *
     * @mbg.generated
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.create_by
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column warehousing_order.update_by
     *
     * @mbg.generated
     */
    private Integer updateBy;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.id
     *
     * @return the value of warehousing_order.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.id
     *
     * @param id the value for warehousing_order.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.type
     *
     * @return the value of warehousing_order.type
     *
     * @mbg.generated
     */
    public Integer getType() {
        return type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.type
     *
     * @param type the value for warehousing_order.type
     *
     * @mbg.generated
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.warehousing_time
     *
     * @return the value of warehousing_order.warehousing_time
     *
     * @mbg.generated
     */
    public Date getWarehousingTime() {
        return warehousingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.warehousing_time
     *
     * @param warehousingTime the value for warehousing_order.warehousing_time
     *
     * @mbg.generated
     */
    public void setWarehousingTime(Date warehousingTime) {
        this.warehousingTime = warehousingTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.batch_number
     *
     * @return the value of warehousing_order.batch_number
     *
     * @mbg.generated
     */
    public String getBatchNumber() {
        return batchNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.batch_number
     *
     * @param batchNumber the value for warehousing_order.batch_number
     *
     * @mbg.generated
     */
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.shop_id
     *
     * @return the value of warehousing_order.shop_id
     *
     * @mbg.generated
     */
    public Integer getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.shop_id
     *
     * @param shopId the value for warehousing_order.shop_id
     *
     * @mbg.generated
     */
    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.produce_order_id
     *
     * @return the value of warehousing_order.produce_order_id
     *
     * @mbg.generated
     */
    public Integer getProduceOrderId() {
        return produceOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.produce_order_id
     *
     * @param produceOrderId the value for warehousing_order.produce_order_id
     *
     * @mbg.generated
     */
    public void setProduceOrderId(Integer produceOrderId) {
        this.produceOrderId = produceOrderId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.status
     *
     * @return the value of warehousing_order.status
     *
     * @mbg.generated
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.status
     *
     * @param status the value for warehousing_order.status
     *
     * @mbg.generated
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.remark
     *
     * @return the value of warehousing_order.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.remark
     *
     * @param remark the value for warehousing_order.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.create_time
     *
     * @return the value of warehousing_order.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.create_time
     *
     * @param createTime the value for warehousing_order.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.create_by
     *
     * @return the value of warehousing_order.create_by
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.create_by
     *
     * @param createBy the value for warehousing_order.create_by
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.update_time
     *
     * @return the value of warehousing_order.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.update_time
     *
     * @param updateTime the value for warehousing_order.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column warehousing_order.update_by
     *
     * @return the value of warehousing_order.update_by
     *
     * @mbg.generated
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column warehousing_order.update_by
     *
     * @param updateBy the value for warehousing_order.update_by
     *
     * @mbg.generated
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }
}