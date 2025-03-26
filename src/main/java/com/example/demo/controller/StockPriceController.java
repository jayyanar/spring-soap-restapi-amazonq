package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.StockPriceResponse;
import com.example.demo.service.StockPriceService;

@RestController
@RequestMapping("/api/stocks")
public class StockPriceController {

    private final StockPriceService stockPriceService;

    @Autowired
    public StockPriceController(StockPriceService stockPriceService) {
        this.stockPriceService = stockPriceService;
    }

    @GetMapping("/price")
    public ResponseEntity<StockPriceResponse> getStockPrice(@RequestParam String company) {
        StockPriceResponse response = stockPriceService.getStockPrice(company);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleIllegalArgumentException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return ResponseEntity.internalServerError().body("An unexpected error occurred");
    }
}