package com.example.img.url.utils;

import com.example.img.url.model.User;

/**
 * @description: 用户工具类
 * @author: 凝血
 **/

public class UserUtil {
    /**
     * @param password 密码
     * @return int 密码是包含大写字母、小写字母、数字、特殊符号（不是字母，数字，下划线，汉字的字符）11~32位组合就返回0，
     * 不是则返回1
     * @author 凝血
     * @Description 检测密码是否为包含大写字母、小写字母、数字、特殊符号（不是字母，数字，下划线，汉字的字符）11~32位组合
     */
    public static int checkPassword(String password) {
        String regex = "^(?![A-Za-z0-9]+$)(?![a-z0-9\\W]+$)(?![A-Za-z\\W]+$)(?![A-Z0-9\\W]+$)[a-zA-Z0-9\\W]{11,32}$";
        if (password.matches(regex)) {
            return 0;
        }
        return 1;
    }

    /**
     * @param userName 用户名
     * @return int 用户名为3~12位汉字、字母、数字的组合返回0，不是则返回1
     * @author 凝血
     * @Description 检测用户名是否为3~12位汉字、字母、数字的组合，
     */
    public static int checkUserName(String userName) {
        String regex = "^(?!_)(?!.*?_$)[a-zA-Z0-9_\\u4e00-\\u9fa5]{3,12}$";
        if (userName.matches(regex)) {
            return 0;
        }
        return 1;
    }

    /**
     * @param user 用户
     * @return int 用户名和密码是NULL返回0，不是则返回1
     * @author 凝血
     * @Description 检测user的用户名和密码是否NULL
     */
    public static int checkUserIsNULL(User user) {
        if (user.getUserName().equals("") && user.getPassword().equals("")) {
            return 0;
        }
        return 1;
    }
}