package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 *  调度导游表
 **/
@Table(name = "disguide")
public class Disguide {
    @Id
    @Column(name = "disGuideId")
    private int disGuideId; // 调度导游id
    @Column(name = "guideId")
    private Integer guideId; // 导游编号（外键，与导游表关联）
    @Column(name = "offerId")
    private Integer offerId; // 调度信息编号（外键，与报价信息表关联）
    private Integer status; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updateDate")
    private Date updateDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    private Date createDate; // 创建时间
    private String value1;
    private String value2;
    private String value;

    @Transient
    private String guideName;
    @Transient
    private String certificate;
    @Transient
    private String telephone;
    @Transient
    private Integer num;
    @Transient
    private String tourist;
    @Transient
    private String travelStartTime;
    @Transient
    private String travelEndTime;

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getTourist() {
        return tourist;
    }

    public void setTourist(String tourist) {
        this.tourist = tourist;
    }

    public String getTravelStartTime() {
        return travelStartTime;
    }

    public void setTravelStartTime(String travelStartTime) {
        this.travelStartTime = travelStartTime;
    }

    public String getTravelEndTime() {
        return travelEndTime;
    }

    public void setTravelEndTime(String travelEndTime) {
        this.travelEndTime = travelEndTime;
    }

    @Id
    @Column(name = "disGuideId")
    public int getDisGuideId() {
        return disGuideId;
    }

    public void setDisGuideId(int disGuideId) {
        this.disGuideId = disGuideId;
    }

    @Basic
    @Column(name = "guideId")
    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
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
    @Column(name = "updateDate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date upDate) {
        this.updateDate = upDate;
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
    @Column(name = "value1")
    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    @Basic
    @Column(name = "value2")
    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    @Basic
    @Column(name = "value")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Disguide disguide = (Disguide) o;
        return disGuideId == disguide.disGuideId &&
                Objects.equals(guideId, disguide.guideId) &&
                Objects.equals(offerId, disguide.offerId) &&
                Objects.equals(status, disguide.status) &&
                Objects.equals(createBy, disguide.createBy) &&
                Objects.equals(updateBy, disguide.updateBy) &&
                Objects.equals(updateDate, disguide.updateDate) &&
                Objects.equals(createDate, disguide.createDate) &&
                Objects.equals(value1, disguide.value1) &&
                Objects.equals(value2, disguide.value2) &&
                Objects.equals(value, disguide.value);
    }

    @Override
    public int hashCode() {

        return Objects.hash(disGuideId, guideId, offerId, status, createBy, updateBy, updateDate, createDate, value1, value2, value);
    }
}
