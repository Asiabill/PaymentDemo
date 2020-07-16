package com.asiabill.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.regex.Pattern;

@Slf4j
public class BrowserUtil {

    // \b 是单词边界(连着的两个(字母字符 与 非字母字符) 之间的逻辑上的间隔),    
    // 字符串在编译时会被转码一次,所以是 "\\b"    
    // \B 是单词内部逻辑间隔(连着的两个字母字符之间的逻辑上的间隔)    
   private static final String phoneReg = "\\b(ip(hone|od)|android|opera m(ob|in)i"    
            +"|windows (phone|ce)|blackberry"    
            +"|s(ymbian|eries60|amsung)|p(laybook|alm|rofile/midp"    
            +"|laystation portable)|nokia|fennec|htc[-_]"    
            +"|mobile|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    

   private static final String tabletReg = "\\b(ipad|tablet|(Nexus 7)|up.browser|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";    

  //移动设备正则匹配：手机端、平板  
   private static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);    
   private static Pattern tabletPat = Pattern.compile(tabletReg, Pattern.CASE_INSENSITIVE);    

    /** 
     * 检测是否是移动设备访问 
     * 
     * @param userAgent 浏览器标识 
     * @return  0：PC端 1：移动端
     */  
    public static String isMobile(String userAgent){    
        if(null == userAgent){
        	log.info("未知浏览器标识");
            return "";    
        }
        
        if(phonePat.matcher(userAgent).find() || tabletPat.matcher(userAgent).find()) {
        	log.info("移动端");
        	return "1";
        }
        
        log.info("PC端");
        return "0";
    }

    public static void main(String[] args) {
    	String ua = "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:63.0) Gecko/20100101 Firefox/63.0";
    	System.out.println(ua);
    	System.out.println(BrowserUtil.isMobile(ua));
    }
}