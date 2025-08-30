package com.itheima.pojo;


import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 班级实体类
 **/

public class Clazz {
        @NotNull(message = "班级ID不能为空")
        private Integer id;

        @NotBlank(message = "班级名称不能为空")
        private String name;

        @NotBlank(message = "教室不能为空")
        private String room;

        @NotNull(message = "开课时间不能为空")
        private LocalDate beginDate;

        @NotNull(message = "结课时间不能为空")
        private LocalDate endDate;

        @NotNull(message = "班主任ID不能为空")
        private Integer masterId;

        // subject是非必须字段，不添加验证注解
        private Integer subject;

        // 以下字段通常不需要前端传入，不添加验证

        private LocalDateTime createTime;

        private LocalDateTime updateTime;
        private String masterName;  // 通过关联查询获得
        private String status;      // 通过计算得出

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public LocalDate getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(LocalDate beginDate) {
        this.beginDate = beginDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getMasterId() {
        return masterId;
    }

    public void setMasterId(Integer masterId) {
        this.masterId = masterId;
    }

    public Integer getSubject() {
        return subject;
    }

    public void setSubject(Integer subject) {
        this.subject = subject;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public String getMasterName() {
        return masterName;
    }

    public void setMasterName(String masterName) {
        this.masterName = masterName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Clazz(Integer id, String name, String room, LocalDate beginDate, LocalDate endDate, Integer masterId, Integer subject, LocalDateTime createTime, LocalDateTime updateTime, String masterName, String status) {
        this.id = id;
        this.name = name;
        this.room = room;
        this.beginDate = beginDate;
        this.endDate = endDate;
        this.masterId = masterId;
        this.subject = subject;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.masterName = masterName;
        this.status = status;
    }

    public Clazz() {
    }
}


