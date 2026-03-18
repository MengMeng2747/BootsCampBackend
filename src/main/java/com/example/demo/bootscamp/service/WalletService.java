package com.example.demo.bootscamp.service;

import com.example.demo.bootscamp.dto.Res.WalletLogRes;
import com.example.demo.bootscamp.dto.Res.WalletRes;
import com.example.demo.bootscamp.entity.WalletEntity;
import com.example.demo.bootscamp.repository.WalletLogRepository;
import com.example.demo.bootscamp.repository.WalletRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WalletService {

    private final WalletRepository walletRepository;
    private final WalletLogRepository walletLogRepository;

    public WalletService(WalletRepository walletRepository,
                         WalletLogRepository walletLogRepository) {
        this.walletRepository = walletRepository;
        this.walletLogRepository = walletLogRepository;
    }

    public WalletRes getWallet(Integer userId) {

        WalletEntity wallet = walletRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("wallet not found"));

        List<WalletLogRes> logs = walletLogRepository.findByUserId(userId)
                .stream()
                .map(l -> new WalletLogRes(
                        l.getId(),
                        l.getOrderId(),   // ✅ เพิ่ม orderId
                        l.getUserId(),
                        l.getAmount(),
                        l.getType(),
                        l.getCreatedAt()
                ))
                .collect(Collectors.toList());

        return new WalletRes(
                wallet.getUserId(),
                wallet.getBalance(),
                logs
        );
    }
}