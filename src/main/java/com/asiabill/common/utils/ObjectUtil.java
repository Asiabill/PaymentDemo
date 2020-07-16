package com.asiabill.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 * @author huangtl
 *
 */
@Slf4j
public class ObjectUtil {

	public static final String dateRule = "yyyy-MM-dd HH:mm:ss";
	
	public static void main(String[] ages) throws Exception{
		
	}
	
	public static String getRedirectParameters(Object spObj) {
		Class<?> targetClass = spObj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		StringBuffer sbuf = new StringBuffer();
		for (Field field : fields) {
			JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
			if(jsonPropertyAnnotation == null) {
				continue;
			}
			
			String jpvalue = jsonPropertyAnnotation.value();
			if (jsonPropertyAnnotation != null 
					&& StringUtils.isNoneBlank(jpvalue)
						&& jpvalue.startsWith("x_")) {
				String val = com.asiabill.common.utils.ObjectUtil.getString(field, spObj);
				if(val == null) {
					continue;
				}
				
				sbuf.append("&").append(jpvalue).append("=").append(val);
			}
		}
		
		if(sbuf.length()<=0) {
			return "";
		}
		
		return sbuf.substring(1);
	}
	
	/**
	 * 通过objFrom注解内容为key，获取map里的值，填充到objFrom的对应字段
	 * @param spObj
	 * @param abObj 相应字段需要添加@JsonProperty注解
	 */
	public static void conversionToFrom(Object spObj, Object abObj) {
		Map<String, String> map =  jsonpToTreeMap(spObj);
		Class<?> targetClass = abObj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
			if(jsonPropertyAnnotation == null) {
				continue;
			}
			
			String jpvalue = jsonPropertyAnnotation.value();
			if (jsonPropertyAnnotation != null 
					&& StringUtils.isNoneBlank(jpvalue)
						&& jpvalue.startsWith("x_")) {
				String val = null;
				if(jpvalue.equals("x_customer_shipping_address")) {
					val = filterNULL(map.get("x_customer_shipping_address1")) + " "+ filterNULL(map.get("x_customer_shipping_address2"));
				}else if(jpvalue.equals("x_customer_billing_address")) {
					val = filterNULL(map.get("x_customer_billing_address1")) + " "+ filterNULL(map.get("x_customer_billing_address2"));
				}else {
					val = filterNULL(map.get(jpvalue));
				} 
				
				setter(abObj, field.getName(), val, String.class);
			}
		}
	}
	
	/**
	 * 通过fromObj注解内容为key，获取jsonObj里的值，填充到fromObj的对应字段
	 * @param map 
	 * @param fromObj 相应字段需要添加@JsonProperty注解
	 */
	public static void conversionToFrom(JSONObject jsonObj, Object fromObj) {
		Class<?> targetClass = fromObj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
			if(jsonPropertyAnnotation == null) {
				continue;
			}
			
			String jpvalue = jsonPropertyAnnotation.value();
			if (jsonPropertyAnnotation != null 
					&& StringUtils.isNoneBlank(jpvalue)
						&& jpvalue.startsWith("x_")) {
				String val = jsonObj.getString(jpvalue);
				setter(fromObj, field.getName(), val, String.class);
			}
		}
	}
	
	/**
	 * 通过对象字段注解，转换成TreeMap<String, String>
	 * @param obj 相应字段需要添加@JsonProperty注解
	 * @return
	 */
	public static TreeMap<String, String> jsonpToTreeMap(Object obj){
		TreeMap<String, String> tm = new TreeMap<String, String>();
		Class<?> targetClass = obj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
			if(jsonPropertyAnnotation == null) {
				continue;
			}
			
			String jpvalue = jsonPropertyAnnotation.value();
			if (jsonPropertyAnnotation != null 
					&& StringUtils.isNoneBlank(jpvalue)
						&& jpvalue.startsWith("x_")) {
				String val = com.asiabill.common.utils.ObjectUtil.getString(field, obj);
				
				if(StringUtils.isBlank(val)) {
					continue;
				}
				
				tm.put(jpvalue, val);
			}
		}
		return tm;
	}
	
	/**
	 * 通过对象字段注解，转换成LinkedHashMap<String, String>
	 * @param obj 相应字段需要添加@JsonProperty注解
	 * @return
	 */
	public static LinkedHashMap<String, String> jsonpToLinkedHashMap(Object obj){
		LinkedHashMap<String, String> tm = new LinkedHashMap<String, String>();
		Class<?> targetClass = obj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			JsonProperty jsonPropertyAnnotation = field.getAnnotation(JsonProperty.class);
			if(jsonPropertyAnnotation == null) {
				continue;
			}
			
			String jpvalue = jsonPropertyAnnotation.value();
			if (jsonPropertyAnnotation != null 
					&& StringUtils.isNoneBlank(jpvalue)
						&& jpvalue.startsWith("x_")) {
				String val = com.asiabill.common.utils.ObjectUtil.getString(field, obj);
				
				if(StringUtils.isBlank(val)) {
					continue;
				}
				
				tm.put(jpvalue, val);
			}
		}
		return tm;
	}
	
	/**
	 * 对象字段名称，转换成LinkedHashMap<String, String>
	 * @param obj 普通对象
	 * @return
	 */
	public static LinkedHashMap<String, String> toLinkedHashMap(Object obj){
		LinkedHashMap<String, String> tm = new LinkedHashMap<String, String>();
		Class<?> targetClass = obj.getClass();
		Field[] fields = targetClass.getDeclaredFields();
		for (Field field : fields) {
			String val = com.asiabill.common.utils.ObjectUtil.getString(field, obj);
			if(StringUtils.isBlank(val)) {
				continue;
			}
			
			tm.put(field.getName(), val);
		}
		return tm;
	}
	
	private static String filterNULL(String s) {
		if(s==null) {
			return "";
		} else {
			return s.trim();
		}
	}
	
	public static void copyPropertiesToString(Object obj, Object newObj){
		
		if(obj == null){
			return;
		}
		if(newObj == null){
			return;
		}
		
		Class objCls = obj.getClass();
        Field[] fields = objCls.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            
            try{
	            setString(newObj, field.getName(), getString(field, obj));
            }catch (Exception e) {
            	log.error(StringHandleUtils.getExceptionInfo(e));
    			log.error("动态设值失败");
			}
        }
		
        
	}
	
	public static void setString(Object obj, String fieldName, String val){
		setter(obj, fieldName, val, String.class);
	}
	
	public static String getString(Field field, Object obj){
		if(field == null){
			return null;
		}
		
		if(obj == null){
			return null;
		}
		
		String val = null;
		try{
			String type = field.getType().getSimpleName();
			
			Object valObj = getter(obj, field.getName());

			if ("BigDecimal".equals(type)) {
				val = String.format("%.2f", valObj);
			} else if ("Double".equals(type)) {
				val = String.format("%.2f", valObj);
			} else if ("Float".equals(type)) {
				val = String.format("%.2f", valObj);
			} else if ("Date".equals(type)) {
				val = new SimpleDateFormat(dateRule,
						Locale.US).format(valObj);
			} else {
				val = valObj.toString();
			}
        }catch (Exception e) {
        	
		}
		
		return val;
	}
	
	/**
	 * 首字母大写
	 * 
	 * @param name
	 * @return
	 */
	private static String captureName(String name) {
		char[] cs = name.toCharArray();
		cs[0] -= 32;
		return String.valueOf(cs);
	}
	
	/**
     * @param obj 操作的对象
     * @param att 操作的属性
     * 
     **/
	private static Object getter(Object obj, String att) {
        try {
            Method method = obj.getClass().getMethod("get" + captureName(att));
            return method.invoke(obj);
        } catch (Exception e) {
        	log.error(StringHandleUtils.getExceptionInfo(e));
			log.error("动态设值失败");
            return null;
        }
    }
 
    /**
     * 
     * @param obj 	操作的对象
     * @param att 	操作的属性
     * @param value 设置的值
     * @param type 	参数的属性
     * 
     **/
    private static void setter(Object obj, String att, Object value, Class<?> type) {
        try {
            Method method = obj.getClass().getMethod("set" + captureName(att), type);
            method.invoke(obj, value);
        } catch (Exception e) {
        	log.error(StringHandleUtils.getExceptionInfo(e));
			log.error("动态设值失败");
        }
    }
	
}
