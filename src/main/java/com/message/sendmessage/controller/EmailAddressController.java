package com.message.sendmessage.controller;

import com.message.sendmessage.entity.EmailAddress;
import com.message.sendmessage.service.EmailAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.controller
 * @Author: GXW
 * @CreateTime: 2022-05-26  16:09
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/emailaddrss")
public class EmailAddressController {
    @Autowired
    private EmailAddressService emailAddressService;

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<EmailAddress> search(EmailAddress emailAddress) {
        return emailAddressService.search(emailAddress);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public int save(EmailAddress emailAddress) {
        return emailAddressService.save(emailAddress);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public int del(String ids) {
        return emailAddressService.delBach(ids);
    }

    @RequestMapping(value = "/upd", method = RequestMethod.POST)
    public int upd(EmailAddress emailAddress) {
        return emailAddressService.upd(emailAddress);
    }
}
