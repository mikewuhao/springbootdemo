package com.jd.controller;

import com.jd.domain.User;
import com.jd.redis.RedisTemplateService;
import com.jd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @CreateDate: 2020-02-04 20:37
 * @Author: wuhao
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    RedisTemplateService redisTemplateService;

    @GetMapping("/queryUserById")
    public String queryUserById(){
        User currentUser = userService.queryUserById(1L);
        return currentUser.toString();

    }

    @GetMapping("/addUser")
    public void addUser(){
        User newUser = new User();
        newUser.setUsername("小吴");
        newUser.setBirthday("1992-04-04");
        newUser.setSex("男");
        newUser.setAddress("北京市");
        userService.addUser(newUser);

    }

    @GetMapping("/modifyUser")
    public void modifyUser(){
        User currentUser = new User();
        currentUser.setUsername("小吴666");
        currentUser.setBirthday("1992-04-04");
        currentUser.setSex("男");
        currentUser.setAddress("北京市");
        currentUser.setId(1L);
        userService.modifyUser(currentUser);

    }

    @GetMapping("/deleteUserById")
    public void deleteUserById(){
        userService.deleteUserById(3L);

    }

    @GetMapping("/redisTest")
    public String redisTest(){
        User redisUser = new User();
        redisUser.setUsername("小吴redis");
        redisUser.setBirthday("1992-04-04");
        redisUser.setSex("男");
        redisUser.setAddress("北京市通州区");
        redisTemplateService.set("redisKey",redisUser);
        return redisTemplateService.get("redisKey",User.class).toString();

    }


}
