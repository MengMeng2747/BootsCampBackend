package com.example.demo.bootscamp.controller;

import com.example.demo.bootscamp.dto.Req.RegisterReq;
import com.example.demo.bootscamp.dto.Req.LoginReq;
import com.example.demo.bootscamp.service.RegisterService;
import com.example.demo.bootscamp.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final RegisterService registerService;
    private final LoginService loginService;

    public AuthController(RegisterService registerService, LoginService loginService) {
        this.registerService = registerService;
        this.loginService = loginService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterReq req) {
        return registerService.register(req);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestBody LoginReq req) {
        return loginService.login(req);
    }
}