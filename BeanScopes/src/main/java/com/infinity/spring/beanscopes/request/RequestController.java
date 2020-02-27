package com.infinity.spring.beanscopes.request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RequestController  {

    @Autowired
    private PersonRequest person1;
    @Autowired
    private PersonRequest person2;

    @GetMapping("/request")
    public String main(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a request bean so it will return differet instances if you reload the page:").append("<br />");

        person1.setName("Tony Stark");
        person1.setAge(30);
        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");

        sb.append("<br />");
        sb.append("Then, if I request a new bean to the container and I modify it:").append("<br />");
        sb.append("<br />");

        person2.setName("Black Widow");
        person2.setAge(20);

        sb.append("<b>First bean info: </b>").append(person1.toString()).append("<br />");
        sb.append("<b>Second bean info: </b>").append(person2.toString()).append("<br />");

        sb.append("<br />");
        sb.append("As you can see, this is the same instance because is the same Request! ");
        sb.append("But if you reload the page, it will create a different instance, <b>try it!</b>");

        return sb.toString();
    }
}
