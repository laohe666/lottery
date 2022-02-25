package com.laohe.config;

import com.laohe.entity.SpringScheduledCron;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpringScheduledCronRepository implements DisposableBean {

    private static int i = 0;

    @Autowired
    private ApplicationContext context;

    @Autowired
    TaskScheduler taskScheduler;

    private static List<SpringScheduledCron> list = new ArrayList<>();
    {
       list = new ArrayList<>();
        SpringScheduledCron springScheduledCron = new SpringScheduledCron();
        springScheduledCron.setCronId("0001");
        springScheduledCron.setCronKey("com.laohe.config.DynamicPrintTask");
        springScheduledCron.setCronExpression("*/5 * * * * ?");
        springScheduledCron.setStatus("1");
        list.add(springScheduledCron);
    }

    public SpringScheduledCron findByCronKey(String cronKey){
        SpringScheduledCron cron = null;
        List<SpringScheduledCron> list = findAll();
        for (SpringScheduledCron springScheduledCron : list) {
            if (springScheduledCron.getCronKey().equals(cronKey)) {
                cron = springScheduledCron;
            }
        }
        return cron;

    }

    public List<SpringScheduledCron> findAll() {
        return list;
    }

    public void addCorn() {
        SpringScheduledCronRepository bean = context.getBean(SpringScheduledCronRepository.class);
        SpringScheduledCron springScheduledCron = new SpringScheduledCron();
        springScheduledCron.setCronId("0002");
        springScheduledCron.setCronKey("com.laohe.config.DynamicPrintTask1");
        springScheduledCron.setCronExpression("*/6 * * * * ?");
        springScheduledCron.setStatus("1");


        list.add(springScheduledCron);
    }

    @Override
    public void destroy() throws Exception {

    }
}
