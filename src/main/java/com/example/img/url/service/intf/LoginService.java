package com.example.img.url.service.intf;

import com.example.img.url.model.Session;
import com.example.img.url.model.User;
import com.example.img.url.model.dto.JsonResult;
import org.springframework.stereotype.Service;

/**
 * @description: 登录服务类
 * @author: 凝血
 **/
@Service
public interface LoginService {
    /**
     * @param user,session
     * @return JsonResult
     * @author 凝血
     * @Description 登录操作，主要验证账号和密码，账号和密码一致时登录成功，并把当前游览器提供的SessionID写到数据库
     * SessionID用于短暂的免登录
     */
    JsonResult login(User user, Session session);

    /**
     * @param session
     * @return boolean 数据库存在该SessionID返回true，不存在返回false
     * @author 凝血
     * @Description 通过SessionID检查该用户是否登录
     */
    boolean checkSessionID(Session session);

    /**
     * @param session
     * @return String 用户名
     * @author 凝血
     * @Description 通过SessionID获取用户名
     */
    String getUserName(Session session);
}
