package com.asiabill.common.utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Assert;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Random;

/**
 * <p>
 * Title: 公用类
 * </p>
 * <p>
 * Description:
 * </p>
 * 对一些接收String类型的进行处理,比如随机数等
 * <p>
 * Copyright: Copyright (c) 2010 版权
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author guozb
 * @version V1.0
 * @date 2011-6-27下午03:10:15
 */
public class StringHandleUtils {

	private static final Log logger = LogFactory.getLog(com.asiabill.common.utils.StringHandleUtils.class);
	
	/**
	 * 
	 * @author: peifang
	 * @Title getRandomCode
	 * @Time: 2011-6-28下午03:04:21
	 * @Description: 
	 * @return: String 
	 * @throws: 
	 * @param len 获取返回随机数长度
	 * @param isLetterDigit 是否必须包含字母和数字
	 * @return
	 */
	public static String getRandomCode(int len, boolean isLetterDigit) {
		int number;
		char code = 0;
		String checkCode = "";
		Assert.isTrue(len > 1, "长度不能小于1位");
		Random random = new Random();
		boolean isLetter = false;
		boolean isDigit = false;
		for (int i = 0; i < len; i++) {
			number = random.nextInt(1000);
			if (number % 2 == 0) {
				isDigit = true;
				code = (char) ('0' + (char) (number % 10));
			} else if (number % 3 == 0) {
				isLetter = true;
				code = (char) ('A' + (char) (number % 26));
			} else {
				isLetter = true;
				code = (char) ('a' + (char) (number % 26));
			}
			checkCode += code + "";
		}
		if(isLetterDigit) {
			String temp = checkCode.substring(0, checkCode.length()-1);
			number = random.nextInt(1000);
			if(!isLetter) {
				temp.concat(String.valueOf((char) ('A' + (char) (number % 26))));
			} else if (!isDigit) {
				temp.concat(String.valueOf((char) ('0' + (char) (number % 10))));
			}
		}
		return checkCode;
	}

	/**
	 * 
	 * @author: peifang
	 * @Title getExceptionInfo
	 * @Time: 2011-11-21上午11:54:43
	 * @Description: 获取异常跟踪信息
	 * @return: String 
	 * @throws: 
	 * @param e
	 * @return
	 */
	public static String getExceptionInfo(Throwable e) {
		StringWriter sw = new StringWriter();
		PrintWriter out = new PrintWriter(sw);
		e.printStackTrace(out);
		out.close();
		return sw.toString();
	}
	
	/**
	 * 
	 * @author: peifang
	 * @Title number2String
	 * @Time: 2012-1-29下午02:22:55
	 * @Description: 金额数字公司格式化处理
	 * @return: String 
	 * @throws: 
	 * @param num
	 * @return
	 */
	public static String number2CurrencyString(Object num) {
		return (new DecimalFormat("###,###0.00")).format(num);
	}
	/**
	 * @Title getCardNoTruncation
	 * @Description:
	 * 截断规则：
	 * 大于10位，前6****后4
	 * 大于4位，小等于10的，****后4
	 * 小等于4位，****原值
	 * @throws: 
	 * @param cardNo
	 * @return
	 */
	public static String getCardNoPart(String cardNo) {
		if(StringUtils.isBlank(cardNo)) {
			logger.error("cardNo为空，不能截断");
			return null;
		}
        int length=cardNo.length();
        if(length > 10) {
        	return cardNo.substring(0,6) +"****"+ cardNo.substring(length - 4, length);
        }else if(length <= 10 && length > 4) {
        	return "****"+ cardNo.substring(length - 4, length);
        }else {
        	return "****"+ cardNo;
        }
    }
	
	/**
	 * 获取截断的邮箱址
	 * @param email
	 * @return
	 */
	public static String getEmailPart(String email) {
        int index = email.indexOf("@");
        if(index>0){
        	int i = index-3;
        	return "****"+email.substring(i >= 0 ? i:0);
        }
        return email;
    }
	
	/**
	 * 获取截断的邮箱址
	 * @param email
	 * @return
	 */
	public static String getPhonePart(String phone) {
		int length=phone.length();
        if(length>0){
        	int i = length-4;
        	return "****"+phone.substring(i >= 0 ? i:0);
        }
        return phone;
    }
	
	/**
	 * 金额保留两位小数
	 * @param amt
	 * @return
	 */
	public static String getStringAmt(BigDecimal amt){
    	if(amt==null){
    		return null;
    	}
    	
    	try{
    		DecimalFormat df = new DecimalFormat("0.00");    
        	return df.format(amt);
    	}catch (Exception e) {
    		logger.error(com.asiabill.common.utils.StringHandleUtils.getExceptionInfo(e));
    		return null;
    	}
    }

	/**
	 * 扣率保留4位
	 * @param amt
	 * @return
	 */
	public static String getStringRatio(BigDecimal ratio){
		if(ratio==null){
			return null;
		}
		
		try{
			DecimalFormat df = new DecimalFormat("0.0000");    
			return df.format(ratio);
		}catch (Exception e) {
			logger.error(com.asiabill.common.utils.StringHandleUtils.getExceptionInfo(e));
			return null;
		}
	}
	
	// obj转String
	public static String obj2String(Object value){
		if(null == value){
			return null;
		}
		return value.toString();
	}
	
	public static String filterNULL(String s) {
		if(s==null) {
			return "";
		} else {
			return s.trim();
		}
	}
	
	public static String exchangeParam(String param) {
		String illegalParam[] = { "&", "<", ">", "\"", "'" };
		String macroParam[] = { "&amp;", "&lt;", "&gt;", "&quot;", "" };
		
		for (int i = 0; i < illegalParam.length; i++) {
			int flag = param.indexOf(illegalParam[i]);
			if (flag != -1) {
				String legalString = macroParam[i];
				param = param.replaceAll(illegalParam[i], legalString);
			}
		}

		return param;
	}	

	
	public static void main(String[] args) throws Exception {
		System.out.println(getCardNoPart("01234567891"));
//		System.out.println(getEmailPart("g@163.com"));
//		System.out.println(getPhonePart("13800138000"));
//		System.out.println(getStringRatio(new BigDecimal("33")));
	}
	
	
}
