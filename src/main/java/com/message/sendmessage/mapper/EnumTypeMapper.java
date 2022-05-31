package com.message.sendmessage.mapper;

import com.message.sendmessage.entity.EnumType;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.mapper
 * @Author: GXW
 * @CreateTime: 2022-05-25  17:55
 * @Description: TODO
 * @Version: 1.0
 */
public interface EnumTypeMapper {
    int save1(EnumType enumType);

    List<EnumType> search();

    int upd(EnumType enumType);

    int del(EnumType enumType);

    int delBach(List<String> ids);
}
