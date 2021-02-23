package com.example.img.url.mapper;

import com.example.img.url.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: 凝血
 **/
@Repository
public interface UserMapper {
    /**
     * @param user 包涵的userName和password属性必须有值
     * @return User
     * @Description 通过查询UserName和Password在数据库里面是否返回null来确定账号密码是否正确，
     * 可通过检测返回的userName是否为null来判断，有null则该账号密码不正确
     * @author 凝血
     */
    @Select("select user_name from user where user_name=#{userName} and password=#{password}")
    @Results(id = "user", value = {
            @Result(property = "userName", column = "user_name")
    })
    String selectUserNameAndPassword(User user);

    /**
     * @param user User包涵的userName和password属性必须有值
     * @Description 插入用户
     * @author 凝血
     */
    @Insert("INSERT INTO user (user_name,password) VALUES (#{userName},#{password})")
    void insertUser(User user);

    /**
     * @param user User User包涵的userName和password属性必须有值
     * @Description 根据userName来更新用户密码
     * @author 凝血
     */
    @Update("UPDATE user SET password=#{password} WHERE user_name=#{userName}")
    void upPassword(User user);

    /**
     * @param user
     * @Description 根据userName来删除用户
     * @author 凝血
     * @author
     */
    @Delete("DELETE FROM user WHERE user_name=#{userName}")
    void deleteUserByUserName(User user);
}
