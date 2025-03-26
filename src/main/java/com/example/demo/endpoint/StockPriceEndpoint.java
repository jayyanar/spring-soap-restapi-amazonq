package com.example.demo.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.demo.model.StockPriceRequest;
import com.example.demo.model.StockPriceResponse;

@Endpoint
public class StockPriceEndpoint {

    private static final String NAMESPACE_URI = "http://example.com/stock";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "StockPriceRequest")
    @ResponsePayload
    public StockPriceResponse getStockPrice(@RequestPayload StockPriceRequest request) {
        StockPriceResponse response = new StockPriceResponse();
        response.setCompany(request.getCompany());
        response.setPrice(150.0); // Dummy price
        return response;
    }
}
