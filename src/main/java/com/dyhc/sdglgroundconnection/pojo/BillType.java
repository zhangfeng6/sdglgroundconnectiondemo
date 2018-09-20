package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 单据类型表
 **/
@Table(name = "billtype")
public class BillType {
    @Id
    @Column(name = "billTypeId")
    private int billTypeId; // 单据类型编号
    @Column(name = "typeName")
    private String typeName; // 类型名称（列如：消费单据 ， 服务调查 ， 集体照)
    @Column(name = "whetherDel")
    private Integer whetherDel; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @Column(name = "updateDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateDate; // 修改日期
    @Column(name = "createDate")
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date createDate; // 创建日期
    private String value1;
    private String value2;
    private String value3;
    @Transient
    private  Staff staff;

    /**
     * 获取人员信息
     * @return
     */
    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    @Id
    @Column(name = "billTypeId")
    public int getBillTypeId() {
        return billTypeId;
    }

    public void setBillTypeId(int billTypeId) {
        this.billTypeId = billTypeId;
    }

    @Basic
    @Column(name = "typeName")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
    @Column(name = "updateDate")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        BillType billtype = (BillType) o;
        return billTypeId == billtype.billTypeId &&
                Objects.equals(typeName, billtype.typeName) &&
                Objects.equals(whetherDel, billtype.whetherDel) &&
                Objects.equals(createBy, billtype.createBy) &&
                Objects.equals(updateBy, billtype.updateBy) &&
                Objects.equals(updateDate, billtype.updateDate) &&
                Objects.equals(createDate, billtype.createDate) &&
                Objects.equals(value1, billtype.value1) &&
                Objects.equals(value2, billtype.value2) &&
                Objects.equals(value3, billtype.value3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(billTypeId, typeName, whetherDel, createBy, updateBy, updateDate, createDate, value1, value2, value3);
    }
}
