package com.example.demo.common.service;

import com.example.demo.common.dto.BasketReq;
import com.example.demo.common.dto.BasketRes;
import com.example.demo.common.entity.BasketEntity;
import com.example.demo.common.entity.ItemEntity;
import com.example.demo.common.repository.BasketRepository;
import com.example.demo.common.repository.ItemRepository;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BasketService {

    private final BasketRepository basketRepository;
    private final ItemRepository itemRepository;

    public BasketService(BasketRepository basketRepository,
                         ItemRepository itemRepository) {
        this.basketRepository = basketRepository;
        this.itemRepository = itemRepository;
    }

    // =========================
    // ✅ GET ALL
    // =========================
    public List<BasketEntity> getAll() {
        return basketRepository.findAll();
    }

    // =========================
    // ✅ GET BY ID
    // =========================
    public BasketRes getById(Long id) {
        return basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket not found"));
    }

    // =========================
    // ✅ CREATE (POST)
    // =========================
    public BasketRes create(BasketReq basketReq) {

        ItemEntity item = itemRepository.findById(basketReq.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        BasketEntity basketEntity = new BasketEntity();
        basketEntity.setItem(item);
        basketEntity.setCustomer(basketReq.getCustomer());
        basketEntity.setQty(basketReq.getQty());

        return basketRepository.save(basketEntity);
    }
    // =========================
    // ✅ UPDATE (PUT)
    // =========================
    public BasketRes update(Long id, BasketReq basketReq) {

        BasketEntity basketEntity = basketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Basket not found"));

        ItemEntity item = itemRepository.findById(basketReq.getItemId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        basketEntity.setItem(item);
        basketEntity.setCustomer(basketReq.getCustomer());
        basketEntity.setQty(basketReq.getQty());

        return basketRepository.save(basketEntity);
    }

    // =========================
    // ✅ DELETE
    // =========================
    public void delete(Long id) {
        basketRepository.deleteById(id);
    }

}