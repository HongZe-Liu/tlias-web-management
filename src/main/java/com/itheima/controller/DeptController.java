package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 部门管理控制器
 */

/**
 * 部门管理控制器
 */
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    /**
     * 查询部门列表
     */
    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    public Result list(){
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

    /**
     * 根据id删除部门数据
     */
    @DeleteMapping("/depts")
    public Result delete(@RequestParam(value = "id",required = false) Integer id){
        // 输出删除信息
        System.out.println("删除部门的id是" + id);
        // 调用service方法进行删除操作
        deptService.deleteById(id);

        // 返回成功结果（使用无参success）
        return Result.success();
    }

    /**
     *  根据前端传递的json创建部门
     */
    @PostMapping("/depts")
    public Result add(@RequestBody Dept dept){
        System.out.println("新增部门" + dept.getName());
        deptService.add(dept);
        return Result.success();
    }

    /**
     * 根据id查询部门
     */
    @GetMapping("/depts/{id}")
    public Result getInfo(@PathVariable("id") Integer id){
        System.out.println("查询id为" + id + "的部门");
        Dept dept = deptService.getbyId(id);
        return Result.success(dept);
    }

    /**
     * 修改部门
     */
    @PutMapping("/depts")
     public Result update(@RequestBody Dept dept){
        System.out.println("修改部门：" + dept);
        deptService.update(dept);
        return Result.success(dept);
     }
}