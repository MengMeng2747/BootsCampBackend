package com.example.demo.bootscamp.repository;

import com.example.demo.bootscamp.entity.OrderItemsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderItemsRepository extends JpaRepository<OrderItemsEntity, Integer> {

    List<OrderItemsEntity> findByOrderId(Integer orderId);

    // เดิม — เช็คทุก order (ใช้ใน logic อื่น)
    boolean existsByProductId(Integer productId);

    // BR-06 — เช็คเฉพาะ order ที่ยังไม่เสร็จ (status = pending หรือ shipped)
    // ลบได้เฉพาะเมื่อไม่มี order ที่ค้างอยู่เท่านั้น
    @Query("""
        SELECT COUNT(oi) > 0
        FROM OrderItemsEntity oi
        JOIN OrdersEntity o ON o.id = oi.orderId
        WHERE oi.productId = :productId
        AND o.status NOT IN ('completed')
    """)
    boolean existsByProductIdAndOrderNotCompleted(@Param("productId") Integer productId);
}