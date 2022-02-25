package com.laohe.controller;

import com.laohe.config.SpringScheduledCronRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class TaskController {

    @Autowired
    private ApplicationContext context;

    @Autowired
    private SpringScheduledCronRepository cronRepository;



    /**
     * 查看任务列表
     */
    @RequestMapping("/taskList")
    public String task() {

        cronRepository.addCorn();
       return cronRepository.findAll().toString();
    }

}
