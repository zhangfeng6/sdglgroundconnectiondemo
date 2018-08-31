package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * 接团信息表
 */
@Table(name = "cluster")
public class Cluster {
    @Id
    @Column(name = "clusterId")
    private int clusterId; // 接团表
    @Column(name = "dispatchId")
    private int dispatchId;//调度表id
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "clusterTime")
    private Date clusterTime;//接团日期
    @Column(name = "clusterAdderss")
    private String clusterAdderss;//接团地点
    @Column(name = "clusterNo")
    private String clusterNo;//车次


    @Column(name = "whetherDel")
    private Integer whetherDel; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @Column(name = "upadateDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date upadateDate; // 修改日期
    @Column(name = "createDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createDate; // 创建日期

    @Id
    @Column(name = "clusterId")
    public int getClusterId() {
        return clusterId;
    }

    public void setClusterId(int clusterId) {
        this.clusterId = clusterId;
    }
    @Basic
    @Column(name = "dispatchId")
    public int getDispatchId() {
        return dispatchId;
    }

    public void setDispatchId(int dispatchId) {
        this.dispatchId = dispatchId;
    }
    @Basic
    @Column(name = "clusterTime")
    public Date getClusterTime() {
        return clusterTime;
    }

    public void setClusterTime(Date clusterTime) {
        this.clusterTime = clusterTime;
    }
    @Basic
    @Column(name = "clusterAdderss")
    public String getClusterAdderss() {
        return clusterAdderss;
    }

    public void setClusterAdderss(String clusterAdderss) {
        this.clusterAdderss = clusterAdderss;
    }
    @Basic
    @Column(name = "clusterNo")
    public String getClusterNo() {
        return clusterNo;
    }

    public void setClusterNo(String clusterNo) {
        this.clusterNo = clusterNo;
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
    @Column(name = "upadateDate")
    public Date getUpadateDate() {
        return upadateDate;
    }

    public void setUpadateDate(Date upadateDate) {
        this.upadateDate = upadateDate;
    }
    @Basic
    @Column(name = "createDate")
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
        Cluster billtype = (Cluster) o;
        return clusterId == billtype.clusterId &&
                Objects.equals(dispatchId, billtype.dispatchId) &&
                Objects.equals(clusterTime, billtype.clusterTime) &&
                Objects.equals(clusterAdderss, billtype.clusterAdderss) &&
                Objects.equals(clusterNo, billtype.clusterNo) &&
                Objects.equals(whetherDel, billtype.whetherDel) &&
                Objects.equals(createBy, billtype.createBy) &&
                Objects.equals(updateBy, billtype.updateBy) &&
                Objects.equals(createDate, billtype.createDate) &&
                Objects.equals(upadateDate, billtype.upadateDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(clusterId, dispatchId, clusterTime, clusterAdderss, clusterNo, whetherDel, createBy, updateBy, createDate, upadateDate);
    }
}
