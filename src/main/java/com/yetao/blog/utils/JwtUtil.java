package com.yetao.blog.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Date;

/**
 * @Author yetao
 * @Date 2020/8/28 10:46
 * @Description Jwt工具类
 */

public class JwtUtil {

    //设置有效期--两个小时
    public static final Long JWT_TTL = 3600000L * 2;
    //设置密匙明文
    public static final String JWT_KEY = "yetao1";

    /**
     * 创建token
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     */
    public static String createJWT(Long id, String subject, Long ttlMillis) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        if (ttlMillis == null) {
            ttlMillis = JwtUtil.JWT_TTL;
        }
        long expMillis = nowMillis + ttlMillis;
        Date expDate = new Date(expMillis);
        SecretKey secretKey = generalKey();
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id.toString())
                .setSubject(subject)
                .setIssuer("admin")
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, secretKey)
                .setExpiration(expDate);
        return jwtBuilder.compact();
    }

    /**
     * 生成加密后的密钥secretKey
     * @return
     */
    public static SecretKey generalKey() {
        byte[] encodedKey = Base64.getDecoder().decode(JwtUtil.JWT_KEY);
        SecretKey secretKey = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return secretKey;
    }

    /**
     * 解析jwt
     * @param jwt
     * @return
     */
    public static Claims parseJWT(String jwt) {
        SecretKey secretKey = generalKey();
        return Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(jwt)
                .getBody();
    }
}
