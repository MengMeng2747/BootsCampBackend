package com.example.demo.common.controller;

import com.example.demo.common.entity.ShopEntity;
import com.example.demo.common.repository.ShopRepository;
import org.springframework.stereotype.Service;


@Service
public class ShopController {

    private final ShopRepository shopRepository;

    public ShopController(ShopRepository shopRepository){
        this.shopRepository = shopRepository;
    }

    public void saveShop(com.example.demo.dto.ShopReq shopReq) {

        ShopEntity shopEntity = new ShopEntity();

        if (shopReq.getId() != null) {
            shopEntity.setId(shopReq.getId());
        }
    }
}
