package com.jd.controller;
import com.jd.mq.RocketMQProducer;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author wuhao
 * @Title: RocketMqController
 * @Description: Mq测试 controller
 * @date 2020/4/17 17:38
 */
@RestController
@Slf4j
public class RocketMqController {
    @Autowired
    @Qualifier("rocketMQProducer")
    RocketMQProducer rocketMQProducer;

    @GetMapping("/test")
    public void TestSend() {
        DefaultMQProducer producer = rocketMQProducer.getRocketMQProducer();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String body = "hi RocketMQ, now is  " + sdf.format(new Date()) + ".";
        Message message = new Message("topic2020", "test", body.getBytes());
        try {
            producer.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }






}
