package com.itheima.pojo;
/**
 * 接收前端传递的分页参数
 */

public class StudentQueryParam {
   private Integer page = 1;
   private Integer pageSize = 10;

   private String name;
   private Integer clazzId;
   private Integer degree;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getClazzId() {
        return clazzId;
    }

    public void setClazzId(Integer clazzId) {
        this.clazzId = clazzId;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public StudentQueryParam(Integer degree, Integer clazzId, String name, Integer pageSize, Integer page) {
        this.degree = degree;
        this.clazzId = clazzId;
        this.name = name;
        this.pageSize = pageSize;
        this.page = page;
    }

    public StudentQueryParam() {
    }
}
