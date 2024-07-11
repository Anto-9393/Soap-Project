//
// Questo file è stato generato dall'Eclipse Implementation of JAXB, v3.0.2 
// Vedere https://eclipse-ee4j.github.io/jaxb-ri 
// Qualsiasi modifica a questo file andrà persa durante la ricompilazione dello schema di origine. 
// Generato il: 2024.07.10 alle 04:36:24 PM CEST 
//


package com.example.soap_web_service;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java per anonymous complex type.
 * 
 * <p>Il seguente frammento di schema specifica il contenuto previsto contenuto in questa classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="responseCode" type="{http://example.com/soap-web-service}ProductResponseCode"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "responseCode"
})
@XmlRootElement(name = "AddProductResponse")
public class AddProductResponse {

    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ProductResponseCode responseCode;

    /**
     * Recupera il valore della proprietà responseCode.
     * 
     * @return
     *     possible object is
     *     {@link ProductResponseCode }
     *     
     */
    public ProductResponseCode getResponseCode() {
        return responseCode;
    }

    /**
     * Imposta il valore della proprietà responseCode.
     * 
     * @param value
     *     allowed object is
     *     {@link ProductResponseCode }
     *     
     */
    public void setResponseCode(ProductResponseCode value) {
        this.responseCode = value;
    }

}
