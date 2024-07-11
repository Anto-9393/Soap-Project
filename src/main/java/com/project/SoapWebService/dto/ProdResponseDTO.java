package com.project.SoapWebService.dto;

import com.project.SoapWebService.enums.ProductResponseCode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class ProdResponseDTO {
    private ProductResponseCode productResponseCode;
}
