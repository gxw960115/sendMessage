package com.message.sendmessage.service.impl;

import com.message.sendmessage.entity.EmailAddress;
import com.message.sendmessage.mapper.EmailAddressMapper;
import com.message.sendmessage.service.EmailAddressService;
import com.message.sendmessage.utils.UuidUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.service.impl
 * @Author: GXW
 * @CreateTime: 2022-05-26  16:05
 * @Description: TODO
 * @Version: 1.0
 */
@Service
public class EmailAddressServiceImpl implements EmailAddressService {
    @Autowired(required = false)
    private EmailAddressMapper emailAddressMapper;

    @Override
    public List<EmailAddress> search(EmailAddress emailAddress) {
        return emailAddressMapper.search(emailAddress);
    }

    @Override
    public int save(EmailAddress emailAddress) {
        String uuid = UuidUtil.getUuid();
        emailAddress.setIdentification(uuid);
        return emailAddressMapper.save(emailAddress);
    }

    @Override
    public int delBach(String ids) {
        List<String> list = new ArrayList<>();
        String[] id = ids.split(",");
        for (int i = 0; i < id.length; i++) {
            list.add(id[i]);
        }
        return emailAddressMapper.delBach(list);
    }

    @Override
    public int upd(EmailAddress emailAddress) {
        return emailAddressMapper.upd(emailAddress);
    }
}
