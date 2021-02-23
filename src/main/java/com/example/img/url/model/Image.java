package com.example.img.url.model;

/**
 * @description: 图片类
 * @author: 凝血
 **/
public class Image {
    private String imageName;
    private String imageURL;
    private String userName;

    public Image() {

    }

    public Image(String imageName, String imageURL, String userName) {
        this.imageName = imageName;
        this.imageURL = imageURL;
        this.userName = userName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
