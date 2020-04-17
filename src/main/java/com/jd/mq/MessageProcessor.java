package com.jd.mq;

import org.apache.rocketmq.common.message.MessageExt;

/**
 * @author wuhao
 * @Title: MessageProcessor
 * @Description: mq消息处理接口
 * @date 2020/4/17 17:24
 */
public interface MessageProcessor {

    boolean handle(MessageExt messageExt);
}
