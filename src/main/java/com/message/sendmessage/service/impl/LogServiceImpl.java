package com.message.sendmessage.service.impl;

import com.message.sendmessage.entity.Log;
import com.message.sendmessage.mapper.LogMapper;
import com.message.sendmessage.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service.impl
 * @Author: GXW
 * @CreateTime: 2022-05-25  12:39
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired(required = false)
    private LogMapper logMapper;

    @Override
    public int save(Log log) {
        return logMapper.save(log);
    }
}
