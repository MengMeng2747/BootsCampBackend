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
    // ใช้ EXISTS แทน COUNT(*) > 0 เพื่อความเข้ากันได้ทุก DB
    @Query(value = """
        SELECT EXISTS (
            SELECT 1
            FROM order_items oi
            INNER JOIN orders o ON o.id = oi.order_id
            WHERE oi.product_id = :productId
            AND o.status IN ('pending', 'shipped')
        )
    """, nativeQuery = true)
    boolean existsByProductIdAndOrderNotCompleted(@Param("productId") Integer productId);
}