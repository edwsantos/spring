package com.infinity.spring.applicationcontext;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ContextSchemaExample {

    public void example (){
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("Context Schema Example");

        final ApplicationContext appContext = getContext();

        //Getting dataSource bean when properties are set with placeHolder
        final DriverManagerDataSource dataSource = appContext.getBean("dataSource", DriverManagerDataSource.class);
        System.out.println("Getting dataSource bean when properties are set with placeHolder: ");
        System.out.println("Url: " + dataSource.getUrl());
        System.out.println("Username: " + dataSource.getUsername());
        System.out.println("Password: " + dataSource.getPassword());

    }

    private ApplicationContext getContext(){
        return new ClassPathXmlApplicationContext("contextSchemaContext.xml");
    }
}
