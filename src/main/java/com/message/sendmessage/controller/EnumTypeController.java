package com.message.sendmessage.controller;

import com.message.sendmessage.entity.EnumType;
import com.message.sendmessage.service.EnumTypeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @BelongsProject: SendMessage
 * @BelongsPackage: com.message.sendmessage.controller
 * @Author: GXW
 * @CreateTime: 2022-05-25  17:34
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
@RequestMapping(value = "/enumtype")
@Api(value = "/enumtype", hidden = true,produces = "枚举值维护")
public class EnumTypeController {
    @Autowired(required = false)
    EnumTypeService enumTypeService;

    //    @RequiresPermissions(value = "component:icons:index")
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<EnumType> search() {
        return enumTypeService.search();
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public int save(EnumType enumType) {
        return enumTypeService.save1(enumType);
    }

    @RequestMapping(value = "/upd", method = RequestMethod.POST)
    public int upd(EnumType enumType) {
        return enumTypeService.upd(enumType);
    }

    @RequestMapping(value = "/del", method = RequestMethod.POST)
    public int del(EnumType enumType) {
        return enumTypeService.del(enumType);
    }

    @RequestMapping(value = "/delbach", method = RequestMethod.POST)
    public int delBach(String ids) {
        System.out.println(ids);
        return enumTypeService.delBach(ids);
    }
}
