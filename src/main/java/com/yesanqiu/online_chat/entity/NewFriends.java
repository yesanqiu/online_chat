package com.yesanqiu.online_chat.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "new_friends")
public class NewFriends {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "n_id")
    private Integer nId;

    @Column(name = "f_id")
    private String fId;

    @Column(name = "m_id")
    private String mId;

    public static final String N_ID = "nId";

    public static final String F_ID = "fId";

    public static final String M_ID = "mId";

    public NewFriends(String fId,String mId){
        this.fId = fId;
        this.mId = mId;
    }
    public NewFriends(String fId){
        this.fId = fId;
    }
}