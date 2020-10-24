package com.zhanghao.first.job;

import java.time.LocalTime;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * springboot中处理后台定时作业非常简单
 * 	后台定时 可以完成很多的功能。需要我自己去创新。 很吊的。
 * (我们会把代码建在com.bimowu.first.job下面，表示后台定时作业)，
 * @author ZhangHao
 *  2020-10-24
 */
@Component
public class ScheduledExample {
    // @Scheduled(fixedRate = 5000)
    // 上一次开始执行时间点之后5秒再执行
    public void job1() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(fixedDelay = 5000)
    // 上一次执行完毕时间点之后5秒再执行
    public void job2() {
        System.out.println(Thread.currentThread() + " now is " + LocalTime.now());
    }
    // @Scheduled(initialDelay = 1000, fixedRate = 5000)
    // 第一次延迟1秒后执行，之后按fixedRate的规则每5秒执行一次
    public void job3() {
        System.out.println( Thread.currentThread() + " now is " +  LocalTime.now());
    }
    
    @Scheduled(cron = "0/3 * * * * ?")
    // cron表达式
    public void job4() {
        System.out.println( Thread.currentThread() + " now is " + LocalTime.now());
    }
}