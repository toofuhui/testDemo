package com.hui.sms;

import com.hui.demo.Test;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RabbitListener(queues = "sms")
public class SmsListener {
   @Autowired
    private Test test;
    @RabbitHandler
    public void executeSms(Map<String,String> map){
        System.out.println(map.get("mobile"));
        System.out.println(map.get("checkCode"));
        String code=map.get("checkCode");
        String string="您的验证码是";
        String a="，在2分钟内有效。如非本人操作请忽略本短信。";
        String checkcode=string+code+a;
        test.singleSend(map.get("mobile"),"E10FVP","fXgKzG",true,checkcode);

    }
}
