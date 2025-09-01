package com.itheima.filter;

import com.itheima.controller.ClassController;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * 校验Filter
 */
@WebFilter(urlPatterns = "/*")
public class TokenFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);


    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 获取请求路径
        String RequestURI = request.getRequestURI();

        // 判断是否是登录请求（查看路径中是否包含login）是登录放行
        if (RequestURI.contains("/login")) {
            log.info("登录请求放行");
            filterChain.doFilter(request, response); // 令牌放行
            return;
        }

        // 获取请求头中的token
        String token = request.getParameter("token");

        // 判断token是否存在，如果不存在返回登录信息
        if(token==null || token.isEmpty()){
            log.info("令牌为空：响应401");
            response.setStatus(401);
            return;
        }

        // 如果token存在，校验令牌 -> 返回错误信息
        try{
            JwtUtils.parseJWT(token); // 调用工具类验证token
        }catch (Exception e){
            log.info("令牌非法：响应401");
            response.setStatus(401);
            return;
        }

        // 如果校验成功 -> 放行
        log.info("令牌合法，放行");
        filterChain.doFilter(request, response);
    }
}
