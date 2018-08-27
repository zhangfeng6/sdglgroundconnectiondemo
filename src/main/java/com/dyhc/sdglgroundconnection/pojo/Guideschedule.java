package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 模板景点表
 **/
@Table(name = "guideschedule")
public class Guideschedule {
    @Id
    @Column(name = "guidescheduleId")
    private int guidescheduleId; // 主键编号
    @Column(name = "guideId")
    private Integer guideId; // 导游编号（外键，与导游信息表关联）
    @Column(name = "arrangeyear")
    private String arrangeyear;
    @Column(name = "arrangemonth")
    private String arrangemonth;
    @Column(name = "arrangeday")
    private String arrangeday;
    @Column(name = "arrangetype")
    private Integer arrangetype;
    @Column(name = "whetherDel")
    private Integer whetherDel; // 是否删除（1代表已删除，0代表未删除）
    private Integer createBy; // 创建人 （外键，与人员表关联）
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updateDate")
    private Date updateDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    private Date createDate; // 创建时间

    @Id
    @Column(name = "guidescheduleId")
    public int getGuidescheduleId() {
        return guidescheduleId;
    }

    public void setGuidescheduleId(int guidescheduleId) {
        this.guidescheduleId = guidescheduleId;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getGuideId() {
        return guideId;
    }

    public void setGuideId(Integer guideId) {
        this.guideId = guideId;
    }

    @Basic
    @Column(name = "templateId")
    public String getArrangeyear() {
        return arrangeyear;
    }

    public void setArrangeyear(String arrangeyear) {
        this.arrangeyear = arrangeyear;
    }

    @Basic
    @Column(name = "templateId")
    public String getArrangemonth() {
        return arrangemonth;
    }

    public void setArrangemonth(String arrangemonth) {
        this.arrangemonth = arrangemonth;
    }

    @Basic
    @Column(name = "templateId")
    public String getArrangeday() {
        return arrangeday;
    }

    public void setArrangeday(String arrangeday) {
        this.arrangeday = arrangeday;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getArrangetype() {
        return arrangetype;
    }

    public void setArrangetype(Integer arrangetype) {
        this.arrangetype = arrangetype;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getWhetherDel() {
        return whetherDel;
    }

    public void setWhetherDel(Integer whetherDel) {
        this.whetherDel = whetherDel;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    @Basic
    @Column(name = "templateId")
    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    @Basic
    @Column(name = "templateId")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Basic
    @Column(name = "templateId")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guideschedule that = (Guideschedule) o;
        return guidescheduleId  == that.guidescheduleId  &&
                Objects.equals(guideId , that.guideId ) &&
                Objects.equals(arrangeyear, that.arrangeyear) &&
                Objects.equals(arrangemonth, that.arrangemonth) &&
                Objects.equals(arrangeday, that.arrangeday) &&
                Objects.equals(arrangetype, that.arrangetype) &&
                Objects.equals(whetherDel, that.whetherDel) &&
                Objects.equals(createBy, that.createBy) &&
                Objects.equals(updateBy, that.updateBy) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(guidescheduleId, guideId, arrangeyear, arrangemonth, arrangeday, arrangetype, whetherDel, createBy, updateBy, createDate, updateDate);
    }
}
