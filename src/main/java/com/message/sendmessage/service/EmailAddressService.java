package com.message.sendmessage.service;

import com.message.sendmessage.entity.EmailAddress;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service
 * @Author: GXW
 * @CreateTime: 2022-05-26  16:05
 * @Description: TODO
 * @Version: 1.0
 */
public interface EmailAddressService {

    List<EmailAddress> search(EmailAddress emailAddress);

    int save(EmailAddress emailAddress);

    int delBach(String ids);

    int upd(EmailAddress emailAddress);
}
