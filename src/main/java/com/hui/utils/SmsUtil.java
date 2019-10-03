package com.hui.utils;

import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

public class SmsUtil {
    public static void main(String[] args) {
        // 用户账号
        String userid = "KUKU02";
        // 创建全局参数
        GlobalParams globalParams = new GlobalParams();
        // 设置请求路径
        globalParams.setRequestPath("/sms/v2/std/");
        // 设置是否需要日志 1:需要日志;0:不需要日志
        globalParams.setNeedLog(1);
        // 设置全局参数
        ConfigManager.setGlobalParams(globalParams);
        // 是否保持长连接
        boolean isKeepAlive = true;
        // 实例化短信处理对象
        SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);
        // 单条发送
        singleSend(smsSendConn, userid);

    }
        /**
         *
         * @description 单条发送
         * @param smsSendConn
         *            短信处理对象,在这个方法中调用发送短信功能
         * @param userid
         *            用户账号
         */

    public static void singleSend(SmsSendConn smsSendConn, String userid) {
        try {
            // 参数类
            Message message = new Message();
            // 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
            message.setUserid(userid);
            // 设置手机号码 此处只能设置一个手机号码
            message.setMobile("159XXXXXXXX");
            // 设置内容
            message.setContent("测试短信");
            //业务类型
            message.setSvrtype("SMS001");
            // 返回的流水号
            StringBuffer returnValue = new StringBuffer();
            // 返回值
            int result = -310099;
            // 发送短信
            result = smsSendConn.singleSend(message, returnValue);
            // result为0:成功
            if (result == 0) {
                System.out.println("单条发送提交成功！");
                System.out.println(returnValue.toString());
            }
            // result为非0：失败
            else {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        } catch (Exception e) {
            // 异常处理
            e.printStackTrace();
        }
    }
}