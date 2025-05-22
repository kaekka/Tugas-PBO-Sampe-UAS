package Kelompok5.PBO.Novel_Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @GetMapping("/aboutus")
    public String Aboutus() {
        return "fragments/aboutus";
    }

    @GetMapping("/keranjang")
    public String keranjang() {
        return "shop/keranjang";
    }

    @GetMapping("/detail-novel")
    public String detail() {
        return "detail-novel";
    }

    @GetMapping("/romansa")
    public String showRomansaPage() {
        return "fragments/romansa";
    }

    @GetMapping("/horror")
    public String showHororPage() {
        return "fragments/horror";
    }

    @GetMapping("/edukasi")
    public String showEdukasiPage() {
        return "fragments/edukasi";
    }

    @GetMapping("/fantasi")
    public String showFantasiPage() {
        return "fragments/fantasi";
    }
}
