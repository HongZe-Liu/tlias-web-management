package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface EmpMapper {

    /**
    * 查询总记录数
    */
        @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
        public Long count();


    /**
     * 查询所有的员工及其对应的部门名称
     */
    public List<Emp> list(EmpQueryParam empQueryParam);
}