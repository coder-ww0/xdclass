package com.wei.xd_class.utils;

import java.security.MessageDigest;

/**
 * @author www
 * @date 2022/6/26 14:34
 * @description: 工具类
 */
public class CommonUtils {

    /**
     * md5加密
     * @param data
     * @return
     */
    public static String MD5(String data) {
        try {
            java.security.MessageDigest md =
                    MessageDigest.getInstance("MD5");
            byte[] array = md.digest(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) |
                        0x100).substring(1, 3));
            }
            return sb.toString().toUpperCase();
        } catch (Exception exception) {
        }
        return null;
    }
}
