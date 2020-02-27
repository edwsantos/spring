package com.infinity.spring.beanscopes.session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SessionController {

    @Autowired
    private PersonSession person1;
    @Autowired
    private PersonSession person2;

    @GetMapping("/session")
    public String main(){
        StringBuilder sb = new StringBuilder();
        sb.append("This is a session bean so it will return the same instance every time you reload the page:").append("<br />");

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
        sb.append("As you can see, this is the same instance because is the same Request and Session! ");
        sb.append("Even if you reload the page, it will return the same instance, <b>try it!</b>");
        sb.append("<br /><br />");
        sb.append("But if you open the same URL in a different browser, it will return a different instance because it's a different session");

        return sb.toString();
    }
}
