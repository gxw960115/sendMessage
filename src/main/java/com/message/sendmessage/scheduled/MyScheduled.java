package com.message.sendmessage.scheduled;

import com.alibaba.fastjson.JSONObject;
import com.message.sendmessage.entity.EmailDetail;
import com.message.sendmessage.entity.Log;
import com.message.sendmessage.send.SendMessage;
import com.message.sendmessage.service.EmailService;
import com.message.sendmessage.service.LogService;
import com.message.sendmessage.utils.UuidUtil;
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
    @Autowired
    private LogService logService;
    @Autowired
    private EmailService emailService;
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
    @Value("${spring.mail.username}")
    private String fromWho;


    @Scheduled(cron = "0 0/30 17,18,19 * * ?")
//    @Scheduled(cron = "0 0/1 * * * ?")
    public void startup() throws ParseException {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Log log = new Log();
        EmailDetail emailDetail = new EmailDetail();
        String end = df.format(new Date());
        Date sd1 = df.parse(begin);
        Date sd2 = df.parse(end);
        if (sd1.after(sd2)) {
            sendMessage.SendMessage(title, message);
            String uuid = UuidUtil.getUuid();
            log.setSender(fromWho);
            log.setReceiver(who);
            log.setEmailtype(2);
            log.setEmailid(uuid);
            logService.save(log);
            emailDetail.setId(uuid);
            emailDetail.setMessage(message);
            emailDetail.setTitle(title);
            emailService.save(emailDetail);
            sendMessage.SendMessage(title1, message1);
            uuid = UuidUtil.getUuid();
            log.setSender(fromWho);
            log.setReceiver(who);
            log.setEmailtype(3);
            log.setEmailid(uuid);
            logService.save(log);
            emailDetail.setId(uuid);
            emailDetail.setMessage(message1);
            emailDetail.setTitle(title1);
            emailService.save(emailDetail);
            System.out.println(title + " 已发送！");
            System.out.println(title1 + " 已发送！");
        } else {
            sendMessage.SendMessage(title2, message2);
            String uuid = UuidUtil.getUuid();
            log.setSender(fromWho);
            log.setReceiver(who);
            log.setEmailtype(2);
            log.setEmailid(uuid);
            logService.save(log);
            emailDetail.setId(uuid);
            emailDetail.setMessage(message2);
            emailDetail.setTitle(title2);
            emailService.save(emailDetail);
            sendMessage.SendMessage(title3, message3);
            uuid = UuidUtil.getUuid();
            log.setSender(fromWho);
            log.setReceiver(who);
            log.setEmailtype(3);
            log.setEmailid(uuid);
            logService.save(log);
            emailDetail.setId(uuid);
            emailDetail.setMessage(message3);
            emailDetail.setTitle(title3);
            emailService.save(emailDetail);
            System.out.println(title2 + " 已发送！");
            System.out.println(title3 + " 已发送！");
        }
    }

//    @Scheduled(cron = "0 0/30 9,10,11,12,13,14,15,16,17,18 * * ?")
    @Scheduled(cron = "0 0/1 * * * ?")
    public void startup2() {
        sendMessage.SendMessage("喝水提醒", "天气炎热！莫生气！莫激动！\n又到喝水时间了！多多喝水呀！");
        String uuid = UuidUtil.getUuid();
        System.out.println("发给 " + who.replace(",", " 和 ") + " 的 喝水提醒 已于 " + new Date().toLocaleString() + " 发送");
        Log log = new Log();
        log.setId(1);
        log.setSender(fromWho);
        log.setReceiver(who);
        log.setEmailtype(1);
        log.setEmailid(uuid);
        log.setTimeofreceipt(new Date());
        EmailDetail emailDetail = new EmailDetail();
        emailDetail.setId(uuid);
        emailDetail.setMessage("天气炎热！莫生气！莫激动！\n又到喝水时间了！多多喝水呀！");
        emailDetail.setTitle("喝水提醒");
        emailService.save(emailDetail);
        logService.save(log);
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
