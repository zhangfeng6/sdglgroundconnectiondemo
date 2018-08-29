package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 调度餐厅表
 **/
@Table(name = "disrestaurant")
public class Disrestaurant {
    @Id
    @Column(name = "disRestaurantId")
    private int disRestaurantId; // 调度餐厅id
    @Column(name = "typeId")
    private Integer typeId; // 餐馆类型编号（外键，与餐馆类型表关联）
    @Column(name = "offerId")
    private Integer offerId; // 调度信息编号（外键，与报价信息表关联）
    @Column(name = "costPrice")
    private Double costPrice; // 成本价
    @Column(name = "quotePrice")
    private Double quotePrice; // 报价
    @Column(name = "tourismdate")
    private Date tourismdate; // 天数
    @Column(name = "dinDate")
    private Integer dinDate; // 用餐时间（早、中、晚）
    private Integer status; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "upDate")
    private Date upDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    private Date createDate; // 创建时间
    private int weight;  //权重
    @Column(name = "payment")
    private String payment;
    private String value3;

    @Transient
    private String restaurantName;

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    @Transient
    private Integer num;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Column(name = "weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Id
    @Column(name = "disRestaurantId")
    public int getDisRestaurantId() {
        return disRestaurantId;
    }

    public void setDisRestaurantId(int disRestaurantId) {
        this.disRestaurantId = disRestaurantId;
    }

    @Basic
    @Column(name = "typeId")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "offerId")
    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }

    @Basic
    @Column(name = "costPrice")
    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    @Basic
    @Column(name = "quotePrice")
    public Double getQuotePrice() {
        return quotePrice;
    }

    public void setQuotePrice(Double quotePrice) {
        this.quotePrice = quotePrice;
    }

    @Basic
    @Column(name = "tourismdate")
    public Date getTourismdate() {
        return tourismdate;
    }

    public void setTourismdate(Date tourismdate) {
        this.tourismdate = tourismdate;
    }

    @Basic
    @Column(name = "dinDate")
    public Integer getDinDate() {
        return dinDate;
    }

    public void setDinDate(Integer dinDate) {
        this.dinDate = dinDate;
    }

    @Basic
    @Column(name = "status")
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Basic
    @Column(name = "createBy")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "updateBy")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "upDate")
    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    @Basic
    @Column(name = "createDate")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }



    @Basic
    @Column(name = "payment")
    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    @Basic
    @Column(name = "value3")
    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disrestaurant that = (Disrestaurant) o;
        return disRestaurantId == that.disRestaurantId &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(offerId, that.offerId) &&
                Objects.equals(costPrice, that.costPrice) &&
                Objects.equals(quotePrice, that.quotePrice) &&
                Objects.equals(tourismdate, that.tourismdate) &&
                Objects.equals(dinDate, that.dinDate) &&
                Objects.equals(status, that.status) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(upDate, that.upDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(payment, that.payment) &&
                Objects.equals(value3, that.value3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(disRestaurantId, typeId, offerId, costPrice, quotePrice, tourismdate, dinDate, status, createBy, updateBy, upDate, createDate, weight, payment, value3);
    }
}
