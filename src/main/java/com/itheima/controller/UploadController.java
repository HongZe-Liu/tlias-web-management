package com.itheima.controller;

import com.itheima.pojo.Result;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController("")
public class UploadController {

    private static final Logger log = LoggerFactory.getLogger(UploadController.class);
    @PostMapping("/upload")
    public Result upload(String name, Integer age, MultipartFile file) {
        log.info("接收到的参数：{},{}.{}", name,age,file);
        return Result.success();
    }
}
