package com.example.img.url.service.impl;

import com.example.img.url.mapper.SessionMapper;
import com.example.img.url.model.Session;
import com.example.img.url.model.User;
import com.example.img.url.model.dto.JsonResult;
import com.example.img.url.service.intf.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 登录服务类
 * @author: 凝血
 **/
@Service
public class LoginServiceImpl implements LoginService {
    UserServiceImpl userService;
    @Resource
    private SessionMapper sessionMapper;

    @Autowired
    private void setImageFilePathUtil(UserServiceImpl userService) {
        this.userService = userService;
    }

    /**
     * @param user,session
     * @return JsonResult
     * @author 凝血
     * @Description 登录操作，主要验证账号和密码，账号和密码一致时登录成功，并把当前游览器提供的SessionID写到数据库
     * SessionID用于短暂的免登录
     */
    @Override
    public JsonResult login(User user, Session session) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        if (userService.selectUser(user)) {
            if (sessionMapper.selectSessionIDByUserName(session) == null) {
                sessionMapper.insertSession(session);
            } else {
                sessionMapper.upSessionID(session);
            }
            jsonResult.setMsg("登录成功");
            jsonResult.setCode("1100");
            return jsonResult;
        } else {
            jsonResult.setMsg("用户名或密码错误");
            jsonResult.setCode("1101");
        }
        return jsonResult;
    }

    /**
     * @param session
     * @return boolean 数据库存在该SessionID返回true，不存在返回false
     * @author 凝血
     * @Description 通过SessionID检查该用户是否登录
     */
    @Override
    public boolean checkSessionID(Session session) {
        if (sessionMapper.selectUserNameBySessionID(session) != null) {
            return true;
        }
        return false;
    }

    /**
     * @param session
     * @return String 用户名
     * @author 凝血
     * @Description 通过SessionID获取用户名
     */
    @Override
    public String getUserName(Session session) {
        String userName = sessionMapper.selectUserNameBySessionID(session);
        if (userName != null) {
            return userName;
        }
        return null;
    }
}
