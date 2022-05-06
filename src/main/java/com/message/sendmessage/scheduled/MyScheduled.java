package com.message.sendmessage.scheduled;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.message.sendmessage.send.SendMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * 功能描述：定时任务执行
 *
 * @author gxw96
 */

@Component
public class MyScheduled {
    @Autowired
    private SendMessage sendMessage;

    @Scheduled(cron = "0 */1 * * * ?")
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
        sendMessage.SendMessage("世良世良，收到请回答", message);

        System.out.print(new Date().toLocaleString() + " 发送消息：" + message);
    }
}
