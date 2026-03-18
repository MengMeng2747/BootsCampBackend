package com.example.demo.bootscamp.controller;

import com.example.demo.bootscamp.entity.UserEntity;
import com.example.demo.bootscamp.service.AdminResellerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/resellers")
public class AdminResellerController {

    private final AdminResellerService adminResellerService;

    public AdminResellerController(AdminResellerService adminResellerService) {
        this.adminResellerService = adminResellerService;
    }

    // GET ALL
    @GetMapping("/all")
    public List<UserEntity> getResellers() {
        return adminResellerService.getResellers();
    }

    // APPROVE
    @PutMapping("/put/{id}/approve")
    public UserEntity approve(@PathVariable Long id) {
        return adminResellerService.approveReseller(id);
    }

    // REJECT
    @PutMapping("/put/{id}/reject")
    public UserEntity reject(@PathVariable Long id) {
        return adminResellerService.rejectReseller(id);
    }

}