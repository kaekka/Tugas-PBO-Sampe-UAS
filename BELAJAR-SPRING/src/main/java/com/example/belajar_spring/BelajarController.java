package com.example.belajar_spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class BelajarController {
    
    //bikin tampilan hello world aja
    @GetMapping("/")
    public String hello() {
        return "Hello World";
    }

    //opsional aja ini bisa custom hello blablabla
    @GetMapping("/hello/{name}")
    public String helloName (@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/welcome")
    public String showWelcome () {
        return "welcome";
    }

}
