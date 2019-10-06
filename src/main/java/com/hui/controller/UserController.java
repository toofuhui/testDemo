package com.hui.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.dto.UserDto;
import com.hui.pojo.User;
import com.hui.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
@Api("person测试controller")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "/getuser/{id}",method = RequestMethod.GET)
    @ApiOperation(value="根据id查询")
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    @ApiOperation(value="查询列表")
    public PageInfo<User> getAllUser(){
        //pageNum ：当前页数,pageSize ：一页大小
        PageHelper.startPage(1, 3);
        List<User> userList=userService.getAll();
        //得到分页的结果对象
        PageInfo<User> userPageInfo = new PageInfo<>(userList);
       return  userPageInfo;

    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value="新增")
    public void add( @Valid @RequestBody UserDto userDto){
        userService.save(userDto);
    }
    //删除用户信息
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除")
    public void delete(@PathVariable Integer id){
        User user=new User();
        user.setUser_id(id);
        userService.delete(user);
    }
    //修改用户信息
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    @ApiOperation(value="修改")
    public void update(@PathVariable Integer id,@RequestBody User user){
        user.setUser_id(id);
        userService.update(user);
    }
    //发信息
    @RequestMapping(value = "/sms/{mobile}",method = RequestMethod.POST)
    @ApiOperation(value="发短信")
    public void sendsms(@PathVariable String mobile){
        userService.sendsms(mobile);
    }

}
