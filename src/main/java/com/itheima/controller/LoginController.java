package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.LoginInfo;
import com.itheima.pojo.Result;
import com.itheima.service.ClassService;
import com.itheima.service.EmpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 登录Controller
 */
@RestController
public class LoginController {

    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    @Autowired
    private EmpService empService;

    /**
     * 登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
        //@RequestBody：将前端的json数据封装到一个实体类中
        log.info("进行登录操作{}", emp.toString());
        LoginInfo loginInfo =  empService.login(emp);
        if(loginInfo != null) {
            return Result.success(loginInfo);
        }else return Result.error("用户名/密码不正确");
    }
}
