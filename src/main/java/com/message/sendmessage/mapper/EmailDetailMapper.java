package com.message.sendmessage.mapper;

import com.message.sendmessage.entity.EmailDetail;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.mapper
 * @Author: GXW
 * @CreateTime: 2022-05-25  14:40
 * @Description: TODO
 * @Version: 1.0
 */
public interface EmailDetailMapper {

    int save(EmailDetail emailDetail);

    List<EmailDetail> sel();
}
