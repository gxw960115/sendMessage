package com.message.sendmessage.utils;

import java.util.UUID;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.utils
 * @Author: GXW
 * @CreateTime: 2022-05-25  14:22
 * @Description: TODO
 * @Version: 1.0
 */
public class UuidUtil {

    public static String getUuid() {
        return UUID.randomUUID().toString().trim().replaceAll("-", "");
    }
}
