package com.example.demo.common.repository;


import com.example.demo.common.entity.ShopEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopRepository extends CrudRepository<ShopEntity, Integer> {
}
