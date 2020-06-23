package com.yesanqiu.online_chat.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Friends {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "f_id")
    private Integer fId;

    @Column(name = "m_user_id")
    private String mUserId;

    @Column(name = "f_user_id")
    private String fUserId;

    public static final String F_ID = "fId";

    public static final String M_USER_ID = "mUserId";

    public static final String F_USER_ID = "fUserId";

    public Friends(String mUserId,String fUserId){
        this.mUserId = mUserId;
        this.fUserId = fUserId;
    }
    public Friends(String mUserId,int m){
        if(m == 1){
            this.mUserId = mUserId;
        }else{
            this.fUserId = mUserId;
        }
    }

}