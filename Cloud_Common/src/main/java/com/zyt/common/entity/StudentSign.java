package com.zyt.common.entity;

import lombok.Data;

import java.util.Date;

@Data
public class StudentSign {
    private Integer id;
    private String name;
    private String clsname;//班级
    private String stime;//签到时间
    private String type;//类型 ：第一节签到 第二节签到
}