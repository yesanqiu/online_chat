package com.yesanqiu.online_chat.controller;

import com.yesanqiu.online_chat.GetIds;
import com.yesanqiu.online_chat.base.dto.ResultDTO;
import com.yesanqiu.online_chat.base.util.ResultUtil;
import com.yesanqiu.online_chat.config.ErrorCode;
import com.yesanqiu.online_chat.entity.User;
import com.yesanqiu.online_chat.service.FriendsService;
import com.yesanqiu.online_chat.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private FriendsService friendsService;

    @Autowired
    private GetIds getIds;

    @PostMapping("/register")
    public ResultDTO register(String password)throws Exception{
        log.info("接口：register");
        if(" ".equals(password) || password == null){
            log.info("密码不能为空");
            return ResultUtil.Error(ErrorCode.REGISTRE_FAIL_EMPTY_PSW);
        }
        if(password.length()<6){
            log.info("密码长度小于6个字符");
            return ResultUtil.Error(ErrorCode.REGISTRE_FAIL_SHORT_PSW);
        }
        String userId = get_id(10);
        List<String> list = getIds.getIds();
        list.add(userId);
        getIds.setIds(list);
        User user =new User(userId,password);
        log.info("成功注册");
        return ResultUtil.Success(userService.save(user));
    }

    @PostMapping("/login")
    public ResultDTO login(String userId, String password, HttpServletRequest request)throws Exception{
        log.info("接口：login");
        if(" ".equals(userId) || userId == null){
            log.info("账户不能为空");
            return ResultUtil.Error(ErrorCode.LOGIN_FAIL_EMPTY_ID);
        }
        if(userId.length()<10){
            log.info("账户长度不正确");
            return ResultUtil.Error(ErrorCode.LOGIN_FAIL_SHORT_ID);
        }
        if(" ".equals(password) || password == null){
            log.info("密码不能为空");
            return ResultUtil.Error(ErrorCode.LOGIN_FAIL_EMPTY_PSW);
        }
        if(password.length()<6){
            log.info("密码长度小于6个字符");
            return ResultUtil.Error(ErrorCode.LOGIN_FAIL_SHORT_PSW);
        }
        User u = userService.get(userId);
        if(u.getPassword().equals(password)){
            request.getSession().setAttribute("user",u);
            log.info("登录成功");
            return ResultUtil.Success();
        }else{
            log.info("登录失败");
            return ResultUtil.Error(ErrorCode.LOGIN_FAIL_ERROR_PSW);
        }
    }

//    @PostMapping("/addFriends")
//    public ResultDTO addFriends(String userId,HttpServletRequest request)throws Exception{
//        log.info("接口：addFriends");
//        User u = (User) request.getSession().getAttribute("user");
//        if(u == null){
//            log.info("未登录");
//            return ResultUtil.Error(ErrorCode.UNLOGIN);
//        }
//
//
//    }


    public String getId(int idsLength){
        String r = "";
        Random random = new Random();
        int index = 0;
        while(index< idsLength){
            int i = random.nextInt(10);
            if(index == 0) {
                while (i == 0) {
                    i = random.nextInt(10);
                }
            }
            r += i;
            index++;
        }
        for(String id:getIds.getIds()){
            if(id.equals(r)){
                return "f";
            }
        }
        return r;

    }

    public String get_id(int idsLength){
        String r = getId(idsLength);
        while("f".equals(r)){
            r = getId(idsLength);
        }
        return r;
    }

}
