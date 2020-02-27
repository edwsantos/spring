package com.infinity.spring.beanscopes.singleton;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingletonController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @GetMapping("/singleton")
    public String main(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a singleton so it will return the same instance every time:").append("<br />");

        final PersonSingleton person1 = getBean();
        person1.setName("Tony Stark");
        person1.setAge(30);
        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");

        sb.append("<br />");
        sb.append("Then, if I request a new bean to the container and I modify it:").append("<br />");
        sb.append("<br />");

        final PersonSingleton person2 = getBean();
        person2.setName("Black Widow");
        person2.setAge(20);

        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");
        sb.append("<b>Second bean info: </b>").append(person2.toString()).append("<br />");

        sb.append("<br />");
        sb.append("As you can see, this is the same instance so if I change one of the references, the change is gonna be ");
        sb.append("reflected in all references, <b>even if you reload the page!</b>");

        return sb.toString();
    }

    private PersonSingleton getBean() {
        return applicationContext.getBean("personSingleton", PersonSingleton.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
