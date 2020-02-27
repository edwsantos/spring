package com.infinity.spring.beanscopes.prototype;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrototypeController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping("/prototype")
    public String main(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a prototype bean so it will return a different instance every time:").append("<br />");

        final PersonPrototype person1 = getBean();
        person1.setName("Tony Stark");
        person1.setAge(30);
        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");

        sb.append("<br />");
        sb.append("Then, if I request a new bean to the container and I modify it:").append("<br />");
        sb.append("<br />");

        final PersonPrototype person2 = getBean();
        person2.setName("Black Widow");
        person2.setAge(20);

        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");
        sb.append("<b>Second bean info: </b>").append(person2.toString()).append("<br />");

        return sb.toString();
    }

    private PersonPrototype getBean() {
        return applicationContext.getBean("personPrototype", PersonPrototype.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
