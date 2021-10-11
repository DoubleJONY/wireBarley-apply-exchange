package com.example.api.entity.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ExchangeResponse {

    private String country;
    private double remittanceAmount;
    private double convertedAmount;

}
