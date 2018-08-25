package com.dyhc.sdglgroundconnection.pojo;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 模板表和线路表关联派生表
 */
@Table(name = "Tourismandline")
public class Tourismandline {
    @Id
    @Column(name = "tourismandlineId")
    private int tourismandlineId; // 模板和每日线路关联id
    @Column(name = "tourismId")
    private int tourismId;//模板id
    @Column(name = "templateId")
    private int templateId;//线路表id
    @Column(name = "howmanydays")
    private int howmanydays;//代表第几天

    @Column(name = "status")
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
    private String value3;


    @Transient
    private String lineName;

    public String getLineName() {
        return lineName;
    }

    public void setLineName(String lineName) {
        this.lineName = lineName;
    }

    @Id
    @Column(name = "tourismId")
    public int getTourismId() {
        return tourismId;
    }

    public void setTourismId(int tourismId) {
        this.tourismId = tourismId;
    }
    @Basic
    @Column(name = "tourismandlineId")
    public int getTourismandlineId() {
        return tourismandlineId;
    }

    public void setTourismandlineId(int tourismandlineId) {
        this.tourismandlineId = tourismandlineId;
    }
    @Basic
    @Column(name = "templateId")
    public int getTemplateId() {
        return templateId;
    }

    public void setTemplateId(int templateId) {
        this.templateId = templateId;
    }

    @Basic
    @Column(name = "howmanydays")
    public int getHowmanydays() {
        return howmanydays;
    }

    public void setHowmanydays(int howmanydays) {
        this.howmanydays = howmanydays;
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
        Tourismandline tourismandline = (Tourismandline) o;
        return tourismandlineId == tourismandline.tourismandlineId &&
                Objects.equals(tourismId, tourismandline.tourismId) &&
                Objects.equals(templateId, tourismandline.templateId) &&
                Objects.equals(howmanydays, tourismandline.howmanydays) &&
                Objects.equals(status, tourismandline.status) &&
                Objects.equals(createBy, tourismandline.createBy) &&
                Objects.equals(updateBy, tourismandline.updateBy) &&
                Objects.equals(updateDate, tourismandline.updateDate) &&
                Objects.equals(createDate, tourismandline.createDate) &&
                Objects.equals(value1, tourismandline.value1) &&
                Objects.equals(value2, tourismandline.value2) &&
                Objects.equals(value3, tourismandline.value3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourismandlineId, tourismId, templateId, howmanydays, status, createBy, updateBy, updateDate, createDate, value1, value2, value3);
    }
}
