package com.example.img.url.controller;


import com.example.img.url.service.impl.ImageServiceImpl;
import com.example.img.url.utils.ImageFilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author 凝血
 * @Description 用于主页的拦截器
 */
@Controller
public class IndexController {
    ImageFilePathUtil imageFilePathUtil;
    ImageServiceImpl imageService;
    @Value("${user.file.path}")
    private String fileName;
    @Value("${user.ip}")
    private String ip;
    @Resource
    private ResourceLoader resourceLoader;

    @Autowired
    public void setImageFilePathUtil(ImageFilePathUtil imageFilePathUtil) {
        this.imageFilePathUtil = imageFilePathUtil;
    }

    @Autowired
    public void setImageService(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = {"/", "index.html"})
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
}
