package com.project.SoapWebService.endpoint;

import com.example.soap_web_service.WriteRequest;
import com.example.soap_web_service.WriteResponse;
import com.project.soap_web_service.GetHelloRequest;
import com.project.soap_web_service.GetHelloResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Component
@RequiredArgsConstructor
public class HelloEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/soap-web-service";

    private KafkaTemplate<String, String> kafkaTemplate;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetHelloRequest")
    @ResponsePayload
    public GetHelloResponse getHello(@RequestPayload GetHelloRequest request) {
        GetHelloResponse response = new GetHelloResponse();
        String name = request.getName();
        String greeting = "Hello, " + name + "!";
        response.setGreeting(greeting);
       kafkaTemplate.send("my-topic", "Ciao" + name);
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "WriteRequest")
    @ResponsePayload
    public WriteResponse write(@RequestPayload WriteRequest request) {
        WriteResponse response = new WriteResponse();
        response.setStatus("Written " + request.getName() + " with value " + request.getValue());
        // Invio del messaggio a Kafka
        kafkaTemplate.send("my-topic", "Written " + request.getName() + " with value " + request.getValue());
        return response;
    }

}
