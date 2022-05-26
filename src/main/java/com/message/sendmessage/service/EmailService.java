package com.message.sendmessage.service;

import com.message.sendmessage.entity.EmailDetail;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service
 * @Author: GXW
 * @CreateTime: 2022-05-25  14:46
 * @Description: TODO
 * @Version: 1.0
 */
public interface EmailService {

    int save(EmailDetail emailDetail);

    List<EmailDetail> sel();
}
