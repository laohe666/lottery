package com.laohe.config;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component
public class DynamicPrintTask1 implements ScheduledOfTask{
    @Override
    public void execute() {
        System.out.println("我是你爹傻逼  ");
    }
}
