package com.luckk.lizzie.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author liukun.inspire
 * @Date 2023/3/8 17:12
 * @PackageName:com.luckk.lizzie.filter
 * @ClassName: XssFilter
 * @Version 1.0
 */
@WebFilter
@Component
public class XssFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // antisamy
        // XSSRequestWrapper wrappedRequest =
        //         new XSSRequestWrapper((HttpServletRequest) servletRequest);
        // chain.doFilter(wrappedRequest, response);
    }
}
