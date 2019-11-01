package com.hui.serviceimpl;

import com.hui.dto.UserDto;
import com.hui.mapper.BaseMapper;
import com.hui.mapper.UserMapper;
import com.hui.pojo.User;
import com.hui.service.UserService;
import com.hui.utils.CodecUtils;
import com.hui.utils.RedisUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;
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
    protected BaseMapper<User> getMapper() {
        return userMapper;
    }
        @Override
        public void save (UserDto userDto){
            User user = new User();
            BeanUtils.copyProperties(userDto, user);
            userMapper.insert(user);
        }
        @Override
        // 每天21点执行一次
        @Scheduled(cron = "0 0 21 * * ?")
        public void sendsms (String mobile){
            String checkCode = RandomStringUtils.randomNumeric(6);
            //将验证码存入redis
            redisUtil.set("checkcode_" + mobile, checkCode);
            redisUtil.expire("checkcode_" + mobile, 60, TimeUnit.SECONDS);
            //将验证码和手机号发动到rabbitMQ中
            Map<String, String> map = new HashMap<>();
            map.put("mobile", mobile);
            map.put("checkCode", checkCode);
            rabbitTemplate.convertAndSend("sms", map);
            System.out.println(checkCode);

        }

    @Override
    public void register(User user, String code) {
        System.out.println("user:"+user);
        String key="checkcode_"+user.getMobile();
        //从redis中取出code
        String checkcode=redisUtil.get(key);
        System.out.println("chekcode:"+checkcode);
        System.out.println("code:"+code);
        //检查验证码是否正确
        if(!StringUtils.isEmpty(checkcode)){
        if(!checkcode.equals(code)) {
            throw new RuntimeException("验证码错误");
        }}
        user.setCreate_time(new Date());
        user.setUpdate_time(new Date());
        //生成盐
        System.out.println(11111);
        String salt=CodecUtils.generateSalt();
        System.out.println("salt:"+salt);
        user.setSalt(salt);
        //生成密码
        System.out.println(user.getPassword());
        System.out.println(user.getSalt());
        String md5Pwd=CodecUtils.md5Hex(user.getPassword(),user.getSalt());
        System.out.println("md5Pwd:"+md5Pwd);
        user.setPassword(md5Pwd);

        //保存到数据库中
        int count=userMapper.insertSelective(user);
        if(count!=1){
            return;
        }
        //将验证码从redis中删除
        redisUtil.delete(key);

    }


    @Override
    public Boolean findUserByName(String username) {
        int count= userMapper.findUserByName(username);
        return count==0?true:false;
    }
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



