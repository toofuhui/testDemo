package com.hui.serviceimpl;

import com.alibaba.druid.util.StringUtils;
import com.hui.dto.UserDto;
import com.hui.mapper.UserMapper;
import com.hui.pojo.User;
import com.hui.service.UserService;
import com.hui.utils.RedisUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @Autowired
    private RedisUtil redisUtil;
    @Override
    public void save(UserDto userDto) {
        User user=new User();
        BeanUtils.copyProperties(userDto,user);
        userMapper.insert(user);
    }

    @Override
    // 每天21点执行一次
    @Scheduled(cron = "0 0 21 * * ?")
    public void sendsms(String mobile) {
        String checkCode= RandomStringUtils.randomNumeric(6);
        //将验证码存入redis中
        if(StringUtils.isEmpty(checkCode)){
            redisUtil.set("checkCode_"+mobile,checkCode);
            redisUtil.expire("checkCode_"+mobile,60, TimeUnit.MILLISECONDS);
        }
        System.out.println("1111111");
        //将验证码和手机号发动到rabbitMQ中
        Map<String,String> map=new HashMap<>();
        map.put("mobile",mobile);
        map.put("checkCode",checkCode);
        rabbitTemplate.convertAndSend("sms",map);
        System.out.println(checkCode);


    }
    /*@Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
       // return userMapper.findUserById(id);
        if(StringUtils.isEmpty( String.valueOf(id))){
            throw  new RuntimeException("参数不得为空");
        }
        User user=new User();
        user.setUser_id(id);
       return userMapper.selectByPrimaryKey(user);
    }*/

/*    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
       //return userMapper.getUserList();
    }*/
   /* public void add(User user){
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
       // userMapper.add(user);
       userMapper.insert(user);
    }*/
   /* public void delete(Integer id){
        User user=new User();
        user.setUser_id(id);
        userMapper.deleteByPrimaryKey(user);
       // userMapper.delete(id);
    }*/
   /* public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
       // userMapper.update(user)*/
    }


