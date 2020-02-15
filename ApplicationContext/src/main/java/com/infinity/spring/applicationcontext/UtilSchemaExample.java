package com.infinity.spring.applicationcontext;

import com.infinity.spring.applicationcontext.domain.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UtilSchemaExample {

    public void example (){
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("********************************************");
        System.out.println("Util Schema Example");

        //Bean with property set with util schema
        final ApplicationContext appContext = getContext();
        final Person aMan = appContext.getBean("aMan", Person.class);
        System.out.println("Getting a bean instance with a property set with util schema: " + aMan.toString());

        //Properties file read with util schema
        final Properties jdbcProperties = appContext.getBean("jdbcProperties", Properties.class);
        System.out.println("Properties file read with util schema: " + jdbcProperties.toString());

        //List read with util schema
        final List values = appContext.getBean("avengersList", List.class);
        System.out.println("List read with util schema: " + values.toString());

        //Map read with util schema
        final Map<String, String> avengersNames = appContext.getBean("avengersNames", Map.class);
        System.out.println("Map read with util schema: " + avengersNames.toString());
    }

    private ApplicationContext getContext(){
        return new ClassPathXmlApplicationContext("utilSchemaContext.xml");
    }
}
