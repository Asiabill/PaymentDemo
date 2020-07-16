package com.asiabill.common.utils;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.lang3.StringUtils;


/**
 *
 * <p>Title: </p>
 * <p>Description: 加密类</p>
 * <p>Copyright: Copyright (c) 2011 版权</p>
 * <p>Company: </p>
 * @author kevin
 * @version V1.0
 * @date 2011-6-10下午02:26:39
 */
public class EncryptUtil {
    static final char[] HEX_TABLE = new char[] {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    /**
     *
     * @author: kevin
     * @Title getEncrypt
     * @Time: 2011-6-10下午02:26:59
     * @Description: SHA256位加密
     * @return: String
     * @throws:
     * @param strSrc
     * @return
     */
    public String getSHA256Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("SHA-256");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes;
    }

    /**
     *
     * @author: kevin
     * @Title getMD5Encrypt
     * @Time: 2011-6-10下午02:29:14
     * @Description: MD5加密
     * @return: String
     * @throws:
     * @param strSrc
     * @return
     */
    public String getMD5Encrypt(String strSrc) {
        MessageDigest md = null;
        String strDes = null;

        byte[] bt = strSrc.getBytes();
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(bt);
            strDes = bytes2Hex(md.digest());
        }
        catch (NoSuchAlgorithmException e) {
            return null;
        }
        return strDes.toUpperCase();
    }

    /**
     *
     * @author: kevin
     * @Title bytes2Hex
     * @Time: 2011-6-10下午02:27:13
     * @Description:
     * @return: String
     * @throws:
     * @param bts
     * @return
     */
    public String bytes2Hex(byte[]bts) {
        StringBuffer des = new StringBuffer();
        String tmp = null;
        for (int i = 0; i < bts.length; i++) {
            tmp = (Integer.toHexString(bts[i] & 0xFF));
            if (tmp.length() == 1) {
                des.append("0");
            }
            des.append(tmp);
        }
        return des.toString();
    }

    public static String getHmacSHA256(String key, String data) throws Exception {
        byte[] mac = null;
//        byte[] keybyte = fromHexString(key, 0, key.length());
        byte[] keybyte = new byte[64];
        if(StringUtils.isNotBlank(key)) {
            keybyte = key.getBytes();
        }

        SecretKeySpec secret_key = new SecretKeySpec(keybyte, "HmacSHA256");
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        sha256_HMAC.init(secret_key);

        sha256_HMAC.update(data.getBytes("ISO-8859-1"));
        mac = sha256_HMAC.doFinal();
        return hex(mac);
    }

    public static String stringToHex(String base) throws UnsupportedEncodingException
    {
        return String.format("%040x", new BigInteger(1, base.getBytes("UTF-8")));
    }

    public static void main(String[] args) throws Exception {

//		System.out.println(new EncryptUtil().getSHA256Encrypt("10533105330012013121017455958139483paymenttest2013-12-10 17:42:2610000_Unknown Exception").toUpperCase());
//		System.out.println(new EncryptUtil().getSHA256Encrypt("10533105330012013121017455958139483paymenttest2013-12-10 17:42:2610000_Approved").toUpperCase());
//		System.out.println(new EncryptUtil().getSHA256Encrypt("10533105330012013121017455958139483paymenttest2013-12-10 17:42:2610000_Unknown Exception8b2zfJP2").toUpperCase());
//		System.out.println(new EncryptUtil().getSHA256Encrypt("88888888880012013121117121400370751138675313003410000_Approved12345678").toUpperCase());
        byte[] mac = null;
        try {
            String key = "";
            byte []  b = fromHexString(key, 0, key.length());
            //String message = "vpc_AccessCode=C73DAB90&vpc_Amount=7&vpc_CardExp=1902&vpc_CardNum=4111111111111129&vpc_CardSecurityCode=123&vpc_Command=pay&vpc_Currency=156&vpc_Locale=en_AU&vpc_MerchTxnRef=2017090611262945523647&vpc_Merchant=TEST001070029707&vpc_OrderInfo=2017090611262945523647&vpc_ReturnURL=http%3A%2F%2F127.0.0.1%3A8090%2FCCPG%2FReceiveBankInterface%3FLOT_CHANNEL_CODE%3D2402&vpc_Version=1";
            String message = "x_account_id1568a586647144d9a17a47f35683ac6bd7f531fd6x_amount12.00x_currencyUSDx_gateway_reference372a5fd4cb2a98bac32289f1127655x_messageGateway Authentication Failed. Please, check your gateway credentials and try again!x_reference7514946240623x_resultfailedx_testtruex_timestamp2018-12-14T11:46:17Z";
//            Mac hasher = Mac.getInstance("HmacSHA256");
//            hasher.init(new SecretKeySpec(b, "HmacSHA256"));
//            hasher.update(message.getBytes("ISO-8859-1"));
//            mac = hasher.doFinal();
//            String hashString = hex(mac);
//            System.out.println(hashString);
            System.out.println(EncryptUtil.getHmacSHA256(key,message));
            // to lowercase hexits
            //System.out.println(DatatypeConverter.printHexBinary(hash));

            // to base64
            //System.out.println(DatatypeConverter.printBase64Binary(hash));
        }
        catch (NoSuchAlgorithmException e) {}
        catch (InvalidKeyException e) {}

    }

    public static byte[] fromHexString(String s, int offset, int length)
    {
        if ((length%2) != 0) {
            return null;
        }
        byte[] byteArray = new byte[length/2];
        int j = 0;
        int end = offset+length;
        for (int i = offset; i < end; i += 2)
        {
            int high_nibble = Character.digit(s.charAt(i), 16);
            int low_nibble = Character.digit(s.charAt(i+1), 16);
            if (high_nibble == -1 || low_nibble == -1)
            {
                // illegal format
                return null;
            }
            byteArray[j++] = (byte)(((high_nibble << 4) & 0xf0) | (low_nibble & 0x0f));
        }
        return byteArray;
    }

    public static String hex(byte[] input) {
        // create a StringBuffer 2x the size of the hash array
        StringBuffer sb = new StringBuffer(input.length * 2);

        // retrieve the byte array data, convert it to hex
        // and add it to the StringBuffer
        for (int i = 0; i < input.length; i++) {
            sb.append(HEX_TABLE[(input[i] >> 4) & 0xf]);
            sb.append(HEX_TABLE[input[i] & 0xf]);
        }
        return sb.toString();
    }
}
