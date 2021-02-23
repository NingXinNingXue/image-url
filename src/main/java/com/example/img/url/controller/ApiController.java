package com.example.img.url.controller;

import com.example.img.url.model.Image;
import com.example.img.url.model.Session;
import com.example.img.url.model.User;
import com.example.img.url.model.dto.JsonResult;
import com.example.img.url.service.impl.ImageServiceImpl;
import com.example.img.url.service.impl.LoginServiceImpl;
import com.example.img.url.service.impl.UserServiceImpl;
import com.example.img.url.utils.DisposeImageUtil;
import com.example.img.url.utils.ImageFilePathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author: 凝血
 * @Description api控制器
 **/
@RequestMapping("/api")
@RestController
public class ApiController {
    ImageFilePathUtil imageFilePathUtil;
    ImageServiceImpl imageService;
    private UserServiceImpl userService;
    private LoginServiceImpl loginService;

    @Autowired
    private void setImageFilePathUtil(ImageFilePathUtil imageFilePathUtil) {
        this.imageFilePathUtil = imageFilePathUtil;
    }

    @Autowired
    private void setImageService(ImageServiceImpl imageService) {
        this.imageService = imageService;
    }

    @Autowired
    private void setUserMapper(UserServiceImpl userService) {
        this.userService = userService;
    }

    @Autowired
    private void setUserMapper(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    /**
     * @author 凝血
     * @Description 上传图片拦截器
     */
    @PostMapping("/upload")
    public JsonResult update(@RequestParam("imageName") String imageName, @RequestParam("imageFile") MultipartFile multipartFile,
                             HttpSession httpSession) {
        Session session = new Session();
        session.setSessionID(httpSession.getId());
        String imageURL = "null";
        String userName = loginService.getUserName(session);
        if (userName == null) {
            userName = "tourist";
        }
        System.out.println("上传的用户名" + userName);
        JsonResult<String> jsonResult = new JsonResult<String>();
        if (DisposeImageUtil.isImage(DisposeImageUtil.getSuffixName(multipartFile.getOriginalFilename()))) {
            imageURL = imageService.addImage(multipartFile, imageName, userName);
            jsonResult.setData(imageURL);
        }
        return jsonResult;
    }

    /**
     * @author 凝血
     * @Description 注册账号拦截器
     */
    @PostMapping("/register")
    public JsonResult register(@RequestParam("userName") String userName,
                               @RequestParam("password") String password,
                               @RequestParam("confirmPassword") String confirmPassword) {
        JsonResult<String> jsonResult = new JsonResult<String>();
        User user = new User(userName, password);
        int addUserResult = userService.addUser(user);
        if (addUserResult == 1000) {
            jsonResult.setMsg("用户注册成功");
            jsonResult.setCode("1000");
        } else if (addUserResult == 1001) {
            jsonResult.setMsg("用户名和密码为空");
            jsonResult.setCode("1001");
        } else if (addUserResult == 1002) {
            jsonResult.setMsg("用户名或者密码不符合要求");
            jsonResult.setCode("1002");
        } else if (addUserResult == 1004) {
            jsonResult.setMsg("用户名重复");
            jsonResult.setCode("1004");
        } else {
            jsonResult.setMsg("添加用户失败，请联系管理人员");
            jsonResult.setCode("1003");
        }
        return jsonResult;
    }

    /**
     * @author 凝血
     * @Description 登陆账号拦截器
     */
    @PostMapping("/login")
    public JsonResult login(@RequestParam("userName") String userName,
                            @RequestParam("password") String password,
                            HttpSession httpSession) {
        User user = new User(userName, password);
        Session session = new Session(httpSession.getId(), userName);
        JsonResult<String> jsonResult = loginService.login(user, session);
        return jsonResult;
    }

    @PostMapping("/upPassword")
    public void upPassword() {

    }

    /**
     * @author 凝血
     * @Description 查看用户所上传的图片拦截器
     */
    @PostMapping("/userImage")
    public List<Image> userImage(HttpSession httpSession) {
        Session session = new Session();
        session.setSessionID(httpSession.getId());
        String userName = loginService.getUserName(session);
        List<Image> imageList = null;
        if (userName != null) {
            System.out.println(userName);
            imageList = imageService.getUserImage(userName);
        }
        return imageList;
    }
}