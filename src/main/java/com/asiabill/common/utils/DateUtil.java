package com.asiabill.common.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * <p>Title: 虚拟账户系统</p>
 * <p>Description: 日期工具类或者跟日期相关的方法</p>
 * <p>Copyright: Copyright (c) 2010 版权</p>
 * <p>Company: </p>
 * @author wuhaiming
 * @version V1.0 
 * @date 2010-7-20下午03:10:15
 */
public class DateUtil
{
	private static final Log logger = LogFactory.getLog(com.asiabill.common.utils.DateUtil.class);
	/**
	 * 流水号生成日期规则
	 * kzk 20100809 规则修改
	 */
	public static final String RecordIDRule = "yyyyMMddHHmmssSSS";
	public static final String tradeDateRule = "yyyyMMddHHmmss";
	/**
	 * 根据日期规则生成当前时间
	 */
	public static final String dateRule = "yyyy-MM-dd HH:mm:ss";
	public static final String utcRule = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	
	/**
	 * 年月 
	 */
	public static final String DATERULE_YYYYMM = "yyyyMM";
	public static final String DATERULE_YYYY_MM_DD = "yyyy-MM-dd";
	
	//开始日期
	public  static final String startDateRule = "yyyy-MM-dd 00:00:00";
	//结束日期
	public  static final String endDateRule = "yyyy-MM-dd 23:59:59";
	
	/**
	 * @author: wuhaiming
	 * @Title generateRecordID
	 * @Time: 2010-7-20下午03:10:39
	 * @Description: 自动银行卡进出账明细表中的生成流水ID号
	 * 					流水号生成规则 日期 + 5位随机数
	 * @return: void 
	 * @throws: 
	 */
	public static String generateRecordID(){
		//kzk 20100809 修改 流水号规则变更 yyyyMMddHHmmssSSSS 不加随机数
		return new SimpleDateFormat(RecordIDRule, Locale.US).format(new Date());
	}
	
	public static String generateRecordID(Date date){
		//kzk 20100809 修改 流水号规则变更 yyyyMMddHHmmssSSSS 不加随机数
		return new SimpleDateFormat(RecordIDRule, Locale.US).format(date);
	}
	
	/**
	 * @author: wuhaiming
	 * @Title getCurrentDateString
	 * @Time: 2010-7-21下午07:02:15
	 * @Description: 获取当前时间以yyyy-MM-dd HH:mm:ss字符串的方式返回
	 * @return: String 
	 * @throws: 
	 * @return
	 */
	public static String getCurrentDateString()
	{
		return new SimpleDateFormat(dateRule, Locale.US)
				.format(new Date());
	}
	 /**
	  * 
	  * @author: Shmily
	  * @Title getCurDateString
	  * @Time: 2011-6-27下午05:33:42
	  * @Description: 得到yyyy-MM-dd格式的当前时间
	  * @return: String 
	  * @throws: 
	  * @return
	  */
	public static String getCurDateString()
	{
		return new SimpleDateFormat("yyyy-MM-dd", Locale.US)
				.format(new Date());
	}

	public static String getFormatDateString(Date date, String format)
	{
		return new SimpleDateFormat(format)
		.format(date);
	}
	
	public static String getFormatDateString(Date date)
	{
		return new SimpleDateFormat(dateRule).format(date);
	}
	
	 /**
	  * 
	  * @author: max
	  * @Title formatStringIntoDate
	  * @Time: 2011-7-22下午05:33:42
	  * @Description: 得到yyyy-MM-dd HH:mm:ss格式的日期
	  * @return: Date 
	  * @throws: 
	  * @return
	  */
	  public static Date formatStringIntoDate(String strDate){
		  try{
			  	Date d = null;
			  	if(!"".equals(strDate)){
			  		d = new SimpleDateFormat(dateRule).parse(strDate);
			  	}
			  	return d;			  
		  }catch(Exception e){
			  logger.error(StringHandleUtils.getExceptionInfo(e));
			  return null;
		  }
	  }
	  /**
		  * 
		  * @author: max
		  * @Title formatStringIntoDate
		  * @Time: 2011-7-22下午05:33:42
		  * @Description: 得到yyyy-MM-dd HH:mm:ss格式的日期
		  * @return: Date 
		  * @throws: 
		  * @return
		  */
		  public static Date formatStringIntoDate(String strDate, String format){
			  try{
				  	Date d = null;
				  	if(!"".equals(strDate)){
				  		d = new SimpleDateFormat(format).parse(strDate);
				  	}
				  	return d;			  
			  }catch(Exception e){
				  logger.error(StringHandleUtils.getExceptionInfo(e));
				  return null;
			  }
		  }
		  
	  	/**
	  	 * 
	  	 * @author: Yolanda.qin
	  	 * @Title getBeforeDate
	  	 * @Time: 2011-7-27上午11:08:07
	  	 * @Description: 获取前几天的日期和时间
	  	 * @return: String 
	  	 * @throws: 
	  	 * @param beforeDays
	  	 * @return
	  	 */
	    public static String getBeforeDate(int beforeDays) {
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.DAY_OF_MONTH, -1 * beforeDays);
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return sf.format(c.getTime());
	    }
	    
	    /**
	  	 * 
	  	 * @author: Yolanda.qin
	  	 * @Title getBeforeDate
	  	 * @Time: 2011-7-27上午11:08:07
	  	 * @Description: 获取前几天的日期和时间
	  	 * @return: String 
	  	 * @throws: 
	  	 * @param beforeDays
	  	 * @return
	  	 */
	    public static String getBeforeDate(int beforeDays, String format) {
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.DAY_OF_MONTH, -1 * beforeDays);
	        SimpleDateFormat sf = new SimpleDateFormat(format);
	        return sf.format(c.getTime());
	    }
	    
	    /**
	     * 获取后几天的日期和时间
	     * @author: jadehu
	     * @Title getAfterDate
	     * @Time: 2012-4-18上午11:34:19
	     * @Description: 
	     * @return: String 
	     * @throws: 
	     * @param beforeDays
	     * @return
	     */
	    public static String getAfterDate(int beforeDays) {
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.DAY_OF_MONTH, 1 * beforeDays);
	        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        return sf.format(c.getTime());
	    }
	    
	    /**
	     * 加时间时
	     * @param
	     * @return
	     * @author huangtl
	     * @date Jun 19, 2012 3:08:23 PM
	     */
	    public static Date addHours(int hours) {
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.HOUR_OF_DAY, 1 * hours);
	        return c.getTime();
	    }
	    
	    /**
		 * 加时间时
		 * 
		 * @param
		 * @return
		 * @author huangtl
		 * @date Jun 19, 2012 3:08:23 PM
		 */
		public static Date addHours(Date date, int hours) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
	        c.add(Calendar.HOUR_OF_DAY, 1 * hours);
			return c.getTime();
		}
		
		/**
		 * 加天
		 * 
		 * @param date
		 * @param
		 * @return
		 * @author huangtl
		 * @date Jun 19, 2012 3:08:23 PM
		 */
		public static Date addDate(Date date, int day) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, 1 * day);
			return c.getTime();
		}
		
		/**
		 * 减天
		 * 
		 * @param date
		 * @param
		 * @return
		 * @author huangtl
		 * @date Jun 19, 2012 3:08:23 PM
		 */
		public static Date subDate(Date date, int day) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			c.add(Calendar.DAY_OF_MONTH, -1 * day);
			return c.getTime();
		}
		
		 /**
		 * 加年
		 * 
		 * @param date
		 * @param year
		 * @return
		 * @author huangtl
		 * @date Jun 19, 2012 3:08:23 PM
		 */
		public static Date addYear(Date date, int year) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
	        c.add(Calendar.YEAR, 1 * year);
			return c.getTime();
		}
	    
	    /**
	     * 加时间分
	     * @param minute
	     * @return
	     * @author huangtl
	     * @date Jun 29, 2012 10:20:21 AM
	     */
	    public static Date addMinute(int minute) {     
	        Calendar c = Calendar.getInstance();
	        c.add(Calendar.MINUTE, 1 * minute);
	        return c.getTime();
	    }
	    
	    public static Date addMinute(Date date, int year) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
	        c.add(Calendar.MINUTE, 1 * year);
			return c.getTime();
		}

	    
	    /**
		  * 
		  * @author: max
		  * @Title getStartCurDateString
		  * @Time: 
		  * @Description: 得到yyyy-MM-dd 00:00:00格式的当前时间
		  * @return: String 
		  * @throws: 
		  * @return
		  */	
		public static String getStartCurDateString()
		{
			return new SimpleDateFormat(startDateRule, Locale.US)
					.format(new Date());
		}
		
		/***
		 * 获取当天0点时间
		 * @Description: 得到yyyy-MM-dd 00:00:00格式的当前时间
		 * @return 
		 */
		public static Date getBeginDay(){
			Calendar calendar1 = Calendar.getInstance();
			calendar1.set(calendar1.get(Calendar.YEAR), 
					calendar1.get(Calendar.MONTH), 
					calendar1.get(Calendar.DAY_OF_MONTH),
					0, 0, 0);
			return calendar1.getTime();
		}
		
		/***
		 * 获取当天23点时间
		 * @Description: 得到yyyy-MM-dd 23:59:59格式的当前时间
		 * @return 
		 */
		public static Date getEndDay(){
			Calendar calendar2 = Calendar.getInstance();
			calendar2.set(calendar2.get(Calendar.YEAR), 
					calendar2.get(Calendar.MONTH), 
					calendar2.get(Calendar.DAY_OF_MONTH),
					23, 59, 59);
			return calendar2.getTime();
		}
		
		 /**
		  * 
		  * @author: max
		  * @Title getEndCurDateString
		  * @Time: 
		  * @Description: 得到yyyy-MM-dd 23:59:59格式的当前时间
		  * @return: String 
		  * @throws: 
		  * @return
		  */	
		public static String getEndCurDateString()
		{
			return new SimpleDateFormat(endDateRule, Locale.US)
					.format(new Date());
		}
		 /**
		 * 	System.out.println(DateUtil.getDatestr("yyyyMMdd", "20090915",
					"yyyy-MM-dd"));
		 * @author: jadehu
		 * @Title getDatestr
		 * @Time: 2012-4-13下午12:26:01
		 * @Description: 
		 * @return: String 
		 * @throws: 
		 * @param dateformat1
		 * @param dateString
		 * @param dateformat2
		 * @return
		 */
		public static String getDatestr(String dateformat1, String dateString,
				String dateformat2) {
			String d = null;
			try {

				if (!"".equals(dateformat1) && !"".equals(dateString)
						&& !"".equals(dateformat2)) {
					Date date = new SimpleDateFormat(dateformat1).parse(dateString);

					d = new SimpleDateFormat(dateformat2).format(date);

				}
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			return d;

		}
		public static Date getFormatStringIntoDate(String strDate) {
			try {
				Date d = null;
				if (!"".equals(strDate)) {
					d = new SimpleDateFormat(dateRule).parse(strDate);
				}
				return d;
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
				return null;
			}
		}
		
		
		
		public static String getUTCTimeStr() {
			// 取得本地时间：
		    Calendar cal = Calendar.getInstance();
		    // 取得时间偏移量：
		    int zoneOffset = cal.get(Calendar.ZONE_OFFSET);
		    // 取得夏令时差：
		    int dstOffset = cal.get(Calendar.DST_OFFSET);
		    
		    // 等效System.currentTimeMillis() , 统一值，不分时区
//	        System.out.println("local millis = " + cal.getTimeInMillis()); 
//	        System.out.println("local = " + new SimpleDateFormat(utcRule).format(cal.getTime()));

	        // 从本地时间里扣除这些差量，即可以取得UTC时间：
	        cal.add(Calendar.MILLISECOND, -(zoneOffset + dstOffset));

	        long mills = cal.getTimeInMillis();
//	        System.out.println("UTC = " + mills);
//	        System.out.println("UTC = " + new SimpleDateFormat(utcRule).format(cal.getTime()));

	        return new SimpleDateFormat(utcRule).format(cal.getTime());
	    }

		
		public static void main(String[] ar) throws Exception{
			com.asiabill.common.utils.DateUtil.getUTCTimeStr();
		}
		
}
