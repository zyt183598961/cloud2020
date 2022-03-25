package com.zyt.cloud.provider.util;

import java.util.UUID;

public class UUIDUtils {

    public static String getUserId(){
        String userid = String.valueOf(UUID.randomUUID());
        String userid1 =  userid.replaceAll("-","");
        System.out.println(userid1);
        return userid1;
    }

}
