package com.itheima.controller;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.pojo.Result;
import com.itheima.service.ClassService;
import jakarta.validation.Valid;
import org.apache.ibatis.io.ResolverUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 班级管理相关接口
 */


@RequestMapping("/clazzs")
@RestController
public class ClassController {

   @Autowired
    private ClassService classService;

    // 创建日志对象
    private static final Logger log = LoggerFactory.getLogger(ClassController.class);

    /**
     * 班级分页查询
     */
    @GetMapping
    public Result page( ClazzQueryParam clazzQueryParam){
        log.info("分页查询{}",clazzQueryParam);

        // 1.调用业务层服务，实现分页查询
        PageResult<Clazz> pageResult = classService.page(clazzQueryParam);

        return Result.success(pageResult);
    }

    /**
     *  删除班级信息
     */
    @DeleteMapping("{id}")
    public Result DeleteClass(@PathVariable Long id) {
        log.info("需要删除班级的的id为{}", id);
        classService.DeleteClass(id);
        return Result.success();
    }

    /**
     * 添加班级
     */
    @PostMapping()
    public Result AddClass(@RequestBody Clazz clazz){
        classService.AddClass(clazz);
        return Result.success();
    }

    /**
     * 根据id查询班级信息
     */
    @GetMapping("{id}")
    public Result getClass( @PathVariable Long id){
        log.info("查询班级的id为：{}",id);
        Clazz clazz = classService.ReqClass(id);
        return Result.success(clazz);
    }

    /**
     * 修改班级信息
     */
    @PutMapping
    public Result UpdateClass(@Valid @RequestBody Clazz clazz){
        log.info("修改班级信息{}",clazz);
        classService.UpdateClass(clazz);
        return Result.success(clazz);
    }

    /**
     * 查询所有班级
     */
    @GetMapping("/list")
    public Result list() {
        log.info("查询全部班级数据");
        List<Clazz> ClassList = classService.FindAllClass();
        return Result.success(ClassList);
    }


}
