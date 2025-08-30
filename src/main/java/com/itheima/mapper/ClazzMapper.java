package com.itheima.mapper;

import com.itheima.pojo.Clazz;
import com.itheima.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper


public interface ClazzMapper {

    /**
     * 查询班级
     */
   public List<Clazz> getClass(ClazzQueryParam clazzQueryParam);

    /**
     * 删除班级
     */
    void DeleteClass(Long id);


    /**
     * 添加班级
     */

    void AddClass(Clazz clazz);

    /**
     * 根据id查询班级
     */
    Clazz ReqClass(Long id);

    /**
     * 更新班级信息
     */
    void UpdateClass(Clazz clazz);

    /**
     * 查询全部班级列表
     */
    List<Clazz> FindAllClass();
}
