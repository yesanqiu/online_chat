package com.yesanqiu.online_chat.dto;

import com.yesanqiu.online_chat.entity.Friends;
import com.yesanqiu.online_chat.entity.Message;
import com.yesanqiu.online_chat.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendsDTO {

    private User friends;
    private Message message;
}
