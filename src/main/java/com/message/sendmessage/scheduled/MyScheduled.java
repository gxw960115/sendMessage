package com.message.sendmessage.scheduled;

import com.alibaba.fastjson.JSONObject;
import com.message.sendmessage.send.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    @Value("${she.title}")
    private String title;
    @Value("${she.message}")
    private String message;
    @Value("${she.title1}")
    private String title1;
    @Value("${she.message1}")
    private String message1;
    @Value("${she.title2}")
    private String title2;
    @Value("${she.message2}")
    private String message2;
    @Value("${she.title3}")
    private String title3;
    @Value("${she.message3}")
    private String message3;
    @Value("${she.hour}:${she.minute}:${she.second}")
    private String begin;
    @Value("${she.mail}")
    private String who;

    @Scheduled(cron = "0 0/30 17,18,19 * * ?")
    public void startup() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        String end = df.format(new Date());
        Date sd1 = df.parse(begin);
        Date sd2 = df.parse(end);
        if (sd1.after(sd2)) {
            sendMessage.SendMessage(title, message);
            sendMessage.SendMessage(title1, message1);
            System.out.println(title + " 已发送！");
            System.out.println(title1 + " 已发送！");
        } else {
            sendMessage.SendMessage(title2, message2);
            sendMessage.SendMessage(title3, message3);
            System.out.println(title2 + " 已发送！");
            System.out.println(title3 + " 已发送！");
        }
    }

    //    @Scheduled(cron = "0 0/30 9,10,11,12,13,14,15,16,17,18 * * ?")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void startup2() {
        sendMessage.SendMessage("喝水提醒", "天气炎热！莫生气！莫激动！\n又到喝水时间了！多多喝水呀！");
        System.out.println("发给 " + who + " 的 喝水提醒 已于 " + new Date().toLocaleString() + " 发送");
    }

    //    @Scheduled(cron = "0 0/1 * * * ?")
    public void startup1() {

        JSONObject object = JSONObject.parseObject(SendMessage.getMail());
        String list = object.get("data").toString();
        // 先去掉{}
        String replace = list.replace("{", "").replace("}", "");
        // 根据,把字符串分割成字符串数组
        String[] split = replace.split(",");
        String s = split[0];
        String[] split1 = s.split(":");
        String message = split1[1].replace("\"", "");
        sendMessage.sendHtmlMessage("幽默段子", message);
        System.out.print(new Date().toLocaleString() + " 发送消息：" + message);
    }
}
