package com.yesanqiu.online_chat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@EnableSwagger2
@MapperScan("com.yesanqiu.online_chat.mapper")
public class OnlineChatApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlineChatApplication.class, args);
    }

}
