package com.lhr.idivine.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String path(){
        return "redirect:/home/main";
    }

    @RequestMapping("/home/main")
    public String home(){
        return "home/main";
    }

    @RequestMapping("/home/manager")
    public String manager(){
        return "home/manager";
    }
}
