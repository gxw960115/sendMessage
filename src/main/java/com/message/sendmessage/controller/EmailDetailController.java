package com.message.sendmessage.controller;

import com.message.sendmessage.entity.EmailDetail;
import com.message.sendmessage.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.controller
 * @Author: GXW
 * @CreateTime: 2022-05-25  17:38
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping("/emaildetail")
public class EmailDetailController {

    @Autowired(required = false)
    private EmailService emailService;

    @RequestMapping(value = "/sel",method = RequestMethod.GET)
    public List<EmailDetail> sel(){
        return emailService.sel();
    }
}
