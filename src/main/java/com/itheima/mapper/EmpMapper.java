package com.itheima.mapper;

import com.itheima.pojo.Emp;
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
     * 分页查询
     */
        @Select("select e.*, d.name deptName  from emp e left join dept d on e.dept_id = d.id " +
                "order by e.update_time desc limit #{start},#{pageSize}")
        public List<Emp> list(Integer start, Integer pageSize);
}