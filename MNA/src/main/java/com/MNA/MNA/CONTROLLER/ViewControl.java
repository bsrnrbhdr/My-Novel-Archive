package com.MNA.MNA.CONTROLLER;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class ViewControl {


   @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/registration")
    public String registration(){
        return ("registration");
    }

    @GetMapping("/user_page")
    public String user_page(){
        return "user_page";
    }

    @GetMapping("/save-novel")
    public String saveNovel(){
        return ("saveNovel");
    }
    @GetMapping("/list-novel")
    public String ListNovel(){
        return ("AllNovels");
    }
}
