package com.yesanqiu.online_chat.service;

import com.yesanqiu.online_chat.base.service.BaseService;
import com.yesanqiu.online_chat.entity.Message;
import com.yesanqiu.online_chat.entity.User;

import java.util.List;

public interface MessageService extends BaseService<Message> {

    List<Message> findMessage(String sId,String oId);

    Message newMessage(String sId,String oId);
}
