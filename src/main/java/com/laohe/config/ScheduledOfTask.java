package com.laohe.config;

import com.laohe.entity.SpringScheduledCron;

public interface ScheduledOfTask extends Runnable{

    /**
     * 定时任务方法
     */
    void execute();

    /**
     * 实现控制定时任务启用或禁用的功能
     */
    @Override
    default void run() {
        SpringScheduledCronRepository repository = SpringUtils.getBean(SpringScheduledCronRepository.class);
        SpringScheduledCron springScheduledCron = repository.findByCronKey(this.getClass().getName());
        if ("".equals(springScheduledCron.getStatus())) {
            return;
        }

        execute();
    }
}
