package com.itheima.pojo;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * 接收前端传递的分页参数
 */

public class ClazzQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数
    private String name; //班级名称

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //范围匹配的开始时间(结课时间)

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //范围匹配的结束时间(结课时间)

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public LocalDate getBegin() {
        return begin;
    }

    public void setBegin(LocalDate begin) {
        this.begin = begin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public ClazzQueryParam(Integer page, Integer pageSize, String name, LocalDate begin, LocalDate end) {
        this.page = page;
        this.pageSize = pageSize;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public ClazzQueryParam() {
    }
}
