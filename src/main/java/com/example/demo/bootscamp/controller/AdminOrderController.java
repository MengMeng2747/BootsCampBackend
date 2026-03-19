package com.example.demo.bootscamp.controller;

import com.example.demo.bootscamp.entity.OrdersEntity;
import com.example.demo.bootscamp.service.AdminOrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/orders")
public class AdminOrderController {

    private final AdminOrderService adminOrderService;

    public AdminOrderController(AdminOrderService adminOrderService) {
        this.adminOrderService = adminOrderService;
    }

    @GetMapping
    public List<OrdersEntity> getOrders() {
        return adminOrderService.getAllOrders();
    }

    // pending → shipped (BR-10)
    @PutMapping("/{id}/ship")
    public OrdersEntity shipOrder(@PathVariable Long id) {
        return adminOrderService.shipOrder(id);
    }

    // shipped → completed
    @PutMapping("/{id}/complete")
    public OrdersEntity completeOrder(@PathVariable Long id) {
        return adminOrderService.completeOrder(id);
    }
}