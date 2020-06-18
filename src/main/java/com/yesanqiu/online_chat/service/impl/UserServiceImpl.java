package com.yesanqiu.online_chat.service.impl;

import com.yesanqiu.online_chat.base.service.impl.BaseServiceImpl;
import com.yesanqiu.online_chat.entity.User;
import com.yesanqiu.online_chat.mapper.UserMapper;
import com.yesanqiu.online_chat.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User> implements UserService {
}
