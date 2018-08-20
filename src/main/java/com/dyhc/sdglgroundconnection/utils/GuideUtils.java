package com.dyhc.sdglgroundconnection.utils;

import com.dyhc.sdglgroundconnection.pojo.Guide;

import java.util.List;

/**
 * 导游数据列表显示工具类
 */
public class GuideUtils {
    Integer code;
    String msg;
    long count;
    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    List<Guide> data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<Guide> getData() {
        return data;
    }

    public void setData(List<Guide> data) {
        this.data = data;
    }
}

