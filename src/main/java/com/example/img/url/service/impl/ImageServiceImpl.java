package com.example.img.url.service.impl;

import com.example.img.url.mapper.ImageMapper;
import com.example.img.url.model.Image;
import com.example.img.url.utils.DisposeImageUtil;
import com.example.img.url.utils.ImageFilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @Description: 图片服务类
 * @author: 凝血
 **/
@Service
public class ImageServiceImpl implements com.example.img.url.service.intf.ImageService {
    ImageFilePathUtil imageFilePathUtil;
    @Value("${user.ip}")
    private String ip;
    @Value("${server.port}")
    private String port;
    @Resource
    private ImageMapper imageMapper;

    @Autowired
    public void setImageFilePathUtil(ImageFilePathUtil imageFilePathUtil) {
        this.imageFilePathUtil = imageFilePathUtil;
    }

    /**
     * @param multipartFile
     * @return String 储存完的图片名字
     * @author 凝血
     * @Description 把multipartFile里面的图片存储到user.file.path的位置
     */
    @Override
    public String addImage(MultipartFile multipartFile, String imageName, String userName) {
        String imageFileName = "null";
        try {
            // 保存图片
            String suffixName = DisposeImageUtil.getSuffixName(multipartFile.getOriginalFilename());
            Path path = Paths.get(imageFilePathUtil.getImageFilePath());
            Path pathCreate = Files.createDirectories(path);
            File file = DisposeImageUtil.generatedImageFile(imageFilePathUtil.getImageFilePath(), suffixName);
            imageFileName = file.getName();
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String imageURL = "http://" + ip + ":" + port + "/image/" + imageFileName;
        Image image = new Image(imageName, imageURL, userName);
        imageMapper.insertImage(image);
        return imageURL;
    }

    /**
     * @param
     * @return
     * @author 凝血
     * @Description 删除图片（未完成）
     */
    @Override
    public void delImage(String imageURL) {

    }

    /**
     * @param userName
     * @return List 图片List
     * @author 凝血
     * @Description 获取图片List
     */
    @Override
    public List getUserImage(String userName) {
        List<Image> imageList = imageMapper.selectImageByUserName(userName);
        return imageList;
    }

    /**
     * @param
     * @return
     * @author 凝血
     * @Description 在不改变图片链接的前提下替换图片（未完成）
     */
    @Override
    public void updateImage() {

    }
}
