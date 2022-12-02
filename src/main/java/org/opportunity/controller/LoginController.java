package org.opportunity.controller;

import org.opportunity.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/")
public class LoginController {
    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService login) {
        this.loginService = login;
    }

    @PostMapping("loginTest")
    public String getData(@RequestBody Map<String, String> user) {
        return "{\"login_success\": " + (loginService.checkUser(user.get("usuario")) && loginService.checkPass(user.get("password"))) +"}";
    }
}
