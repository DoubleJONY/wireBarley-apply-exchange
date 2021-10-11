package com.example.api.controller;

import com.example.api.entity.response.ExchangeResponse;
import com.example.api.services.ExchangeService;
import com.google.gson.JsonObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exchange")
public class ExchangeController {

    private ExchangeService exchangeService;

    public ExchangeController(ExchangeService exchangeService) {

        this.exchangeService = exchangeService;
    }

    @GetMapping("/list")
    public ResponseEntity<JsonObject> getQuotes() {

        JsonObject response = exchangeService.getQuotes();

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping
    public ResponseEntity<ExchangeResponse> getCurrencyAmount(@RequestParam String country, double amount) {

        ExchangeResponse response = exchangeService.getCurrencyAmount(country, amount);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
