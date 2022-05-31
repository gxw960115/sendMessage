package com.message.sendmessage.mapper;

import com.message.sendmessage.entity.EmailAddress;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.mapper
 * @Author: GXW
 * @CreateTime: 2022-05-26  15:57
 * @Description: TODO
 * @Version: 1.0
 */
public interface EmailAddressMapper {

    List<EmailAddress> search(EmailAddress emailAddress);

    int save(EmailAddress emailAddress);

    int delBach(List<String> ids);

    int upd(EmailAddress emailAddress);
}
