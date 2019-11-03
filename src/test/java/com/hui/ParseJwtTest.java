package com.hui;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.text.SimpleDateFormat;

/**
 * 解析token
 */
public class ParseJwtTest {
    public static void main(String[] args) {
        Claims claims = Jwts.parser().setSigningKey("itcast")
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxIiwic3ViIjoiemFhIiwiaWF0IjoxNTcyNzUzNTM1LCJleHAiOjE1NzI3NTM1OTUsInJvbGUiOiJhZG1pbiJ9.pny_E9jjugOlvJDbxEuUfSMiqVA8mxTvss7S2AHLkNY")
                .getBody();
        System.out.println("用户id："+claims.getId());
        System.out.println("用户名为："+claims.getSubject());
        System.out.println("创建时间："+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间为："+new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色为："+claims.get("role"));
    }
}
