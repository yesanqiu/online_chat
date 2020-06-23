package com.yesanqiu.online_chat.entity;

import java.util.Date;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "m_id")
    private Integer mId;

    @Column(name = "s_id")
    private String sId;

    @Column(name = "o_id")
    private String oId;

    private String msg;

    private Date time;

    public static final String M_ID = "mId";

    public static final String S_ID = "sId";

    public static final String O_ID = "oId";

    public static final String MSG = "msg";

    public static final String TIME = "time";

    public Message(String sId,String oId,String msg){
        this.sId = sId;
        this.oId = oId;
        this.msg = msg;
        this.time = new Date();
    }
}