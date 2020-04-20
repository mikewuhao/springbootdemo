package com.jd.controller;

import com.alibaba.fastjson.JSONObject;
import com.jd.domain.User;
import com.jd.mq.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ProducerService producer;

    @RequestMapping("/push")
    public String pushMsg() {
        User user = new User();
        user.setUsername("wuhao");
        user.setAddress("河北唐山");
        user.setSex("男");
        String msg = JSONObject.toJSONString(user);
        return producer.send("TopicTest", "push", msg);
    }
}