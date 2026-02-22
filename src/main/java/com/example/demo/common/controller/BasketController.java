package com.example.demo.common.controller;

import com.example.demo.common.dto.BasketReq;
import com.example.demo.common.dto.BasketRes;
import com.example.demo.common.entity.BasketEntity;
import com.example.demo.common.service.BasketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/basket")
public class BasketController {

    private final BasketService basketService;

    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }

    // =========================
    // ✅ GET ALL
    // =========================
    @GetMapping("/getall")
    public ResponseEntity<BasketRes> getAll() {
        return ResponseEntity.ok((BasketRes) basketService.getAll());
    }

    // =========================
    // ✅ GET BY ID
    // =========================
    @GetMapping("/{id}")
    public ResponseEntity<BasketRes> getById(@PathVariable Long id) {
        return ResponseEntity.ok(basketService.getById(id));
    }

    // =========================
    // ✅ CREATE
    // =========================
    @PostMapping("/create")
    public ResponseEntity<BasketRes> create(@RequestBody BasketReq basketReq) {
        return ResponseEntity.ok(basketService.create(basketReq));
    }

    // =========================
    // ✅ UPDATE
    // =========================
    @PutMapping("/update/{id}")
    public ResponseEntity<BasketRes> update(
            @PathVariable Long id,
            @RequestBody BasketReq basketReq) {
        return ResponseEntity.ok(basketService.update(id, basketReq));
    }

    // =========================
    // ✅ DELETE
    // =========================
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        basketService.delete(id);
        return ResponseEntity.noContent().build();
    }
}