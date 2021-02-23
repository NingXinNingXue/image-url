package com.example.img.url.controller;


import com.example.img.url.model.Session;
import com.example.img.url.service.impl.ImageServiceImpl;
import com.example.img.url.service.impl.LoginServiceImpl;
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
 * @Description 拦截个人中心页面的控制器
 */
@Controller
public class PersonalCenterController {
    ImageFilePathUtil imageFilePathUtil;
    ImageServiceImpl imageService;
    @Value("${user.file.path}")
    private String fileName;
    @Value("${user.ip}")
    private String ip;
    @Resource
    private ResourceLoader resourceLoader;
    private LoginServiceImpl loginService;

    @Autowired
    public void setImageFilePathUtil(ImageFilePathUtil imageFilePathUtil) {
        this.imageFilePathUtil = imageFilePathUtil;
    }

    @Autowired
    public void setImageService(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @Autowired
    private void setUserMapper(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @RequestMapping("/personalCenter.html")
    public ModelAndView personalCenter(HttpSession httpSession) {
        Session session = new Session();
        session.setSessionID(httpSession.getId());
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        if (loginService.checkSessionID(session)) {
            modelAndView.setViewName("personalCenter");
            String userName = loginService.getUserName(session);
            modelAndView.addObject("userName", userName);
        }
        return modelAndView;
    }
}
