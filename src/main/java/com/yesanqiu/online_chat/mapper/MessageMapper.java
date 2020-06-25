package com.yesanqiu.online_chat.mapper;

import com.yesanqiu.online_chat.entity.Message;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MessageMapper extends Mapper<Message> {

    @Select("select * from message where s_id = #{sId} and o_id = #{oId} ORDER BY time DESC; ")
    @ResultMap("BaseResultMap")
    List<Message> findMessage(String sId,String oId);

    @Select("select * from message where s_id = #{sId} and o_id = #{oId} ORDER BY time DESC limit 1;")
    @ResultMap("BaseResultMap")
    Message newMessage(String sId,String oId);
}