package com.message.sendmessage.entity;

import lombok.Data;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.entity
 * @Author: GXW
 * @CreateTime: 2022-05-26  15:55
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class EmailAddress {
    Integer id;
    String emailNumber;
    Integer transceiverType;
    Integer emailType;
    String identification;
}
