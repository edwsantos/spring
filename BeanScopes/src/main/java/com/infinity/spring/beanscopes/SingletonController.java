package com.infinity.spring.beanscopes;

import com.infinity.spring.beanscopes.domain.Person;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
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

        final Person person1 = getBean();
        person1.setName("Tony Stark");
        person1.setAge(30);
        sb.append("First bean info: ").append(person1.toString()).append("<br />");

        sb.append("Then, if I request a new bean to the container and I modify it:").append("<br />");

        final Person person2 = getBean();
        person2.setName("Black Widow");
        person2.setAge(20);

        sb.append("First bean info: ").append(person1.toString()).append("<br />");
        sb.append("Second bean info: ").append(person2.toString()).append("<br />");

        return sb.toString();
    }

    private Person getBean() {
        return applicationContext.getBean("person", Person.class);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}
