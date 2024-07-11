package com.project.SoapWebService.endpoint;

import com.example.soap_web_service.*;
import com.project.SoapWebService.dto.ProdResponseDTO;
import com.project.SoapWebService.dto.ProductRequest;
import com.project.SoapWebService.dto.ProductResponse;
import com.project.SoapWebService.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap-web-service";

    private KafkaTemplate<String, String> kafkaTemplate;

    private final ProductService productService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "AddProductRequest")
    @ResponsePayload
    AddProductResponse addProduct(@RequestPayload AddProductRequest addProductRequest) {
        ProductRequest request = new ProductRequest();
        request.setName(addProductRequest.getName());
        request.setQuantity(addProductRequest.getQuantity());

        ProdResponseDTO respDTO = productService.saveProduct(request);

        AddProductResponse response = new AddProductResponse();
        response.setResponseCode(ProductResponseCode.valueOf(respDTO.getProductResponseCode().toString()));
        return response;
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "IncreaseQuantityRequest")
    @ResponsePayload
    IncreaseQuantityResponse increaseQuantity(@RequestPayload IncreaseQuantityRequest quantityRequest) {
        ProductRequest request = new ProductRequest();
        request.setName(quantityRequest.getName());
        request.setQuantity(quantityRequest.getQuantity());

        ProductResponse respDTO = productService.increaseProduct(request);

        Product product = new Product();
        product.setId(respDTO.getId());
        product.setName(respDTO.getName());
        product.setQuantity(respDTO.getQuantity());


        IncreaseQuantityResponse response = new IncreaseQuantityResponse();
        response.setProduct(product);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "DecreaseQuantityRequest")
    @ResponsePayload
    DecreaseQuantityResponse decreaseQuantity(@RequestPayload DecreaseQuantityRequest quantityRequest) {
        ProductRequest request = new ProductRequest();
        request.setName(quantityRequest.getName());
        request.setQuantity(quantityRequest.getQuantity());

        ProductResponse respDTO = productService.decreaseProduct(request);

        Product product = new Product();
        product.setId(respDTO.getId());
        product.setName(respDTO.getName());
        product.setQuantity(respDTO.getQuantity());


        DecreaseQuantityResponse response = new DecreaseQuantityResponse();
        response.setProduct(product);
        return response;


    }

}
