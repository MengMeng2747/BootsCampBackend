package com.example.demo.bootscamp.service;

import com.example.demo.bootscamp.entity.*;
import com.example.demo.bootscamp.repository.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdminOrderService {

    private final OrdersRepository orderRepository;
    private final OrderItemsRepository orderItemRepository;
    private final WalletRepository walletRepository;
    private final WalletLogRepository walletLogRepository;
    private final ShopRepository shopRepository;

    public AdminOrderService(OrdersRepository orderRepository,
                             OrderItemsRepository orderItemRepository,
                             WalletRepository walletRepository,
                             WalletLogRepository walletLogRepository,
                             ShopRepository shopRepository) {

        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
        this.walletRepository = walletRepository;
        this.walletLogRepository = walletLogRepository;
        this.shopRepository = shopRepository;
    }

    // =========================
    // GET ALL ORDERS
    // =========================
    public List<OrdersEntity> getAllOrders() {
        return orderRepository.findAll();
    }

    // =========================
    // SHIP ORDER
    // =========================
    @Transactional
    public OrdersEntity shipOrder(Long orderId) {

        // หา order
        OrdersEntity order = orderRepository.findById(orderId.intValue())
                .orElseThrow(() -> new RuntimeException("ไม่พบ order"));

        // ship ได้เฉพาะ pending
        if (!"pending".equalsIgnoreCase(order.getStatus())) {
            throw new RuntimeException("ออเดอร์นี้ถูกจัดส่งแล้ว");
        }

        // หา order items
        List<OrderItemsEntity> items =
                orderItemRepository.findByOrderId(order.getId());

        if (items.isEmpty()) {
            throw new RuntimeException("order ไม่มีสินค้า");
        }

        // =========================
        // คำนวณกำไร reseller
        // =========================
        BigDecimal totalProfit = BigDecimal.ZERO;

        for (OrderItemsEntity item : items) {
            BigDecimal profit = item.getSellingPrice()
                    .subtract(item.getCostPrice())
                    .multiply(BigDecimal.valueOf(item.getQuantity()));

            totalProfit = totalProfit.add(profit);
        }

        // =========================
        // หา shop → reseller user
        // =========================
        ShopEntity shop = shopRepository.findById(order.getShopId())
                .orElseThrow(() -> new RuntimeException("ไม่พบ shop"));

        Integer userId = shop.getUserId();

        // =========================
        // หา wallet reseller
        // =========================
        WalletEntity wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("ไม่พบ wallet"));

        // =========================
        // เพิ่มเงินใน wallet
        // =========================
        wallet.setBalance(wallet.getBalance().add(totalProfit));
        walletRepository.save(wallet);

        // =========================
        // บันทึก wallet log (set ครบก่อน แล้ว save ครั้งเดียว)
        // =========================
        WalletLogEntity log = new WalletLogEntity();
        log.setWalletId(wallet.getId());
        log.setOrderId(order.getId());
        log.setUserId(userId);
        log.setAmount(totalProfit);
        log.setType("PROFIT");
        log.setCreatedAt(LocalDateTime.now());

        walletLogRepository.save(log); // ✅ save ครั้งเดียวเท่านั้น

        // =========================
        // เปลี่ยน status order
        // =========================
        order.setStatus("shipped");

        return orderRepository.save(order);
    }
}