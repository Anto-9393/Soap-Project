package com.project.SoapWebService.service.impl;

import com.project.SoapWebService.dto.ProdResponseDTO;
import com.project.SoapWebService.dto.ProductRequest;
import com.project.SoapWebService.dto.ProductResponse;
import com.project.SoapWebService.entity.ProductEntity;
import com.project.SoapWebService.enums.ProductResponseCode;
import com.project.SoapWebService.exception.ProductAlreadyExistsException;
import com.project.SoapWebService.repository.ProductRepo;
import com.project.SoapWebService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger log = LoggerFactory.getLogger(ProductServiceImpl.class);
    private final ProductRepo productRepo;

    @Override
    public List<ProductResponse> getAllProducts() {
        var productList = (List<ProductEntity>)productRepo.findAll();
        var productResponseList = productList.stream().
                map(this::convertToProduct)
                .collect(Collectors.toList());
        log.info("Fetched Data");
        return productResponseList;
    }

    @Override
    public ProdResponseDTO saveProduct(ProductRequest productRequest) {
        if (productRepo.existsByname(productRequest.getName())) {
            throw  new ProductAlreadyExistsException("Product Already Exist");
        }
        else {
            createNewProduct(productRequest);
            return new ProdResponseDTO(ProductResponseCode.PRODUCT_CREATED);
        }
    }

    @Override
    public ProductResponse increaseProduct(ProductRequest productRequest) throws  ProductAlreadyExistsException  {
        ProductEntity products = productRepo.findByname(productRequest.getName()).orElseThrow(() ->  new ProductAlreadyExistsException("Product not found"));
        if((products.getQuantity() + productRequest.getQuantity()) < 100){
            products.setQuantity(products.getQuantity() + productRequest.getQuantity());
            productRepo.save(products);

            return  convertToProduct(products);
        }
        else {
            throw new ProductAlreadyExistsException("Wrong Quantity");
        }
    }
    @Override
    public ProductResponse decreaseProduct(ProductRequest productRequest) throws  ProductAlreadyExistsException  {
        ProductEntity products = productRepo.findByname(productRequest.getName()).orElseThrow(() ->  new ProductAlreadyExistsException("Product not found"));
        if((products.getQuantity() - productRequest.getQuantity()) > 0){
            products.setQuantity(products.getQuantity() - productRequest.getQuantity());
            productRepo.save(products);
            return  convertToProduct(products);
        }
        else {
            throw new ProductAlreadyExistsException("Wrong Quantity");
        }
    }


    public void createNewProduct(ProductRequest productRequest) {
        var product = ProductEntity.builder()
                .name(productRequest.getName())
                .quantity(productRequest.getQuantity())
                .build();
         productRepo.save(product);
    }

    private ProductResponse convertToProduct(ProductEntity productEntity) {
        return ProductResponse.builder()
                .id(productEntity.getId())
                .name(productEntity.getName())
                .quantity(productEntity.getQuantity())
                .build();

    }

}
