package com.example.img.url.mapper;

import com.example.img.url.model.Image;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:
 * @author: 凝血
 **/
@Repository
public interface ImageMapper {
    /**
     * @param imageName
     * @return Image
     * @Description 通过用户名搜索该用户的所有图片信息
     * @author 凝血
     */
    @Select("select image_name,image_url,user_name from image where user_name=#{userName}")
    @Results(id = "imageURL", value = {
            @Result(property = "imageName", column = "image_name"),
            @Result(property = "imageURL", column = "image_url"),
            @Result(property = "userName", column = "user_name"),
    })
    List<Image> selectImageByUserName(String imageName);

    /**
     * @param image
     * @Description 插入图片相关信息
     * @author 凝血
     */
    @Insert("INSERT INTO image (image_name,image_url,user_name) VALUES (#{imageName},#{imageURL},#{userName})")
    void insertImage(Image image);

    /**
     * @param image
     * @Description 根据imageURL来删除图片信息
     * @author 凝血
     */
    @Delete("DELETE FROM image WHERE image_url=#{imageURL}")
    void deleteImageByImageURL(Image image);
}
