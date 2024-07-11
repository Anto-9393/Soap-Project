package com.project.SoapWebService.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }


//    @Bean(name = "helloService")
//    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
//        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
//        definition.setPortTypeName("HelloPortType");
//        definition.setLocationUri("/ws");
//        definition.setTargetNamespace("http://example.com/soap-web-service");
//        definition.setSchema(schema);
//        return definition;
//    }

    @Bean(name = "produService")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema schema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setPortTypeName("ProductPortType");
        definition.setLocationUri("/ws");
        definition.setTargetNamespace("http://example.com/soap-web-service");
        definition.setSchema(schema);
        return definition;
    }

    @Bean
    public XsdSchema schema() {
        return new SimpleXsdSchema(new ClassPathResource("product.xsd"));
    }
}
