package com.example.img.url.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Description: 图片存放位置工具类
 * @author: 凝血
 **/
@Component
public class ImageFilePathUtil {
    /**
     * 图片存放的实际路径
     */
    @Value("${user.file.path}")
    private String imageFilePath;

    /**
     * @return String
     * @Description 获取图片存放的实际路径
     * @author 凝血
     */
    public String getImageFilePath() {
        return imageFilePath;
    }
}
