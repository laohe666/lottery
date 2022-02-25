package com.laohe.config;

import com.alibaba.druid.support.spring.stat.SpringStatUtils;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringUtils implements ApplicationContextAware {

    private static ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
            SpringUtils.context = applicationContext;
    }

    public static <T> T getBean(Class<T> clazz) {
        System.out.println(context);
        return context.getBean(clazz);
    }

    public static Object getBean(String name) {
        return context.getBean(name);
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }
}
