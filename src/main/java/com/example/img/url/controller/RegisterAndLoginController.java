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
import javax.servlet.http.HttpSession;

/**
 * @author 凝血
 * @Description 拦截注册和登录页面的控制器
 */
@Controller
public class RegisterAndLoginController {
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

    @RequestMapping("/register.html")
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping("/login.html")
    public ModelAndView login(HttpSession httpSession) {
        System.out.println(httpSession.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
}
