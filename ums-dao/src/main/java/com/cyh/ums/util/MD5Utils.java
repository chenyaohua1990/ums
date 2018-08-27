package com.cyh.ums.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class MD5Utils {

    private static Logger logger= LoggerFactory.getLogger(MD5Utils.class);

    private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f' };

    public static String encode(String str){
        String encode=null;
        try {
            if(StringUtils.isEmpty(str)){
                return str;
            }
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes());
            byte[] digest = md5.digest();
            encode= Base64.getEncoder().encodeToString(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.error(String.format("加密字符串：%s",str));
            logger.error("MD5加密失败",e);
        }
        return encode;
    }

    public static String encode(String str,String salt){
        return MD5Utils.encode(str+"-"+salt);
    }

    public static String encodeNew(String str){
        String encode=null;
        try {
            if(StringUtils.isEmpty(str)){
                return str;
            }
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(str.getBytes("UTF-8"));
            byte[] digest = md5.digest();
            encode = byteArrayToHex(digest);
        } catch (NoSuchAlgorithmException e) {
            logger.error(String.format("加密字符串：%s",str));
            logger.error("MD5加密失败",e);
        } catch (UnsupportedEncodingException e) {
            logger.error("获取UTF-8字节失败",e);
        }
        return encode;
    }


    private static String byteArrayToHex(byte[] byteArray) {
        // new一个字符数组，这个就是用来组成结果字符串的（解释一下：一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方））
        char[] resultCharArray = new char[byteArray.length * 2];
        // 遍历字节数组，通过位运算（位运算效率高），转换成字符放到字符数组中去
        int index = 0;
        for (byte b : byteArray) {
            resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
            resultCharArray[index++] = hexDigits[b & 0xf];
        }
        // 字符数组组合成字符串返回
        return new String(resultCharArray);
    }
}
