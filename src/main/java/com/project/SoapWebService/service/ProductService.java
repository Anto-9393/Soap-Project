package com.project.SoapWebService.service;

import com.project.SoapWebService.dto.ProdResponseDTO;
import com.project.SoapWebService.dto.ProductRequest;
import com.project.SoapWebService.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    List<ProductResponse> getAllProducts();
    ProdResponseDTO saveProduct(ProductRequest productRequest);
    ProductResponse increaseProduct(ProductRequest productRequest);
    ProductResponse decreaseProduct(ProductRequest productRequest);

}
