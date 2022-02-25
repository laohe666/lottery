package com.laohe.config;

import com.laohe.entity.SpringScheduledCron;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.util.Assert;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledThreadPoolExecutor;

@Configuration
@EnableScheduling
public class ScheduledConfig implements SchedulingConfigurer {

    @Autowired
    private SpringScheduledCronRepository repository;

    @Autowired
    private ApplicationContext context;


    @SneakyThrows
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {

        //1. 遍历出所有的定时任务
        for (SpringScheduledCron springScheduledCron : repository.findAll()) {
            System.out.println("-----------");

            Class<?> clazz  = Class.forName(springScheduledCron.getCronKey());
            Object task = context.getBean(clazz);
            Assert.isAssignable(ScheduledOfTask.class, task.getClass(),"定时任务类必须实现ScheduledOfTask接口");
            // 可以通过改变数据进而实现动态改变周期
            scheduledTaskRegistrar.addTriggerTask((Runnable) task,
                  triggerContext -> {
                      String cronExpression = repository.findByCronKey(springScheduledCron.getCronKey()).getCronExpression();
                      System.out.println(repository.findAll().toString());
                      return new CronTrigger(cronExpression).nextExecutionTime(triggerContext);
                  });
        }
    }

    @Bean
    public Executor taskExecutor() {
        return new ScheduledThreadPoolExecutor(10);
    }
}
