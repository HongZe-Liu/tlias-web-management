package com.itheima.controller;

import com.itheima.pojo.Emp;
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
     * @param page 页码，从1开始
     * @param pageSize 每页显示的记录数
     * @return 包含分页数据的统一响应结果
     */
    @GetMapping
    // 使用 @RequestParam 添加默认值，如果前端没有传递值则直接使用默认值
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize) {
        // 记录日志：打印分页查询的参数信息，用于调试和监控
        log.info("分页查询：{},{}",page,pageSize);

        // 调用业务层服务：
        // 1. empService是员工服务类的实例
        // 2. 调用page方法进行分页查询
        // 3. 返回PageResult对象，包含员工列表和分页信息（总数、当前页等）
        PageResult<Emp> pageResult = empService.page(page,pageSize);

        // 封装响应结果：
        // 1. Result.success()创建成功响应
        // 2. 将分页结果作为data返回给前端
        // 3. 通常包含code、message、data等字段
        return Result.success(pageResult);
    }

}
