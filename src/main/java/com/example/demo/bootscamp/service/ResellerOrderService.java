package com.example.demo.bootscamp.service;

import com.example.demo.bootscamp.dto.Res.ResellerOrderRes;
import com.example.demo.bootscamp.entity.OrdersEntity;
import com.example.demo.bootscamp.repository.OrdersRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResellerOrderService {

    private final OrdersRepository ordersRepository;

    public ResellerOrderService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    public List<ResellerOrderRes> getOrders(Long resellerId){

        List<OrdersEntity> orders = ordersRepository.getResellerOrders(Math.toIntExact(resellerId));

        return orders.stream().map(o -> new ResellerOrderRes(
                o.getId(),
                o.getCustomerName(),
                null,
                null,
                null,
                o.getStatus()
        )).collect(Collectors.toList());
    }
}