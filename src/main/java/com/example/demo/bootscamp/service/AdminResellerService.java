package com.example.demo.bootscamp.service;

import com.example.demo.bootscamp.entity.UserEntity;
import com.example.demo.bootscamp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminResellerService {

    private final UserRepository userRepository;

    public AdminResellerService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // GET ALL RESELLERS
    public List<UserEntity> getResellers() {
        return userRepository.findByRole("reseller");
    }

    // APPROVE
    public UserEntity approveReseller(Long id) {

        UserEntity user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("ไม่พบ user"));

        user.setStatus("approved");

        return userRepository.save(user);
    }

    // REJECT
    public UserEntity rejectReseller(Long id) {

        UserEntity user = userRepository.findById(Math.toIntExact(id))
                .orElseThrow(() -> new RuntimeException("ไม่พบ user"));

        user.setStatus("rejected");

        return userRepository.save(user);
    }

}