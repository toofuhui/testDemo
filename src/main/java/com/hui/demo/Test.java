package com.hui.demo;

import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @功能概要：调用DEMO
 * @公司名称： ShenZhen Montnets Technology CO.,LTD.
 */
@Component
public class Test
{
	// 日期格式定义
	private static SimpleDateFormat sdf	= new SimpleDateFormat("MMddHHmmss");
	boolean isEncryptPwd= com.hui.demo.ConfigManager.IS_ENCRYPT_PWD;
	/**
	 * 
	 * @description  单条发送  
	 * @param userid  用户账号
	 * @param pwd 用户密码
	 * @param isEncryptPwd 密码是否加密   true：密码加密;false：密码不加密
	 */

	public static void singleSend(String mobile,String userid, String pwd,boolean isEncryptPwd,String checkcode)
	{
		//主IP信息  必填
		String masterIpAddress="114.67.62.211:7901";
		//备IP1  选填
		String ipAddress1=null;
		//备IP2  选填
		String ipAddress2=null;
		//备IP3  选填
		String ipAddress3=null;
		//设置IP
		com.hui.demo.ConfigManager.setIpInfo(masterIpAddress, ipAddress1, ipAddress2, ipAddress3);
		//密码是否加密   true：密码加密;false：密码不加密
		com.hui.demo.ConfigManager.IS_ENCRYPT_PWD=true;
		try
		{
			// 参数类
			Message message = new Message();
			// 实例化短信处理对象
			CHttpPost cHttpPost = new CHttpPost();
			
			// 设置账号   将 userid转成大写,以防大小写不一致
			message.setUserid(userid.toUpperCase());
			
			//判断密码是否加密。
			//密码加密，则对密码进行加密
			if(isEncryptPwd)
			{
				// 设置时间戳
				String timestamp = sdf.format(Calendar.getInstance().getTime());
				message.setTimestamp(timestamp);
				
				// 对密码进行加密
				String encryptPwd = cHttpPost.encryptPwd(message.getUserid(),pwd, message.getTimestamp());
				// 设置加密后的密码
				message.setPwd(encryptPwd);
				
			}else
			{
				// 设置密码
				message.setPwd(pwd);
			}
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(mobile);
			System.out.println("checkcode:"+checkcode);
			// 设置内容
			message.setContent(checkcode);
			// 设置扩展号
			message.setExno("11");
			// 用户自定义流水编号
			message.setCustid("20160929194950100001");
			// 自定义扩展数据
			message.setExdata("abcdef");
			//业务类型
			message.setSvrtype("SMS001");

			// 返回的平台流水编号等信息
			StringBuffer msgId = new StringBuffer();
			// 返回值
			int result = -310099;
			// 发送短信
			result = cHttpPost.singleSend(message, msgId);
			// result为0:成功;非0:失败
			if(result == 0)
			{
				System.out.println("单条发送提交成功！");

				System.out.println(msgId.toString());

			}
			else
			{
				System.out.println("单条发送提交失败,错误码：" + result);
			}
		}
		catch (Exception e)
		{
			//异常处理
			e.printStackTrace();
		}
	}




}
