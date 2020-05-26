//package com.MNA.MNA.CONTROLLER;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import javax.servlet.http.HttpSession;
//
//
//@Controller
//public class ViewControl {
//
//    @GetMapping(value = "/hello")
//    public void home(HttpSession session, Authentication authentication) {
//        String sessionId = session.getId();
//        String auth = authentication.getName();
////      String auth = authentication.getPrincipal().toString();
//        System.out.println("[session-id]: " + sessionId);
//        System.out.println("[auth-id]: " + auth);
//    }
//
//   @GetMapping("/login")
//    public String login(){
//        return "login";
//    }
//    @GetMapping("/index")
//    public String home(){
//        return "index";
//    }
//
//    @GetMapping("/registration")
//    public String registration(){
//        return ("registration");
//    }
//
//    @GetMapping("/user_page")
//    public String user_page(){
//        return "user_page";
//    }
//
//    @GetMapping("/save-novel")
//    public String saveNovel(){
//        return ("saveNovel");
//    }
//    @GetMapping("/list-novel")
//    public String ListNovel(){
//        return ("AllNovels");
//    }
//}
