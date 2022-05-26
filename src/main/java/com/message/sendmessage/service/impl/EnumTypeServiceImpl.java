package com.message.sendmessage.service.impl;

import com.message.sendmessage.entity.EnumType;
import com.message.sendmessage.mapper.EnumTypeMapper;
import com.message.sendmessage.service.EnumTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service.impl
 * @Author: GXW
 * @CreateTime: 2022-05-25  15:22
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class EnumTypeServiceImpl implements EnumTypeService {

    @Autowired(required = false)
    EnumTypeMapper enumTypeMapper;

    @Override
    public List<EnumType> search() {
        return enumTypeMapper.search();
    }

    @Override
    public int save1(EnumType enumType) {
        return enumTypeMapper.save1(enumType);
    }
}
