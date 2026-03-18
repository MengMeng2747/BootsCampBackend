package com.example.demo.bootscamp.controller;

import com.example.demo.bootscamp.dto.Res.ShopProductRes;
import com.example.demo.bootscamp.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/{slug}")
    public List<ShopProductRes> getShop(@PathVariable String slug) {

        return shopService.getShopProducts(slug);
    }

    @GetMapping("/my-shop/{userId}")
    public String getMyShop(@PathVariable Integer userId){
        return shopService.getShopUrl(userId);
    }
}