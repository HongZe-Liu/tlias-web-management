package com.itheima.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 *分页结果封装类
 */


public class PageResult<T> {
    private Long total; // 总数据
    private List<T> rows; // 返回的查询数据

    // 有参构造
    public PageResult(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }

    // 无参构造
    public PageResult() {

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
