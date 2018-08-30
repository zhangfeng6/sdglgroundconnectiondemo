package com.dyhc.sdglgroundconnection.parameterentity;

import com.dyhc.sdglgroundconnection.pojo.*;

import java.util.List;

public class DispatchParameter {
    //调度表对象
    private Dispatch dispatch;
    //调度导游表对象
    private Disguide disguide;
    //接团信息表对象
    private Cluster cluster;
    //调度用车表对象
    private Discar discar;
    //调度其他表对象
    private Disother disother;
    //调度酒店表集合
    private List<Dispatchhotel> dispatchhotelList;
    //调度线路信息集合
    private List<HoteroomType> hoteroomTypeList;
    //调度景点信息集合
    private List<Disattr> disattrList;
    //调度购物地集合
    private List<Disshopp> disshoppList;
    //调度餐厅表集合
    private List<Disrestaurant> disrestaurantList;
    //报价单id
    private Integer offerId;

    //getter/setter方法
    public Dispatch getDispatch() {
        return dispatch;
    }

    public void setDispatch(Dispatch dispatch) {
        this.dispatch = dispatch;
    }

    public Disguide getDisguide() {
        return disguide;
    }

    public void setDisguide(Disguide disguide) {
        this.disguide = disguide;
    }

    public Cluster getCluster() {
        return cluster;
    }

    public void setCluster(Cluster cluster) {
        this.cluster = cluster;
    }

    public Discar getDiscar() {
        return discar;
    }

    public void setDiscar(Discar discar) {
        this.discar = discar;
    }

    public Disother getDisother() {
        return disother;
    }

    public void setDisother(Disother disother) {
        this.disother = disother;
    }

    public List<Dispatchhotel> getDispatchhotelList() {
        return dispatchhotelList;
    }

    public void setDispatchhotelList(List<Dispatchhotel> dispatchhotelList) {
        this.dispatchhotelList = dispatchhotelList;
    }

    public List<HoteroomType> getHoteroomTypeList() {
        return hoteroomTypeList;
    }

    public void setHoteroomTypeList(List<HoteroomType> hoteroomTypeList) {
        this.hoteroomTypeList = hoteroomTypeList;
    }

    public List<Disattr> getDisattrList() {
        return disattrList;
    }

    public void setDisattrList(List<Disattr> disattrList) {
        this.disattrList = disattrList;
    }

    public List<Disshopp> getDisshoppList() {
        return disshoppList;
    }

    public void setDisshoppList(List<Disshopp> disshoppList) {
        this.disshoppList = disshoppList;
    }

    public List<Disrestaurant> getDisrestaurantList() {
        return disrestaurantList;
    }

    public void setDisrestaurantList(List<Disrestaurant> disrestaurantList) {
        this.disrestaurantList = disrestaurantList;
    }
    public Integer getOfferId() {
        return offerId;
    }

    public void setOfferId(Integer offerId) {
        this.offerId = offerId;
    }
}
