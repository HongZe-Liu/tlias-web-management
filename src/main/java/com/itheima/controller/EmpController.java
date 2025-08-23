package com.itheima.controller;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

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

    /**
     * 新增员工
     */
    @PostMapping("")
    public Result save(@RequestBody  Emp emp) {
    log.info("新增员工:{}", emp);
    empService.save(emp);
    return Result.success();
    }

    /***
     * 员工信息删除
     */
    @DeleteMapping("")
    public Result delete(@RequestParam List<Integer> ids) {
        log.info("要删除员工的id为：{}", ids);
        empService.delete(ids);
        return Result.success();
    }

    /**
     * 根据id查询员工信息
     */
    @GetMapping("/{id}")
    //@PathVariable 从路径中提取数值并绑定给对象
    public Result getInfor(@PathVariable Integer id) {
        log.info("需要查询员工的id是:{}" , id );
        Emp emp = empService.getInfo(id);
        return Result.success(emp);
    }

}
