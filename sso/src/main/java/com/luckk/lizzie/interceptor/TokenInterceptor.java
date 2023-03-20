package com.luckk.lizzie.interceptor;

import com.luckk.lizzie.util.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @Author liukun.inspire
 * @Date 2023/3/20 00:38
 * @PackageName:com.luckk.lizzie.interceptor
 * @ClassName: TokenInterceptor
 * @Version 1.0
 */
@Slf4j
@Component
public class TokenInterceptor implements HandlerInterceptor {


    /**
     *
     */
    public static final String TOKEN_COOKIE_NAME = "token";


    @Autowired
    RedisTemplate<String,String> redisTemplate;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String tokenFromCookie = getTokenFromCookie(request);
        if (tokenFromCookie == null){
            // 要求登陆吧
            return  false;
        }


        Map<String, String> userInfoMap = TokenUtil.parseToken(tokenFromCookie);



        return false;
    }

    private String getTokenFromCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        String token = null;
        for (Cookie cookie : cookies){
            if (TOKEN_COOKIE_NAME.equals(cookie.getName())){
                token = cookie.getValue();
            }
        }
        return token;
    }
}
