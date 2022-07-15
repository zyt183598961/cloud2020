package com.zyt.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class WeatherPo {

    private int id;

    private String city;

    private String cityCode;

    private Date date;

    private String week;

    //天气
    private String weather;

    //最高温
    private String tempHigh;

    //最低温
    private String tempLow;

    //风向
    private String windDirect;

    //风力
    private String windPower;

    private Date createDate;


}
