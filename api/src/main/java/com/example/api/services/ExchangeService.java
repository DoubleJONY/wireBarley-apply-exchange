package com.example.api.services;

import com.example.api.entity.response.ExchangeResponse;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExchangeService {

    public JsonObject getQuotes() {

        return pullCurrency();

    }
    public ExchangeResponse getCurrencyAmount(String country, double amount) {

        double currency = pullCurrency().get(country).getAsDouble();

        ExchangeResponse response = new ExchangeResponse(country, amount, currency * amount);

        return response;
    }

    private JsonObject pullCurrency() {

        String currencyUrl = "http://api.currencylayer.com/live?access_key=ef0338685a56a7ea58b3bbd86a5493a2";

        RestTemplate restTemplate = new RestTemplate();

        String result = restTemplate.getForObject(currencyUrl, String.class);

        return JsonParser.parseString(result).getAsJsonObject().getAsJsonObject("quotes");

    }

}
