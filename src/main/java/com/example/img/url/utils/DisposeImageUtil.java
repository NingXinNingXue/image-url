package com.example.img.url.utils;

import java.io.File;
import java.util.UUID;
/**
 * @Description: 图片处理工具类
 * @author: 凝血
 **/
public class DisposeImageUtil {
    /**
     * @return String
     * @Description 获取没有-符号间隔开来的uuid
     * @author 凝血
     */
    public static String getNoIntervalUUID() {
        String s = UUID.randomUUID().toString();
        return s.replace("-", "");
    }

    /**
     * @param filename 文件名字
     * @return java.lang.String
     * @Description 通过 . 来获取文件的后缀名
     * @author 凝血
     */
    public static String getSuffixName(String filename) {
        String suffixName = filename.substring(filename.lastIndexOf("."));
        //把后缀名字变成小写
        suffixName = suffixName.toLowerCase();
        return suffixName;
    }

    /**
     * @param suffixName 后缀名
     * @return boolean
     * @Description 检测后缀名字是否为图片的后缀，是则返回true，否则返回false
     * @author 凝血
     */
    public static boolean isImage(String suffixName) {
        return (suffixName.equals(".jpeg") || suffixName.equals(".jpg") || suffixName.equals(".png")
                || suffixName.equals(".gif") || suffixName.equals(".svg") || suffixName.equals(".bmp")
                || suffixName.equals(".ico") || suffixName.equals(".tiff"));
    }

    /**
     * @param suffixName 文件实际存储的位置
     * @param suffixName 文件的后缀名
     * @return File
     * @Description 通过uuid和后缀名形成一个File对象
     * @author 凝血
     */

    public static File generatedImageFile(String imageFilePath, String suffixName) {
        String uuid = getNoIntervalUUID();
        String fileName = uuid + suffixName;
        File file = new File(imageFilePath + "/" + uuid + suffixName);
        return file;
    }
}
