package com.example.img.url.service.intf;

import com.example.img.url.model.User;
import org.springframework.stereotype.Service;

/**
 * @description:用户服务类
 * @author: 凝血
 **/
@Service
public interface UserService {
    /**
     * @param user
     * @return boolean 用户名和密码正确返回true，错误返回false
     * @author 凝血
     * @Description 检测用户名与密码是否存在
     */
    boolean selectUser(User user);

    /**
     * @param user
     * @return int 1000是添加用户成功，1001是用户名和密码为空，1002是用户名或者密码不符合要求，1003为添加用户失败
     * 1004为用户名重复
     * @author 凝血
     * @Description 添加用户
     */
    int addUser(User user);

    /**
     * @param user
     * @return boolean 删除成功返回true，删除失败返回false
     * @author 凝血
     * @Description 根据userName来删除用户
     */
    boolean deleteUser(User user);

    /**
     * @param user
     * @return boolean 更新密码成功返回true，更新密码失败返回false
     * @author 凝血
     * @Description 根据userName来更新用户密码
     */
    boolean upPassword(User user);
}
