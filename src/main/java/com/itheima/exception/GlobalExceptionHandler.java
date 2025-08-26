package com.itheima.exception;

import com.itheima.controller.EmpController;
import com.itheima.pojo.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
/**
 * 全局异常处理器
 */


@RestControllerAdvice
public class GlobalExceptionHandler {

    // 创建日志对象
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    // 设置捕获的方法
    @ExceptionHandler
    public Result handleException(Exception e){
        log.error("程序出错啦",e);

        return Result.error("出错啦，请联系管理员");
    }

    // 针对重复异常
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        // 输出日志
        log.error("程序出错 - 重复异常" , e);
        // 获取异常中的完整字符串
        // 例如：### Error updating database. Cause: java.sql.SQLIntegrityConstraintViolationException: Duplicate entry 'lisi' for key 'emp.uk_username'
        String message = e.getMessage();

        // 在完整的错误消息中查找"Duplicate entry"关键字的起始位置
        // 这是MySQL重复键错误的标志性开头，后面跟着具体的重复信息
        int i = message.indexOf("Duplicate entry");

        // 从"Duplicate entry"位置开始截取字符串，去掉前面无用的信息
        // 截取后得到：Duplicate entry 'lisi' for key 'emp.uk_username'
        String errMsg = message.substring(i);

        // 按空格将错误信息分割成字符串数组
        // 分割结果：["Duplicate", "entry", "'lisi'", "for", "key", "'emp.uk_username'"]
        String[] arr = errMsg .split(" ");

        // 提取数组中第3个元素（索引为2），这是重复的具体值
        return Result.error("msg:" + arr[2] + "已存在");
    }

}
