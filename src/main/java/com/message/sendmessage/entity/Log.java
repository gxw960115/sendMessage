package com.message.sendmessage.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.entity
 * @Author: GXW
 * @CreateTime: 2022-05-25  12:20
 * @Description: TODO
 * @Version: 1.0
 */
@Data
public class Log implements Serializable {

    Integer id;
    String sender;
    String receiver;
    Date timeofreceipt;
    Integer emailtype;
    String emailid;
}
