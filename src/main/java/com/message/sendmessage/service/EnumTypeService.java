package com.message.sendmessage.service;

import com.message.sendmessage.entity.EnumType;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service.impl
 * @Author: GXW
 * @CreateTime: 2022-05-25  15:21
 * @Description: TODO
 * @Version: 1.0
 */
//@Service
public interface EnumTypeService {
    public List<EnumType> search();

    int save1(EnumType enumType);
}
