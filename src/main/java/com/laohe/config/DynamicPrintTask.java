package com.laohe.config;

import org.springframework.stereotype.Component;

@Component
public class DynamicPrintTask implements ScheduledOfTask {
    @Override
    public void execute() {
        System.out.println(Thread.currentThread() + "儿子 我是你爸爸呢");
    }
}
