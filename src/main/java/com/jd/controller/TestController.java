package com.jd.controller;

import com.jd.mq.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private ProducerService producer;

    @RequestMapping("/push")
    public String pushMsg(String msg) {
        return producer.send("TopicTest", "push", msg);
    }
}