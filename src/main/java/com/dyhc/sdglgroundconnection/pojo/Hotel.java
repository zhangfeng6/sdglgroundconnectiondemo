package com.dyhc.sdglgroundconnection.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * this class by created wuyongfei on 2018/6/5 13:50
 * 酒店表
 **/
@Table(name = "hotel")
public class Hotel implements Serializable {
    @Id
    @Column(name = "hotelId")
    private int hotelId; // 酒店编号
    @Column(name = "hotelName")
    private String hotelName; // 名称
    @Column(name = "starHotel")
    private Integer starHotel; // 星级
    @Column(name = "hotelAddress")
    private String hotelAddress; // 地址
    @Column(name = "picturePath")
    private String picturePath; // 图片地址
    @Column(name = "breakfast")
    private Integer breakfast; // 是否提供早餐
    @Column(name = "contacts")
    private String contacts; // 联系人
    @Column(name = "phone")
    private String phone; // 联系电话
    @Column(name = "hotelDescribe")
    private String hotelDescribe; // 酒店描述
    @Column(name = "remarks")
    private String remarks; // 备注
    @Column(name = "costprice")
    private Integer costprice; // 成本价
    @Column(name = "offer")
    private Integer offer; // 报价
    @Column(name = "status")
    private Integer status; // 状态（1为可用，0为禁用）
    @Column(name = "whetherDel")
    private Integer whetherDel; // 是否删除（1代表已删除，0代表未删除）
    @Column(name = "createBy")
    private Integer createBy; // 创建人 （外键，与人员表关联）
    @Column(name = "updateBy")
    private Integer updateBy; // 修改人（外键，与人员表关联）
    @Column(name = "updateDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateDate; // 修改日期
    @JsonFormat(pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "createDate")
    private Date createDate; // 创建时间
    private String value1;
    private String value2;
    private String value3;

    @Transient
    private Integer gettypeprice; //存放用户选定类型的价格 避免再次查询降低速度

    public Integer getGettypeprice() {
        return gettypeprice;
    }

    public void setGettypeprice(Integer gettypeprice) {
        this.gettypeprice = gettypeprice;
    }

    /**
     *存放酒店房间信息
     */
    @Transient
    private List<RoomType> roomTypesList;

    public List<RoomType> getRoomTypesList() {
        return roomTypesList;
    }

    public void setRoomTypesList(List<RoomType> roomTypesList) {
        this.roomTypesList = roomTypesList;
    }

    @Id
    @Column(name = "hotelId")
    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }

    @Basic
    @Column(name = "hotelName")
    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    @Basic
    @Column(name = "starHotel")
    public Integer getStarHotel() {
        return starHotel;
    }

    public void setStarHotel(Integer starHotel) {
        this.starHotel = starHotel;
    }

    @Basic
    @Column(name = "hotelAddress")
    public String getHotelAddress() {
        return hotelAddress;
    }

    public void setHotelAddress(String hotelAddress) {
        this.hotelAddress = hotelAddress;
    }

    @Basic
    @Column(name = "picturePath")
    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
    }

    @Basic
    @Column(name = "breakfast")
    public Integer getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(Integer breakfast) {
        this.breakfast = breakfast;
    }

    @Basic
    @Column(name = "contacts")
    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "hotelDescribe")
    public String getHotelDescribe() {
        return hotelDescribe;
    }

    public void setHotelDescribe(String hotelDescribe) {
        this.hotelDescribe = hotelDescribe;
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
    @Column(name = "costprice")
    public Integer getCostprice() {
        return costprice;
    }

    public void setCostprice(Integer costprice) {
        this.costprice = costprice;
    }

    @Basic
    @Column(name = "offer")
    public Integer getOffer() {
        return offer;
    }

    public void setOffer(Integer offer) {
        this.offer = offer;
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
        Hotel hotel = (Hotel) o;
        return hotelId == hotel.hotelId &&
                Objects.equals(hotelName, hotel.hotelName) &&
                Objects.equals(starHotel, hotel.starHotel) &&
                Objects.equals(hotelAddress, hotel.hotelAddress) &&
                Objects.equals(picturePath, hotel.picturePath) &&
                Objects.equals(breakfast, hotel.breakfast) &&
                Objects.equals(contacts, hotel.contacts) &&
                Objects.equals(phone, hotel.phone) &&
                Objects.equals(hotelDescribe, hotel.hotelDescribe) &&
                Objects.equals(remarks, hotel.remarks) &&
                Objects.equals(costprice, hotel.costprice) &&
                Objects.equals(offer, hotel.offer) &&
                Objects.equals(status, hotel.status) &&
                Objects.equals(whetherDel, hotel.whetherDel) &&
                Objects.equals(createBy, hotel.createBy) &&
                Objects.equals(updateBy, hotel.updateBy) &&
                Objects.equals(updateDate, hotel.updateDate) &&
                Objects.equals(createDate, hotel.createDate) &&
                Objects.equals(value1, hotel.value1) &&
                Objects.equals(value2, hotel.value2) &&
                Objects.equals(value3, hotel.value3);
    }

    @Override
    public int hashCode() {

        return Objects.hash(hotelId, hotelName, starHotel, hotelAddress, picturePath, breakfast, contacts, phone, hotelDescribe, remarks, costprice, offer, status, whetherDel, createBy, updateBy, updateDate, createDate, value1, value2, value3);
    }
}
