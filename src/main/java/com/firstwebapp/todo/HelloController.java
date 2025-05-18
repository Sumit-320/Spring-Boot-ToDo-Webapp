package com.firstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    // http://localhost:8080/say-hello
    @RequestMapping("say-hello")
    @ResponseBody
    public String SayHelloController(){
        return "Hello, This is my first spring boot web app!";
    }

    // using JSP-Java Server Page
    @RequestMapping("say-hello-jsp")
    public String SayHelloControllerJSP(){
        return "sayHello";
    }
}
