package com.example.demo.service;

import org.springframework.stereotype.Service;
import com.example.demo.model.StockPriceResponse;

@Service
public class StockPriceService {
    
    public StockPriceResponse getStockPrice(String company) {
        // TODO: Implement actual stock price logic here
        if (company == null || company.trim().isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be empty");
        }
        
        StockPriceResponse response = new StockPriceResponse();
        response.setCompany(company);
        response.setPrice(150.0); // Dummy price for now
        return response;
    }
}