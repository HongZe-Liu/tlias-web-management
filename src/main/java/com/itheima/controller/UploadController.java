package com.itheima.controller;

import com.itheima.pojo.Result;

import com.itheima.utils.AliyunOSSOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


@RestController("")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);
    @Autowired
    // @Autowired 实现自动装配
    private AliyunOSSOperator aliyunOSSOperator;

    // 将文件保存到阿里云
    @PostMapping("/upload")
    public Result upload(MultipartFile file)throws Exception{
        // 将要上传的文件名获取并输出到日志
        log.info("文件上传:{}",file.getOriginalFilename());
        if(!file.isEmpty()) {
            // 将文件交给oss存储处理
            // upload的返回值是返回路径
            String url = aliyunOSSOperator.upload(file.getBytes(), file.getOriginalFilename());
            log.info("文件上传的url：{}", url);
            // 日志输出文件上传的url
            return Result.success(url);
        }
        return Result.error("上传失败");
    }
}
