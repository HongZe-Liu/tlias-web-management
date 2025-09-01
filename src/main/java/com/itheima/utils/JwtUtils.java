package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static String signKey = "SVRIRUlNQQ==";
    private static Long expire = 43200000L;

    /**
     * 生成JWT令牌
     * @return
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder() // builder：创建令牌
                .addClaims(claims) // addClaims：加入自定义内容
                .signWith(SignatureAlgorithm.HS256, signKey) // signWith()：指定加密算法
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // setExpiration：指定过期时间
                .compact(); // compact：完成令牌生成
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser() // Jwts.parser(): 解析令牌
                .setSigningKey(signKey)// setSigningKey()： 解析密钥
                .parseClaimsJws(jwt) // 解析自定义内容
                .getBody(); // 完成jwt解析
        return claims;
    }
}
