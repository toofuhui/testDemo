package com.hui.controller;

import com.hui.pojo.UserInfo;
import com.hui.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/userinfo")
@Api("userinfo测试controller")
public class UserInfoController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value="添加用户地址信息")
    public void add(UserInfo userInfo){
        userInfoService.save(userInfo);
    }

    @RequestMapping(value = "/find/{id}",method = RequestMethod.GET)
    @ApiOperation(value = "通过id查询地址")
    public UserInfo geUserInfotById(@PathVariable Integer id){
       return userInfoService.findById(id);
    }
    @RequestMapping(value = "/findAll",method = RequestMethod.GET, produces="application/json;charset=UTF-8")
    @ApiOperation(value = "查询所有地址")
    public List<UserInfo> geUserInfotAll(){
        return userInfoService.getAll();
    }

}
