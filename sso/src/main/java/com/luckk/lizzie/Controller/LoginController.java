package com.luckk.lizzie.Controller;

import com.luckk.lizzie.util.TokenUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author liukun.inspire
 * @Date 2023/6/1 16:06
 * @PackageName: com.luckk.lizzie.Controller
 * @ClassName: LoginController
 * @Version 1.0
 */
@RestController
@RequestMapping("/login")
public class LoginController {

    @GetMapping("{name}/{password}")
    public String loginUser(@PathVariable("name") String name, @PathVariable("password") String password, HttpServletResponse response){
        System.out.println(name);
        System.out.println(password);
        Cookie cookie = new Cookie("token", TokenUtil.getToken("role"));
        response.addCookie(cookie);
        return "success";
    }

    @GetMapping("/hello")
    public String sayHello(){
        return "heelo sso";
    }

}
