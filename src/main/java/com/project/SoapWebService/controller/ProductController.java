package com.project.SoapWebService.controller;

import com.project.SoapWebService.dto.ProdResponseDTO;
import com.project.SoapWebService.dto.ProductRequest;
import com.project.SoapWebService.dto.ProductResponse;
import com.project.SoapWebService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }
    @PostMapping("/create")
    public ResponseEntity<ProdResponseDTO> addProduct(@RequestBody ProductRequest product) {
         return ResponseEntity.ok(productService.saveProduct(product));
    }


}
