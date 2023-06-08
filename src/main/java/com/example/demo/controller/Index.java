package com.example.demo.controller;

import com.example.demo.service.ThreadTaskService;
import com.example.demo.util.SpringUtil;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import javax.servlet.ServletRequest;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class Index {
    @Resource
    ThreadTaskService threadTaskService;


    @GetMapping("/test")
    public @ResponseBody  String index(ServletRequest request) throws InterruptedException {
        threadTaskService.test();
        System.out.println("主线程名称:"+ Thread.currentThread().getName()+ ",接口调用成功");
        System.out.println("master修改1");
        return "接口调用成功";
    }
}
