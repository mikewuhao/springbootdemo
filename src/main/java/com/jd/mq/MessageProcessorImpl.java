package com.jd.mq;

import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Service;

/**
 * @author wuhao
 * @Title: MessageProcessorImpl
 * @Description: 消息处理类
 * @date 2020/4/17 17:27
 */
@Service
public class MessageProcessorImpl implements MessageProcessor {
    @Override
    public boolean handle(MessageExt messageExt) {
        // 收到的body（消息体），字节类型，需转为String
        String result = new String(messageExt.getBody());
        System.out.println("监听到了消息，消息为："+ result);
        return true;
    }
}
