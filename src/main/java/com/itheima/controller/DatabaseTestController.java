package com.itheima.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
public class DatabaseTestController {

    @Autowired
    private DataSource dataSource;

    @GetMapping("/test-db")
    public Map<String, Object> testDatabase() {
        Map<String, Object> result = new HashMap<>();

        try (Connection connection = dataSource.getConnection()) {
            DatabaseMetaData metaData = connection.getMetaData();

            result.put("status", "success");
            result.put("message", "数据库连接成功！");
            result.put("database", metaData.getDatabaseProductName());
            result.put("version", metaData.getDatabaseProductVersion());
            result.put("url", metaData.getURL());
            result.put("username", metaData.getUserName());

        } catch (SQLException e) {
            result.put("status", "error");
            result.put("message", "数据库连接失败");
            result.put("error", e.getMessage());
        }

        return result;
    }

    // 简单的健康检查接口
    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> result = new HashMap<>();
        result.put("status", "UP");
        result.put("message", "应用正常运行");
        return result;
    }
}