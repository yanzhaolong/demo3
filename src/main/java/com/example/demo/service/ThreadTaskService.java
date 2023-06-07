package com.example.demo.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service("threadTaskService")
public class ThreadTaskService {
    @Async("normalThreadPool")
    public void test(){
        try {

            String info = "当前线程名称:%s";
            String print = String.format(info,Thread.currentThread().getName());
            Thread.sleep(10000);
            System.out.println(print + ",执行业务方法结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
