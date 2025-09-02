package com.itheima.interceptor;


import com.itheima.controller.ClassController;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class DemoInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    // controller 方法之前运行 - 返回值： true 放行 / false 不放行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("prehandle ...");
        return false;
    }

    // controller 方法之后运行 -
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
       log.info("postHandle ...");
    }

    // 视图渲染后运行
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
       log.info("afterCompletion ...");
    }

}
