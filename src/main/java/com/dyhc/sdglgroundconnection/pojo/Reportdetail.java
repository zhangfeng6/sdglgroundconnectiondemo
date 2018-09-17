package com.dyhc.sdglgroundconnection.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 导游报账明细表
 **/
@Table(name = "reportdetail")
public class Reportdetail {
    @Id
    @Column(name = "reportDetailId")
    private int reportDetailId; // 导游报账明细表编号
    @Column(name = "dispatchId")
    private Integer dispatchId; // 调度编号（外键，与调度表关联）
    @JsonFormat(pattern = "yyyy-MM-dd",timezone ="GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "`reportDate`")
    private Date reportDate; // 报账日期
    @Column(name = "`receipt`")
    private Double receipt; // 外收团款
    @Column(name = "totalPayable")
    private Double totalPayable; // 导游现付合计
    @Column(name = "typeCode")
    private String typeCode; // 结余编码（外键，与字典表关联）
    @Column(name = "valueId")
    private Integer valueId; // 结余类型编号（外键，与字典表关联）
    @Column(name = "balanceAmount")
    private Double balanceAmount; // 结余金额
    @Column(name  ="remarks")
    private String remarks; // 备注
    @Column(name = "`status`")
    private Integer status; // 状态（1、审核中 2、以结算 3、未通过）
    @Column(name = "whetherDel")
    private Integer whetherDel; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "`upDate`")
    private Date upDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "`createDate`")
    private Date createDate; // 创建时间
    @Transient
    private String groupNumber;     //组团社团号

    public String getGroundConnectionNumber() {
        return groundConnectionNumber;
    }

    public void setGroundConnectionNumber(String groundConnectionNumber) {
        this.groundConnectionNumber = groundConnectionNumber;
    }

    @Transient
    private String groundConnectionNumber;     //地接社团号
    @Transient
    private String guideName;       //导游姓名
    @Transient
    List<Reportaccommodation> reportaccommodationShow;//导游报价住宿集合
    @Transient
    List<Reportrestaurant> reportrestaurant;//导游报价餐厅集合
    @Transient
    List<Reportticket> reportticket;//导游报价门票集合
    @Transient
    private  Reportfare reportfare;//导游报价车费
    @Transient
    private  Reportqutsubsidy reportqutsubsidy;//导游报价出团补助
    @Transient
    private  Reportingotherexpenses reportingotherexpenses;//导游报账其他支出表

    public Reportfare getReportfare() {
        return reportfare;
    }

    public void setReportfare(Reportfare reportfare) {
        this.reportfare = reportfare;
    }

    public Reportqutsubsidy getReportqutsubsidy() {
        return reportqutsubsidy;
    }

    public void setReportqutsubsidy(Reportqutsubsidy reportqutsubsidy) {
        this.reportqutsubsidy = reportqutsubsidy;
    }

    public Reportingotherexpenses getReportingotherexpenses() {
        return reportingotherexpenses;
    }

    public void setReportingotherexpenses(Reportingotherexpenses reportingotherexpenses) {
        this.reportingotherexpenses = reportingotherexpenses;
    }

    public List<Reportaccommodation> getReportaccommodationShow() {
        return reportaccommodationShow;
    }

    public void setReportaccommodationShow(List<Reportaccommodation> reportaccommodationShow) {
        this.reportaccommodationShow = reportaccommodationShow;
    }

    public List<Reportrestaurant> getReportrestaurant() {
        return reportrestaurant;
    }

    public void setReportrestaurant(List<Reportrestaurant> reportrestaurant) {
        this.reportrestaurant = reportrestaurant;
    }

    public List<Reportticket> getReportticket() {
        return reportticket;
    }

    public void setReportticket(List<Reportticket> reportticket) {
        this.reportticket = reportticket;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public String getGuideName() {
        return guideName;
    }

    public void setGuideName(String guideName) {
        this.guideName = guideName;
    }

    private String value1;
    private String value2;
    private String value3;

    @Id
    @Column(name = "reportDetailId")
    public int getReportDetailId() {
        return reportDetailId;
    }

    public void setReportDetailId(int reportDetailId) {
        this.reportDetailId = reportDetailId;
    }

    @Basic
    @Column(name = "dispatchId")
    public Integer getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(Integer dispatchId) {
        this.dispatchId = dispatchId;
    }

    @Basic
    @Column(name = "reportDate")
    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    @Basic
    @Column(name = "receipt")
    public Double getReceipt() {
        return receipt;
    }

    public void setReceipt(Double receipt) {
        this.receipt = receipt;
    }

    @Basic
    @Column(name = "totalPayable")
    public Double getTotalPayable() {
        return totalPayable;
    }

    public void setTotalPayable(Double totalPayable) {
        this.totalPayable = totalPayable;
    }

    @Basic
    @Column(name = "typeCode")
    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    @Basic
    @Column(name = "valueId")
    public Integer getValueId() {
        return valueId;
    }

    public void setValueId(Integer valueId) {
        this.valueId = valueId;
    }

    @Basic
    @Column(name = "balanceAmount")
    public Double getBalanceAmount() {
        return balanceAmount;
    }

    public void setBalanceAmount(Double balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    @Basic
    @Column(name = "remarks")
    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
    @Column(name = "whetherDel")
    public Integer getWhetherDel() {
        return whetherDel;
    }

    public void setWhetherDel(Integer whetherDel) {
        this.whetherDel = whetherDel;
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
        Reportdetail that = (Reportdetail) o;
        return reportDetailId == that.reportDetailId &&
                Objects.equals(dispatchId, that.dispatchId) &&
                Objects.equals(reportDate, that.reportDate) &&
                Objects.equals(receipt, that.receipt) &&
                Objects.equals(totalPayable, that.totalPayable) &&
                Objects.equals(typeCode, that.typeCode) &&
                Objects.equals(valueId, that.valueId) &&
                Objects.equals(balanceAmount, that.balanceAmount) &&
                Objects.equals(remarks, that.remarks) &&
                Objects.equals(status, that.status) &&
                Objects.equals(whetherDel, that.whetherDel) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(upDate, that.upDate) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(value1, that.value1) &&
                Objects.equals(value2, that.value2) &&
                Objects.equals(value3, that.value3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(reportDetailId, dispatchId, reportDate, receipt, totalPayable, typeCode, valueId, balanceAmount, remarks, status, whetherDel, createBy, updateBy, upDate, createDate, value1, value2, value3);
    }
}
