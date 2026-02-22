package com.example.demo.product.service;

import com.example.demo.product.dto.CategoriesReq;
import com.example.demo.product.dto.CategoriesRes;
import com.example.demo.product.entity.CategoriesEntity;
import com.example.demo.product.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoriesService {

    private final CategoriesRepository categoriesRepository;

    public CategoriesService(CategoriesRepository categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    // =========================
    // CREATE (POST)
    // =========================
    public void saveCategory(CategoriesReq categoriesReq) {

        CategoriesEntity categoriesEntity = new CategoriesEntity();

        if (categoriesReq.getId() != null) {
            categoriesEntity.setId(categoriesReq.getId());
        }

        categoriesEntity.setName(categoriesReq.getName());
        categoriesEntity.setDescription(categoriesReq.getDescription());

        categoriesRepository.save(categoriesEntity);
    }

    // =========================
    // GET ALL
    // =========================
    public List<CategoriesRes> findAll() {

        List<CategoriesRes> categoriesResList = new ArrayList<>();
        List<CategoriesEntity> categoriesEntities =
                (List<CategoriesEntity>) categoriesRepository.findAll();

        for (int i = 0; i < categoriesEntities.size(); i++) {

            CategoriesEntity entity = categoriesEntities.get(i);

            CategoriesRes res = new CategoriesRes();
            res.setId(entity.getId());
            res.setName(entity.getName());
            res.setDescription(entity.getDescription());

            categoriesResList.add(res);
        }

        return categoriesResList;
    }

    // =========================
    // GET BY ID
    // =========================
    public CategoriesRes findById(Long id) {

        CategoriesEntity entity = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        CategoriesRes res = new CategoriesRes();
        res.setId(entity.getId());
        res.setName(entity.getName());
        res.setDescription(entity.getDescription());

        return res;
    }

    // =========================
    // UPDATE (PUT)
    // =========================
    public void updateCategory(Long id, CategoriesReq categoriesReq) {

        CategoriesEntity entity = categoriesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        entity.setName(categoriesReq.getName());
        entity.setDescription(categoriesReq.getDescription());

        categoriesRepository.save(entity);
    }

    // =========================
    // DELETE
    // =========================
    public void deleteCategory(Long id) {

        if (!categoriesRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }

        categoriesRepository.deleteById(id);
    }
}