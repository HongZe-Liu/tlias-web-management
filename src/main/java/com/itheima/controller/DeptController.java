package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;



/**
 * 部门管理控制器
 */

@RequestMapping("/depts")
@RestController
public class DeptController {

    // 创建日志记录对象 or 注解@slf4j
    private static final Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;

    /**
     * 查询全部部门列表
     */
    @GetMapping
    public Result list(){
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 删除部门数据
     */
    @DeleteMapping
    public Result delete(@RequestParam(value = "id",required = false) Integer id){
        // 输出删除信息
        log.info("根据id删除部门:{}",id);
        // 调用service方法进行删除操作
        deptService.deleteById(id);

        // 返回成功结果（使用无参success）
        return Result.success();
    }

    /**
     *  新增部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        log.info("新增部门:{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        log.info("根据id查询部门:{}",id);
        Dept dept = deptService.getbyId(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping
     public Result update(@RequestBody Dept dept){
        log.info("更新部门:{}",dept);
        deptService.update(dept);
        return Result.success(dept);
     }
}