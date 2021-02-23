package com.example.img.url.mapper;

import com.example.img.url.model.Session;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * @Description:
 * @author: 凝血
 **/
@Repository
public interface SessionMapper {
    /**
     * @param session
     * @return String
     * @Description 通过查询sessionID得到用户名
     * @author 凝血
     */
    @Select("select user_name from session where session_id=#{sessionID}")
    @Results(id = "sessionID", value = {
            @Result(property = "userName", column = "user_name"),
    })
    String selectUserNameBySessionID(Session session);

    /**
     * @param session
     * @return String
     * @Description 通过查询用户名得到sessionID
     * @author 凝血
     */
    @Select("select session_id from session where user_name=#{userName}")
    @Results(id = "userName", value = {
            @Result(property = "sessionID", column = "session_id"),
    })
    String selectSessionIDByUserName(Session session);

    /**
     * @param session
     * @Description 插入用户名和sessionID
     * @author 凝血
     */
    @Insert("INSERT INTO session (user_name,session_id) VALUES (#{userName},#{sessionID})")
    void insertSession(Session session);

    /**
     * @param session
     * @Description 根据userName来更新sessionID
     * @author 凝血
     */
    @Update("UPDATE session SET session_id=#{sessionID} WHERE user_name=#{userName}")
    void upSessionID(Session session);
}
