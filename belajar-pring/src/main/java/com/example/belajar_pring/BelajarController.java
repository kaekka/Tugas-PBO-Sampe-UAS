package com.example.belajar_pring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    //tampilan biasa bukan html
    @GetMapping("/poksi")
    public String poksi() {
        return "Hallo semua<br>Kita dari kelompok 5<br>SENGGOL DONG!";
    }
}
