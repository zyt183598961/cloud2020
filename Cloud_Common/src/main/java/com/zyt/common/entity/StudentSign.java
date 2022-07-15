package com.zyt.common.entity;

import lombok.Data;


@Data
public class StudentSign {

    private String userid;

    private String name;

    private String clsname;//班级

    private String stime;//签到时间

    private String type;//类型 ：第一节签到 第二节签到

}