package com.yesanqiu.online_chat.util;

import lombok.extern.slf4j.Slf4j;
import tk.mybatis.mapper.util.StringUtil;

@Slf4j
public class MsgUtil {

    public static String oid;
    public static String sid;
    public static String message;
    public static String fid;
    public static String mid;
    public static String mUserId;
    public static String fUserId;



    public static int sortMsg(String msg){
        if(StringUtil.isNotEmpty(msg)){
            log.info("sortMsg");
            System.out.println(msg);
            char a = msg.charAt(1);
            log.info("a:" + a);
            if(a == 'M'){
                log.info("M");
                //#M:oid:sid#qq#message
                System.out.println(msg.indexOf(":"));
                oid = msg.substring(3,13);
                sid = msg.substring(14,msg.lastIndexOf("#qq#"));
                message = msg.substring(msg.lastIndexOf("#qq#")+1,msg.length());
                System.out.println("oid:" +oid+",message:" + message);
                return 1;
            }
            if(a == 'F'){
                log.info("F");
                //#F:mid:fid
                mid = msg.substring(3,msg.lastIndexOf(":"));
                fid = msg.substring(msg.lastIndexOf(":")+1,msg.length());
                System.out.println("mid:" +mid +",fid:" + fid);
                return 2;
            }
            if(a == 'Y'){
                log.info("Y");
                //#Y:mUserId:fUserId
                mUserId = msg.substring(3,msg.lastIndexOf(":"));
                fUserId = msg.substring(msg.lastIndexOf(":")+1,msg.length());
                System.out.println("mUserId:" + mUserId+ ",fUserId:" + fUserId);
                return 3;
            }
        }
        return 0;
    }

}
