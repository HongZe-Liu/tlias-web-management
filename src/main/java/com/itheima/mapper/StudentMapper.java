package com.itheima.mapper;

import com.itheima.pojo.Student;
import com.itheima.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {

    /**
     * 分页查询学生列表
     */

    List<Student> page(StudentQueryParam studentQueryParam);

    /**
     * 批量删除学生信息
     */
    void DeleteStudentById(@Param("ids") List<Integer> ids);

    /**
     * 添加学员信息
     */
    void AddStudent(Student student);

    /**
     * 通过id查询学员信息
     */
    @Select("select * from student where id = #{id};")
    Student ReqStudent(Integer id);



    /**
     * 更新学生信息
     */
    void UpdateStudent(Student student);

    /**
     * 更新违纪分数
     */
    void violationScore(@Param("id") Integer id, @Param("violationScore") Integer score);

    /**
     * 查询学生学历
     */
    @MapKey("degree")
    List<Map<String, Object>> countStudentDegree();

    /**
     * 查询班级人数
     */
    @MapKey("clazzId")
    List<Map<String, Object>> getClassCount();
}
