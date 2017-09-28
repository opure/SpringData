package com.oneler.domain;

import com.oneler.config.TestBean;
import com.oneler.config.TestConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class TestMain {
    public static void main(String[] args) {
/*
        //@Configuration注解的spring容器加载方式，用AnnotationConfigApplicationContext替换ClassPathXmlApplicationContext
        ApplicationContext context = new AnnotationConfigApplicationContext(TestConfiguration.class);
        TestBean tb = (TestBean) context.getBean("testBean");
        tb.sayHello();

        //如果加载spring-context.xml文件：
        //ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");*/


    }
}