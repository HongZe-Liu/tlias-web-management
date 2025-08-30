package com.itheima.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.itheima.mapper.ClazzMapper;
import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import com.itheima.pojo.PageResult;
import com.itheima.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ClassServiceImpl implements ClassService {

    @Autowired
    private ClazzMapper clazzMapper;


    /**
     * 分页查询班级信息
     */

    @Override
    public PageResult page(ClazzQueryParam clazzQueryParam) {
        // 1.设置分页参数
        PageHelper.startPage(clazzQueryParam.getPage(), clazzQueryParam.getPageSize());

        // 2.执行查询
        List<Clazz> classList = clazzMapper.getClass(clazzQueryParam);
        // 3.封装结果
        Page<Clazz> p = (Page<Clazz>) classList;
        return new PageResult(p.getTotal(), p.getResult());
    }




    /**
     * 删除班级
     */
    @Override
    public void DeleteClass(Long id) {
            clazzMapper.DeleteClass(id);
    }



    @Override
    public void AddClass(Clazz clazz) {
        clazzMapper.AddClass(clazz);
    }

    /**
     * 根据id查询班级信息
     */

    @Override
    public Clazz ReqClass(Long id) {
        return clazzMapper.ReqClass(id);
    }

    @Override
    public void UpdateClass(Clazz clazz) {
        // 补全基础信息
        clazz.setUpdateTime(LocalDateTime.now());
        // 调用Mapper接口方法更新部门
        clazzMapper.UpdateClass(clazz);
    }

    @Override
    public List<Clazz> FindAllClass() {
        return clazzMapper.FindAllClass();
    }


}
