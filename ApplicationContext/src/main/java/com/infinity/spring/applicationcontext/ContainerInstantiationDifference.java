package com.infinity.spring.applicationcontext;

import com.infinity.spring.applicationcontext.domain.Person;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class ContainerInstantiationDifference {

    public void example (){
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("BeanFactory usage example");
        beanFactoryExample();

        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("ApplicationContext usage example");
        applicationContextExample();
    }

    private static void beanFactoryExample(){
        //BeanFactory instantiation example
        DefaultListableBeanFactory factory = new DefaultListableBeanFactory();
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(factory);
        reader.loadBeanDefinitions(new ClassPathResource("beans.xml"));

        //Getting beans from factory
        final Person person = (Person) factory.getBean("person");
        System.out.println("Bean taken from beans.xml by using BeanFactory: " + person.toString());

        //Getting bean from factory by using an alias
        final Person theMan = (Person) factory.getBean("anotherPerson");
        theMan.setName("Another Person");
        theMan.setAge(200);
        System.out.println("Using alias: bean taken from the config file by its alias -> "+ theMan.toString());

        //Shutting down the spring beanFactory container
        ((ConfigurableBeanFactory)factory).destroySingletons();
    }

    private static void applicationContextExample(){
        //Application context instantiation example
        ApplicationContext appContext = new ClassPathXmlApplicationContext("beans.xml");

        //Getting beans from appContext
        final Person person = appContext.getBean("person", Person.class);
        System.out.println("Bean taken from beans.xml by using ApplicationContext: " + person.toString());

        //Getting bean from factory by using an alias
        final Person theMan = appContext.getBean("anotherPerson", Person.class);
        theMan.setName("Another Person");
        theMan.setAge(200);
        System.out.println("Using alias: bean taken from the config file by its alias -> "+ theMan.toString());

        //Shutting down the spring applicationContext container
        ((ClassPathXmlApplicationContext)appContext).close();
    }
}
