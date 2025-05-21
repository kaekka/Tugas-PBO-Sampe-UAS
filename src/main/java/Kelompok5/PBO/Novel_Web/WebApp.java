package Kelompok5.PBO.Novel_Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebApp {
    @GetMapping("/debugging")
    public String hello() {
        return "Welcome to Novelku Web App!";
    }

    @GetMapping("/")
    public String login() {
        return "redirect:/auth/login"; 
    }

    @GetMapping("index")
    public String index() {
        return "index"; 
    }
}
