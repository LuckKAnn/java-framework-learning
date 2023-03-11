package com.luckk.lizzie.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/3/8 17:48
 * @PackageName:com.luckk.lizzie.util
 * @ClassName: TokenUtil
 * @Version 1.0
 */
public class TokenUtil {
    private static final String SECRET = "LUCKKK";

    public static String getToken(String userRole) {
        return JWT.create()
                .withClaim("userRole", userRole)
                .withHeader(Collections.singletonMap("lk","lk"))
                .sign(Algorithm.HMAC256(SECRET))
                ;
    }

    public static Map<String,String > parseToken(String token){
        Map<String,String >mp = new HashMap<>();

        DecodedJWT verifyToken = JWT.require(Algorithm.HMAC256(SECRET))
                .build().verify(token);

        Date expiresAt = verifyToken.getExpiresAt();
        System.out.println(expiresAt);
        String header = verifyToken.getHeader();
        System.out.println(header);
        String userRole = verifyToken.getClaim("userRole").asString();
        System.out.println(userRole);
        mp.put("userRole", userRole);
        return mp;
    }

    public static void main(String[] args) {
        String lkkkk = TokenUtil.getToken("lkkkk");
        System.out.println(lkkkk);
        Map<String, String> stringStringMap = TokenUtil.parseToken(lkkkk);
        System.out.println(Base64Utils.decode("eyJ1c2VyUm9sZSI6Imxra2trIn0".getBytes(StandardCharsets.UTF_8)));

    }
}
