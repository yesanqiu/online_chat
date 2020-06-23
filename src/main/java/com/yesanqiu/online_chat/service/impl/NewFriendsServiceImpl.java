package com.yesanqiu.online_chat.service.impl;

import com.yesanqiu.online_chat.base.service.impl.BaseServiceImpl;
import com.yesanqiu.online_chat.entity.NewFriends;
import com.yesanqiu.online_chat.mapper.NewFriendsMapper;
import com.yesanqiu.online_chat.service.NewFriendsService;
import org.springframework.stereotype.Service;

@Service
public class NewFriendsServiceImpl extends BaseServiceImpl<NewFriendsMapper, NewFriends> implements NewFriendsService {
}
