package com.hui.sms;

import com.hui.demo.Test;
import com.hui.utils.RedisUtil;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {
  @Autowired
  private Test test;
  @Autowired
  private RedisUtil redisUtil;
    @RabbitHandler
    public void executeSms(Map<String,String> map){
        String mobile=map.get("mobile");
        String code=map.get("checkCode");
        String string="您的验证码是";
        String a="，在2分钟内有效。如非本人操作请忽略本短信。";
        String checkcode=string+code+a;
        if(!redisUtil.hasKey(mobile)){
            redisUtil.set(mobile,"1");
            redisUtil.expire(mobile,60, TimeUnit.SECONDS);
        }
        int count=Integer.parseInt(redisUtil.get(mobile));
        if(count<2){
            redisUtil.set(mobile, String.valueOf(count+1));
            redisUtil.expire(mobile,60, TimeUnit.SECONDS);
            test.singleSend(map.get("mobile"),"E100FVP","fXgKzG",true,checkcode);

        }
    }
}
