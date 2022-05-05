package com.message.sendmessage.scheduled;

import com.alibaba.fastjson.JSON;
import com.message.sendmessage.send.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 功能描述：定时任务执行
 *
 * @author gxw96
 */

@Component
public class MyScheduled {
    @Autowired
    private SendMessage sendMessage;

//    @Scheduled(cron = "0 00 22 * * *")
//    public void startup() {
//        String message = SendMessage.getMail();
//        sendMessage.SendMessage("天冷了多加衣，爱你的旺旺", message);
//        System.out.print(new Date().toLocaleString() + " 发送消息：" + message);
//    }
//
//    @Scheduled(cron = "0 00 07 * * *")
//    public void startup1() {
//        String message = SendMessage.getMail();
//        sendMessage.SendMessage("天冷了多加衣，爱你的旺旺", message);
//        System.out.print(new Date().toLocaleString() + " 发送消息：" + message);
//    }

    @Scheduled(cron = "0 */1 * * * ?")
    public void startup1() {

//        JSON message = SendMessage.getMail();
        String message = "呼呼哈嘿";
        sendMessage.SendMessage("世良世良，收到请回答", message);
        System.out.print(new Date().toLocaleString() + " 发送消息：" + message);
    }
}
