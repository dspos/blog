package com.yetao.blog.utils;

import com.yetao.blog.pojo.Admin;
import io.jsonwebtoken.Claims;
import sun.security.x509.AVA;

import java.util.HashMap;
import java.util.Map;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/12 21:44
 */

public class ClaimsUtil {

    public static final String ID = "id";
    public static final String USERNAME = "username";
    public static final String AVATAR = "avatar";
    public static final String EMAIL = "email";
    public static final String SIGN = "sign";

    public static Map<String, Object> admin2Claims(Admin admin) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(ID, admin.getId());
        claims.put(USERNAME, admin.getUsername());
        claims.put(EMAIL, admin.getEmail());
        claims.put(AVATAR, admin.getAvatar());
        claims.put(SIGN, admin.getSign());
        return claims;
    }

    public static Admin claims2Admin(Claims claims) {
        Admin admin = new Admin();
        admin.setId((String) claims.get(ID));
        admin.setUsername((String) claims.get(USERNAME));
        admin.setEmail((String) claims.get(EMAIL));
        admin.setAvatar((String) claims.get(AVATAR));
        admin.setEmail((String) claims.get(SIGN));
        return admin;
    }
}
