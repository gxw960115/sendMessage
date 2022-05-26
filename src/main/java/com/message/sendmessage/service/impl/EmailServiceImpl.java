package com.message.sendmessage.service.impl;

import com.message.sendmessage.entity.EmailDetail;
import com.message.sendmessage.mapper.EmailDetailMapper;
import com.message.sendmessage.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service.impl
 * @Author: GXW
 * @CreateTime: 2022-05-25  14:47
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class EmailServiceImpl implements EmailService {
    @Autowired(required = false)
    private EmailDetailMapper emailDetailMapper;

    @Override
    public int save(EmailDetail emailDetail) {
        return emailDetailMapper.save(emailDetail);
    }

    @Override
    public List<EmailDetail> sel() {
        return emailDetailMapper.sel();
    }
}
