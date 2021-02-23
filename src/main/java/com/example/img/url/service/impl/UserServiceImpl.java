package com.example.img.url.service.impl;

import com.example.img.url.mapper.UserMapper;
import com.example.img.url.model.User;
import com.example.img.url.service.intf.UserService;
import com.example.img.url.utils.UserUtil;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description: 用户服务类
 * @author: 凝血
 **/
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    /**
     * @param user
     * @return boolean 用户名和密码正确返回true，错误返回false
     * @author 凝血
     * @Description 检测用户名与密码是否存在
     */
    @Override
    public boolean selectUser(User user) {
        if (userMapper.selectUserNameAndPassword(user) != null) {
            return true;
        }
        return false;
    }

    /**
     * @param user
     * @return int 1000是添加用户成功，1001是用户名和密码为空，1002是用户名或者密码不符合要求，1003为添加用户失败
     * 1004为用户名重复
     * @author 凝血
     * @Description
     */
    @Override
    public int addUser(User user) {
        if (UserUtil.checkUserIsNULL(user) == 0) {
            return 1001;
        }
        int userResult = UserUtil.checkUserName(user.getUserName());
        int passwordResult = UserUtil.checkPassword(user.getPassword());
        if (userResult == 0 && passwordResult == 0) {
            try {
                userMapper.insertUser(user);
            } catch (DataIntegrityViolationException e) {
                System.out.println(e);
                return 1004;
            } catch (Exception e) {
                System.out.println(e);
                return 1003;
            }
            return 1000;
        } else if (userResult == 1 || passwordResult == 1) {
            return 1002;
        }
        System.out.println("最后");
        return 1003;
    }

    /**
     * @param user
     * @return boolean 删除成功返回true，删除失败返回false
     * @author 凝血
     * @Description 根据userName来删除用户
     */
    @Override
    public boolean deleteUser(User user) {
        try {
            userMapper.deleteUserByUserName(user);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }

    /**
     * @param user
     * @return boolean 更新密码成功返回true，更新密码失败返回false
     * @author 凝血
     * @Description 根据userName来更新用户密码
     */
    @Override
    public boolean upPassword(User user) {
        try {
            userMapper.upPassword(user);
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
        return true;
    }
}