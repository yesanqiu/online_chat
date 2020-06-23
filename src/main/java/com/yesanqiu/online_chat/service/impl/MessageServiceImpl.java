package com.yesanqiu.online_chat.service.impl;

import com.yesanqiu.online_chat.base.service.impl.BaseServiceImpl;
import com.yesanqiu.online_chat.entity.Friends;
import com.yesanqiu.online_chat.entity.Message;
import com.yesanqiu.online_chat.mapper.FriendsMapper;
import com.yesanqiu.online_chat.mapper.MessageMapper;
import com.yesanqiu.online_chat.service.FriendsService;
import com.yesanqiu.online_chat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl extends BaseServiceImpl<MessageMapper, Message> implements MessageService {
    @Autowired
    private MessageMapper messageMapper;

    @Override
    public List<Message> findMessage(String sId, String oId) {
        return messageMapper.findMessage(sId,oId);
    }
}
