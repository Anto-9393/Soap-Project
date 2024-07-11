//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2024.07.10 alle 04:36:24 PM CEST 
//


package com.example.soap_web_service;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.example.soap_web_service package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.example.soap_web_service
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddProductRequest }
     * 
     */
    public AddProductRequest createAddProductRequest() {
        return new AddProductRequest();
    }

    /**
     * Create an instance of {@link AddProductResponse }
     * 
     */
    public AddProductResponse createAddProductResponse() {
        return new AddProductResponse();
    }

    /**
     * Create an instance of {@link IncreaseQuantityRequest }
     * 
     */
    public IncreaseQuantityRequest createIncreaseQuantityRequest() {
        return new IncreaseQuantityRequest();
    }

    /**
     * Create an instance of {@link IncreaseQuantityResponse }
     * 
     */
    public IncreaseQuantityResponse createIncreaseQuantityResponse() {
        return new IncreaseQuantityResponse();
    }

    /**
     * Create an instance of {@link Product }
     * 
     */
    public Product createProduct() {
        return new Product();
    }

    /**
     * Create an instance of {@link DecreaseQuantityRequest }
     * 
     */
    public DecreaseQuantityRequest createDecreaseQuantityRequest() {
        return new DecreaseQuantityRequest();
    }

    /**
     * Create an instance of {@link DecreaseQuantityResponse }
     * 
     */
    public DecreaseQuantityResponse createDecreaseQuantityResponse() {
        return new DecreaseQuantityResponse();
    }

}
