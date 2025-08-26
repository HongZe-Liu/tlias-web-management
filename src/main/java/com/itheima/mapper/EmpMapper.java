package com.itheima.mapper;

import com.itheima.pojo.Emp;
import com.itheima.pojo.EmpQueryParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpMapper {

    /**
    * 查询总记录数
    */
        @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
        public Long count();


    /**
     * 查询所有的员工信息
     */
    public List<Emp> list(EmpQueryParam empQueryParam);


    /**
     * 新增员工信息
     */
    // @options：主键返回
    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据员工批量删除员工的基本信息
     */

    void deleteByIds(List<Integer> ids);

    /**
     * 根据id查询员工信息及员工工作经历
     */
    Emp getById(Integer id);

    /**
     * 根据id更新员工基本信息
     */

    void updateById(Emp emp);

    /**
     * 统计员工职位
     **/
    @MapKey("pos")
    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别
     **/
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();
}