package com.yesanqiu.online_chat;

import com.yesanqiu.online_chat.entity.User;
import com.yesanqiu.online_chat.service.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Data
public class GetIds implements CommandLineRunner {


    private List<String> ids;
    @Autowired
    private UserService userService;
    @Override
    public void run(String... args) throws Exception {
        System.out.println("run");
        ids = new ArrayList<>();
        for(User u:userService.findAll()){
            ids.add(u.getUserId());
            System.out.println(u.getUserId());
        }
    }
}
