package com.yesanqiu.online_chat.service.impl;

import com.yesanqiu.online_chat.base.service.impl.BaseServiceImpl;
import com.yesanqiu.online_chat.entity.Friends;
import com.yesanqiu.online_chat.mapper.FriendsMapper;
import com.yesanqiu.online_chat.service.FriendsService;
import org.springframework.stereotype.Service;

@Service
public class FriendsServiceImpl extends BaseServiceImpl<FriendsMapper, Friends> implements FriendsService {
}
