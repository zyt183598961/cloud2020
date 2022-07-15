package com.zyt.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;


public class DateUtil {

    private static final SimpleDateFormat simDf = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    //获取今天的日期
    public static String getDate(){
        return simDf.format(new Date());
    }


    //查询今日剩下的秒数
    public static int getSeconds(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date=sdf.parse(getDate()+" 23:59:59");
            return (int)(date.getTime()-System.currentTimeMillis())/1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(DateUtil.getDate());
    }

}
