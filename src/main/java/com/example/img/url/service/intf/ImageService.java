package com.example.img.url.service.intf;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
/**
 * @description: 图片服务类
 * @author: 凝血
 **/
@Service
public interface ImageService {
    /**
     * @param multipartFile
     * @return String 储存完的图片名字
     * @author 凝血
     * @Description 把multipartFile里面的图片存储到user.file.path的位置
     */
    String addImage(MultipartFile multipartFile, String imageName, String userName);

    /**
     * @author 凝血
     * @Description 删除图片
     */
    void delImage(String imageURL);

    /**
     * @param userName
     * @return List 图片List
     * @author 凝血
     * @Description 获取图片List
     */
    List getUserImage(String userName);

    /**
     * @author 凝血
     * @Description 在不改变图片链接的前提下替换图片
     */
    void updateImage();
}
