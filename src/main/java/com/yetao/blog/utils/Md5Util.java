package com.yetao.blog.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/1 22:04
 */

public class Md5Util {

    public static String md5(String buffer)
    {
        String string       = null;
        char hexDigist[] = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(buffer.getBytes());
            byte[] datas = md.digest(); //16个字节的长整数

            char[] str = new char[2*16];
            int k = 0;

            for(int i=0;i<16;i++)
            {
                byte b   = datas[i];
                str[k++] = hexDigist[b>>>4 & 0xf];//高4位
                str[k++] = hexDigist[b & 0xf];//低4位
            }
            string = new String(str);
        } catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        }
        return string;
    }

    public static void main(String[] args) {
        //202cb962ac59075b964b07152d234b70
        System.out.println(Md5Util.md5("123"));
    }
}
