package com.yesanqiu.online_chat.base.util;


import com.yesanqiu.online_chat.base.dto.ResultDTO;
import com.yesanqiu.online_chat.config.ErrorCode;

/**
 * @author ReMidDream
 * @date 2018-02-22 15:55
 **/
public class ResultUtil {

    public static ResultDTO Success(Object object){
        ResultDTO<Object> resultDto = new ResultDTO<Object>();
        resultDto.setData(object);
        resultDto.setMsg("成功");
        resultDto.setCode("200");
        return resultDto;
    }

    public static ResultDTO Success(){
        return Success(null);
    }

    public static ResultDTO Error(String code, String msg){
        ResultDTO resultDto = new ResultDTO();
        resultDto.setMsg(msg);
        resultDto.setCode(code);
        return resultDto;
    }

    public static ResultDTO Error(ErrorCode errorCodeMsg){
        ResultDTO resultDto = new ResultDTO();
        resultDto.setMsg(errorCodeMsg.getMsg());
        resultDto.setCode(errorCodeMsg.getCode());
        return resultDto;
    }
}
