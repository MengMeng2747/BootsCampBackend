package com.example.demo.product.service;

import com.example.demo.product.dto.ProductsReq;
import com.example.demo.product.dto.ProductsRes;
import com.example.demo.product.dto.ShopproductReq;
import com.example.demo.product.entity.ProductsEntity;
import com.example.demo.product.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductsService {

    private static ProductsRepository productsRepository;

    public ProductsService(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    // =========================
    // CREATE (POST)
    // =========================
    public void saveProduct(ProductsReq productsReq) {

        ProductsEntity productsEntity = new ProductsEntity();

        if (productsReq.getId() != null) {
            productsEntity.setId(productsReq.getId());
        }

        productsEntity.setCategoryId(productsReq.getCategoryId());
        productsEntity.setName(productsReq.getName());
        productsEntity.setDescription(productsReq.getDescription());
        productsEntity.setPrice(productsReq.getPrice());
        productsEntity.setStock(productsReq.getStock());

        productsRepository.save(productsEntity);
    }

    // =========================
    // GET ALL
    // =========================
    public List<ProductsRes> findAll(){

        List<ProductsRes> productsResList = new ArrayList<>();
        List<ProductsEntity> productsEntities =
                (List<ProductsEntity>) productsRepository.findAll();

        for (int i = 0; i < productsEntities.size(); i++){

            ProductsEntity entity = productsEntities.get(i);

            ProductsRes productsRes = new ProductsRes();
            productsRes.setId(entity.getId());
            productsRes.setCategoryId(entity.getCategoryId());
            productsRes.setName(entity.getName());
            productsRes.setDescription(entity.getDescription());
            productsRes.setPrice(entity.getPrice());
            productsRes.setStock(entity.getStock());

            productsResList.add(productsRes);
        }

        return productsResList;
    }

    // =========================
    // GET BY ID
    // =========================
    public ProductsRes findById(Long id){

        ProductsEntity productsEntity = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductsRes productsRes = new ProductsRes();
        productsRes.setId(productsEntity.getId());
        productsRes.setCategoryId(productsEntity.getCategoryId());
        productsRes.setName(productsEntity.getName());
        productsRes.setDescription(productsEntity.getDescription());
        productsRes.setPrice(productsEntity.getPrice());
        productsRes.setStock(productsEntity.getStock());

        return productsRes;
    }

    // =========================
    // UPDATE (PUT)
    // =========================
    public void updateProduct(Long id, ProductsReq productsReq) {

        ProductsEntity productsEntity = productsRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        productsEntity.setCategoryId(productsReq.getCategoryId());
        productsEntity.setName(productsReq.getName());
        productsEntity.setDescription(productsReq.getDescription());
        productsEntity.setPrice(productsReq.getPrice());
        productsEntity.setStock(productsReq.getStock());

        productsRepository.save(productsEntity);
    }

    // =========================
    // DELETE
    // =========================
    public void deleteProduct(Long id) {

        if (!productsRepository.existsById(id)) {
            throw new RuntimeException("Product not found");
        }

        productsRepository.deleteById(id);
    }

    public static String buyProduct(ShopproductReq shopproductReq) {
        ProductsEntity productsEntity = new ProductsEntity();

        // 1. เช็คว่าเจอสินค้าหรือไม่
        // ค้นหาสินค้าจาก Database
        ProductsEntity product = productsRepository.findById(shopproductReq.getIdproduct()).orElse(null);

        if (product == null) {
            System.out.println("ไม่พบสินค้าในระบบ");
            return null;
        }

        // 2. เช็คจำนวนสินค้า (Stock) ก่อนว่ามีในระบบหรือไม่
        if (product.getStock() <= 0) {
            System.out.println("สินค้าหมด (Out of stock)");
            return null;
        }

        // 3. เช็คเงินที่มีอยู่ว่ามีค่ามากกว่า 0 หรือไม่
        if (shopproductReq.getMoney() == null || shopproductReq.getMoney().compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("จำนวนเงินของคุณไม่ถูกต้อง");
            return null;
        }

        // 4. เช็คจำนวนสินค้าที่จะซื้อ (ต้องมากกว่า 0 และไม่เกินสต๊อกที่มี)
        if (shopproductReq.getCountproduct() <= 0) {
            System.out.println("จำนวนที่ต้องการซื้อต้องมากกว่า 0");
            return null;
        }
        if (shopproductReq.getCountproduct() > product.getStock()) {
            System.out.println("จำนวนสินค้าในสต๊อกไม่เพียงพอ (มีอยู่: " + product.getStock() + " ชิ้น)");
            return null;
        }

        // 5. คิดผลรวมของสินค้าที่จะซื้อ และตรวจสอบกับเงินที่มี
        BigDecimal totalPrice = product.getPrice().multiply(new BigDecimal(shopproductReq.getCountproduct()));

        if (shopproductReq.getMoney().compareTo(totalPrice) < 0) {
            System.out.println("ยอดเงินไม่เพียงพอ (ราคารวม: " + totalPrice + ", เงินที่มี: " + shopproductReq.getMoney() + ")");
            return null;
        }

        // 6. ผ่านทุกเงื่อนไข -> ทำการหักสต๊อกและบันทึกลง Database สินค้าในสต๊อก - สินค้าในตะกร้า
        product.setStock(product.getStock() - shopproductReq.getCountproduct());
        productsRepository.save(product);
        System.out.println("สั่งซื้อสำเร็จ! ยอดรวม: " + totalPrice + " | สต๊อกคงเหลือ: " + product.getStock());
        return null;
    }
}

