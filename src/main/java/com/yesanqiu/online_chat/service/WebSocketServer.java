package com.yesanqiu.online_chat.service;

import com.yesanqiu.online_chat.entity.Friends;
import com.yesanqiu.online_chat.entity.Message;
import com.yesanqiu.online_chat.entity.NewFriends;
import com.yesanqiu.online_chat.util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;


@ServerEndpoint("/webSocket/{sid}")
@Component
public class WebSocketServer{

    private static FriendsService friendsService;

    private static NewFriendsService newFriendsService;

    private static MessageService messageService;

    @Autowired
    public void setFriendsService(FriendsService friendsService) {
        WebSocketServer.friendsService = friendsService;
    }

    @Autowired
    public void setNewFriendsService(NewFriendsService newFriendsService) {
        WebSocketServer.newFriendsService = newFriendsService;
    }

    @Autowired
    public void setMessageService(MessageService messageService) {
        WebSocketServer.messageService = messageService;
    }

    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static AtomicInteger onlineNum = new AtomicInteger();

    //concurrent包的线程安全Set，用来存放每个客户端对应的WebSocketServer对象。
    private static ConcurrentHashMap<String, Session> sessionPools = new ConcurrentHashMap<>();

    //发送消息
    public void sendMessage(Session session, String message) throws IOException {
        if(session != null){
            synchronized (session) {
                System.out.println("发送数据：" + message);
                session.getBasicRemote().sendText(message);
            }
        }
    }
    //给指定用户发送信息
    public void sendInfo(String userName, String message){
        Session session = sessionPools.get(userName);
        try {
            sendMessage(session, message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //建立连接成功调用
    @OnOpen
    public void onOpen(Session session, @PathParam(value = "sid") String userName){
        sessionPools.put(userName, session);
        addOnlineCount();
        System.out.println(userName + "加入webSocket！当前人数为" + onlineNum);
        try {
            sendMessage(session, "欢迎" + userName + "加入连接！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //关闭连接时调用
    @OnClose
    public void onClose(@PathParam(value = "sid") String userName){
        sessionPools.remove(userName);
        subOnlineCount();
        System.out.println(userName + "断开webSocket连接！当前人数为" + onlineNum);
    }

    //收到客户端信息
    @OnMessage
    public void onMessage(String message) throws IOException{

        int a = MsgUtil.sortMsg(message);
        if(a != 0){
            if (a == 1){
                try {
                    messageService.save(new Message(MsgUtil.sid,MsgUtil.oid,MsgUtil.message));
                    sendInfo(MsgUtil.oid,message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(a == 2){
                try {
                    System.out.println(newFriendsService == null);
                    newFriendsService.save(new NewFriends(MsgUtil.fid,MsgUtil.mid));
                    sendInfo(MsgUtil.fid,message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if(a == 3){
                //添加好友操作
                try {
                    friendsService.save(new Friends(MsgUtil.mUserId,MsgUtil.fUserId));
                    sendInfo(MsgUtil.fUserId,message);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            message = "客户端：" + message + ",已收到";
            System.out.println(message);
        }
//        for (Session session: sessionPools.values()) {
//            try {
//                sendMessage(session, message);
//            } catch(Exception e){
//                e.printStackTrace();
//                continue;
//            }
//        }
    }

    //错误时调用
    @OnError
    public void onError(Session session, Throwable throwable){
        System.out.println("发生错误");
        throwable.printStackTrace();
    }

    public static void addOnlineCount(){
        onlineNum.incrementAndGet();
    }

    public static void subOnlineCount() {
        onlineNum.decrementAndGet();
    }

}
