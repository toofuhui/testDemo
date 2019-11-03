package com.hui;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;

/**
 *
 用于生成token
 */
public class JwtTest {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("1")
                .setSubject("zaa")
                .setIssuedAt(new Date())  //用于设置签发时间
                .signWith(SignatureAlgorithm.HS256, "itcast")//用于设置签名秘钥
                .setExpiration(new Date(new Date().getTime()+60000))
                .claim("role","admin");//自定义role属性
        System.out.println(jwtBuilder.compact());
    }
}
