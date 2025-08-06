package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 员工管理
 */

@RequestMapping("/emps")
@RestController
public class EmpController {

    // 创建日志对象
    private static final Logger log = LoggerFactory.getLogger(EmpController.class);

    @Autowired
    private EmpService empService;

    /**
     * 员工分页查询接口
     */
    @GetMapping
    // 使用 @RequestParam 添加默认值，如果前端没有传递值则直接使用默认值
    public Result page(EmpQueryParam empQueryParam) {
        // 记录日志：打印分页查询的参数信息，用于调试和监控
        log.info("分页查询：{},{}", empQueryParam);

        // 调用业务层服务：实现分页查询
        PageResult<Emp> pageResult = empService.page(empQueryParam);

        // 封装响应结果：
        return Result.success(pageResult);
    }

}
