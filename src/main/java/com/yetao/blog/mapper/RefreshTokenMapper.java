package com.yetao.blog.mapper;

import com.yetao.blog.pojo.RefreshToken;

/**
 * @author YETAO
 * @Description
 * @date 2020/8/13 21:25
 */

public interface RefreshTokenMapper {

    int saveToken(RefreshToken refreshToken);
}
