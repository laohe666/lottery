package com.laohe.entity;


import lombok.Data;

@Data
public class SpringScheduledCron {

    /**
     * 定时任务主键ID
     */
    private String cronId;

    /**
     * 定时任务完整类名
     */
    private String cronKey;

    /**
     * 定时任务表达式
     */
    private String cronExpression;

    /**
     * 任务的描述
     */
    private String taskExplain;

    /**
     * 定时任务的状态
     */
    private String status;


}
