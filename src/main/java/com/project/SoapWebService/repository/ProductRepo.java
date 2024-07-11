package com.project.SoapWebService.repository;

import com.project.SoapWebService.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
    Optional<ProductEntity> findByname(String name);
//    ProdResponseDTO save(Product product);

    boolean existsByname(String name);


}
