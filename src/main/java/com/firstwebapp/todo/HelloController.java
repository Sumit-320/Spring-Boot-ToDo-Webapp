package com.firstwebapp.todo;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class HelloController {
    // http://localhost:8080/say-hello

    // using JSP-Java Server Page
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String SayHelloControllerJSP(ModelMap model){
        model.put("name",getLoggedinUsername());
        return "sayHello";
    }
     private String getLoggedinUsername(){ // gives currenlty authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName(); // if there is no logged in user..it might return null
     }
}
