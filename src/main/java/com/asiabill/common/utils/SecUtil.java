package com.asiabill.common.utils;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

/**
 * 
 * <p>
 * Title:
 * </p>
 * <p>
 * Description: 采用AES负责字符串的加密与解密
 * </p>
 * <p>
 * Copyright: Copyright (c) 2011 版权
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author kevin
 * @version V1.0
 * @date 2011-5-27上午10:57:33
 */
public class SecUtil {

	private static final Log logger = LogFactory.getLog(com.asiabill.common.utils.SecUtil.class);
	/**
	 * key 可自定义
	 * XXX keybytes从外部获取
	 */
	private static byte[] keybytes  = new byte[16];

	public static byte[] getKeybytes() {
		return keybytes;
	}

	public static void setKeybytes(byte[] keybytes) {
		com.asiabill.common.utils.SecUtil.keybytes = keybytes;
	}

	/**
	 * 
	 * @author: kevin
	 * @Title encrypt
	 * @Time: 2011-5-27上午10:57:56
	 * @Description: 加密
	 * @return: String
	 * @throws:
	 * @param value
	 * @return
	 */
	public static String encrypt(String value) {

		String s = null;
		
		if(null == value){
            return s;
        }

		int mode = Cipher.ENCRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher.doFinal(value.getBytes());

			s = String.valueOf(Hex.encodeHex(outBytes));
		} catch (Exception e) {
			logger.error(StringHandleUtils.getExceptionInfo(e));
		}

		return s;
	}

	/**
	 * 
	 * @author: kevin
	 * @Title decrypt
	 * @Time: 2011-5-27上午10:58:09
	 * @Description: 解密
	 * @return: String
	 * @throws:
	 * @param value
	 * @return
	 */
	public static String decrypt(String value) {
		if(null == value){
			return null;
		}
		String s = null;

		int mode = Cipher.DECRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher
					.doFinal(Hex.decodeHex(value.toCharArray()));

			s = new String(outBytes);
		} catch (Exception e) {
		    logger.error("解密失败，解密前的值:" + value);
			logger.error(StringHandleUtils.getExceptionInfo(e));
		}

		return s;
	}
	
	public static String encryptBase64(String value) {

		String s = null;
		
		if(null == value){
            return s;
        }

		int mode = Cipher.ENCRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher.doFinal(value.getBytes());

			//此处使用BASE64做转码功能，同时能起到2次加密的作用。
			s = base64Encode(outBytes);
		} catch (Exception e) {
			logger.error(StringHandleUtils.getExceptionInfo(e));
		}

		return s;
	}
	
	public static String decryptBase64(String value) {
		if(null == value){
			return null;
		}
		String s = null;

		int mode = Cipher.DECRYPT_MODE;

		try {
			Cipher cipher = initCipher(mode);

			byte[] outBytes = cipher.doFinal(base64Decode(value));

			s = new String(outBytes);
		} catch (Exception e) {
		    logger.error("解密失败，解密前的值:" + value);
			logger.error(StringHandleUtils.getExceptionInfo(e));
		}

		return s;
	}
	
	private static String base64Encode(byte[] bytes) {
		return Base64Utils.encodeToString(bytes);
	}

	private static byte[] base64Decode(String base64Code) throws Exception {
		return Base64Utils.decodeFromString(base64Code);
	}
	
	/**
	 * 
	 * @author: kevin
	 * @Title initCipher
	 * @Time: 2011-5-27上午10:58:47
	 * @Description: 初始化密码
	 * @return: Cipher
	 * @throws:
	 * @param mode
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 */
	private static Cipher initCipher(int mode) throws NoSuchAlgorithmException,
			NoSuchPaddingException, InvalidKeyException {
		Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
		Key key = new SecretKeySpec(keybytes, "AES");
		cipher.init(mode, key);
		return cipher;
	}

	public static void main(String[] args) {

	}
}