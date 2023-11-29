package com.my_bank.myBank.global.home;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@RestController
public class HomeController {
    @GetMapping("/")
    public ResponseEntity helloWorld() {
        return ResponseEntity.ok().body(
                Map.of("project", "myBank")
        );
    }
    @GetMapping("/domain/user/userDetail")
    public ModelAndView userDetail() {
        return new ModelAndView("domain/user/userDetail");
    }
    @GetMapping("/domain/account/accountDetail")
    public ModelAndView accountDetail() {
        return new ModelAndView("domain/account/accountDetail");
    }
}