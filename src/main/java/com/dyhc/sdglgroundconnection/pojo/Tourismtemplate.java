package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.Objects;

/**
 * 模板表
 */
@Table(name = "tourismtemplate")
public class Tourismtemplate {
    @Id
    @Column(name = "tourismId")
    private int tourismId; // 模板id

    @Column(name = "tourismtemplateName")
    private String tourismtemplateName; // 模板名称

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

    @Id
    @Column(name = "tourismId")
    public int getTourismId() {
        return tourismId;
    }

    public void setTourismId(int tourismId) {
        this.tourismId = tourismId;
    }
    @Basic
    @Column(name = "tourismtemplateName")
    public String getTourismtemplateName() {
        return tourismtemplateName;
    }

    public void setTourismtemplateName(String tourismtemplateName) {
        this.tourismtemplateName = tourismtemplateName;
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
        Tourismtemplate tourismtemplate = (Tourismtemplate) o;
        return tourismId == tourismtemplate.tourismId &&
                Objects.equals(tourismtemplateName, tourismtemplate.tourismtemplateName) &&
                Objects.equals(status, tourismtemplate.status) &&
                Objects.equals(createBy, tourismtemplate.createBy) &&
                Objects.equals(updateBy, tourismtemplate.updateBy) &&
                Objects.equals(updateDate, tourismtemplate.updateDate) &&
                Objects.equals(createDate, tourismtemplate.createDate) &&
                Objects.equals(value1, tourismtemplate.value1) &&
                Objects.equals(value2, tourismtemplate.value2) &&
                Objects.equals(value3, tourismtemplate.value3);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tourismId, tourismtemplateName, status, createBy, updateBy, updateDate, createDate, value1, value2, value3);
    }
}
