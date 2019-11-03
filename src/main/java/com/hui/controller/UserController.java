package com.hui.controller;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hui.dto.UserDto;
import com.hui.enumstate.StateEnum;
import com.hui.pojo.User;
import com.hui.service.UserService;
import com.hui.utils.JwtUtil;
import com.hui.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Api("person测试controller")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;
    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/getuser/{id}",method = RequestMethod.GET)
    @ApiOperation(value="根据id查询")
    public User getUserById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    @ApiOperation(value="查询列表")
    /**
     * 查询所有用户返回的类为VO
     */
    public PageInfo<UserVO> getAllUser(){
        //pageNum ：当前页数,pageSize ：一页大小
        PageHelper.startPage(1, 3);
        List<User> userList=userService.getAll();
        List<UserVO> listVO=new ArrayList<>();
        UserVO userVO=new UserVO();
        //遍历userList集合
        for (User user : userList) {
            System.out.println("state:"+user.getStatus());
            System.out.println("mobile:"+user.getMobile());
            if(user.getStatus().equals("1")){
                //****BeanUtils.copyProperties不支持复制集合所以只能转化成对象
                BeanUtils.copyProperties(user,userVO);
                String statusaLabel= String.valueOf(StateEnum.OPEN.getMsg());
                System.out.println("statusaLabel:"+statusaLabel);
                userVO.setStatusaLabel(statusaLabel);
                listVO.add(userVO);
            }else if(user.getStatus().equals("0")){
                BeanUtils.copyProperties(user,userVO);
                String statusaLabel= String.valueOf(StateEnum.CLOSE.getMsg());
                System.out.println("statusaLabel:"+statusaLabel);
                userVO.setStatusaLabel(statusaLabel);
                listVO.add(userVO);
            }
        }
     /*   System.out.println("state:"+userVO.getStatusaLabel());
        List<UserVO> listVO=new ArrayList<>();
        BeanUtils.copyProperties(userList,listVO);*/
        //得到分页的结果对象
        System.out.println("listVO:"+listVO);
        PageInfo<UserVO> userPageInfo =new PageInfo<>(listVO);
        return  userPageInfo;

    }

    /**
     * 新增用户
     * @param userDto
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    @ApiOperation(value="新增")
    public void add( @Valid @RequestBody UserDto userDto){
        userService.save(userDto);
    }

    /**
     * 删除用户信息
     * @param id
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ApiOperation(value="删除")
    public void delete(@PathVariable Integer id){
        User user=new User();
        user.setUser_id(id);
        userService.delete(user);
    }

    /**
     * 修改用户信息
     * @param id
     * @param user
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.PUT)
    @ApiOperation(value="修改")
    public void update(@PathVariable Integer id,@RequestBody User user){
        user.setUser_id(id);
        userService.update(user);
    }

    /**
     * 发信息
     * @param mobile
     */
    @RequestMapping(value = "/sms/{mobile}",method = RequestMethod.POST)
    @ApiOperation(value="发短信")
    public void sendsms(@PathVariable String mobile){
            userService.sendsms(mobile);
    }

    /**
     * 用户注册
     * @param user
     * @param code
     */
    @RequestMapping(value = "/register/{code}",method = RequestMethod.POST)
    @ApiOperation(value="用户注册")
    public void register(@Valid @RequestBody User user,@PathVariable String code){
        userService.register(user,code);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value="用户登录")
    public String login(@RequestBody User user){
        User newUser=userService.login(user);
        if(newUser==null){
            return "登录失败";
        }
        String token= jwtUtil.createJWT(String.valueOf(newUser.getUser_id()),newUser.getUser_name(),"admin");
        System.out.println("token:"+token);
        Map<String,Object> map=new HashMap<>();
        map.put("token",token);
        map.put("role","admin");
        return "登录成功";
    }
}
