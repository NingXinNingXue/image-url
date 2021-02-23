package com.example.img.url.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @author 凝血
 * @Description 通过实现WebMvcConfigurer接口来自定义静态文件夹路径
 */
@Component
public class ResourceConfigurer implements WebMvcConfigurer {
    /**
     * @Description 自定义静态文件夹路径
     * @author 凝血
     */
    @Value("${user.file.path}")
    private String imageFilePath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**").addResourceLocations("file:" + imageFilePath);
    }

}
