package com.message.sendmessage.send;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.IOException;

/**
 * @author gxw96
 */
@Component
public class SendMessage {
    @Autowired
    private JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String fromName;
    @Value("${she.mail}")
    private String[] sheMail;

    public void SendMessage(String subject, String message) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromName);
            helper.setTo(sheMail);
            helper.setSubject(subject);
            helper.setText(message);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendHtmlMessage(String subject, String message) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage);
            helper.setFrom(fromName);
            helper.setTo(sheMail);
            helper.setSubject(subject);
            //true 使用html 方式发送
            helper.setText(message, true);
            mailSender.send(helper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取语句
     *
     * @return
     */
    public static String getMail() {
        try {
            // 创建客户端对象
            HttpClient client = HttpClients.createDefault();
            /*创建地址 https://du.shadiao.app/api.php*/
            HttpGet get = new HttpGet("https://api.shadiao.app/chp");
            // 发起请求，接收响应对象
            HttpResponse response = client.execute(get);
            //获取响应体，响应数据是一种基于HTTP协议标准字符串的对象
            //响应体和响应头，都是封装HTTP协议数据。直接使用可能出现乱码或解析错误
            HttpEntity entity = response.getEntity();
            System.out.println(entity);
            // 通过HTTP实体工具类，转换响应体数据
            String resourceString = EntityUtils.toString(entity);
            return resourceString;
        } catch (IOException e) {
            throw new RuntimeException("网站获取语句失败");
        }
    }
}
