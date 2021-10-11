package com.example.api.services;

import com.example.api.entity.response.ExchangeResponse;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(PowerMockRunner.class)
@SpringBootTest
public class ExchangeServiceTest {

    @Autowired
    ExchangeService exchangeService;

    @Test
    public void testPullCurrency() throws Exception {

        JsonObject response = Whitebox.invokeMethod(exchangeService, "pullCurrency");

        Assertions.assertEquals(1, response.get("USDUSD").getAsDouble());
    }

    @Test
    public void testConvertCurrencyAmount() {

        double amount = 2.0;

        ExchangeResponse response = exchangeService.getCurrencyAmount("USDUSD", amount);

        Assertions.assertEquals(2.0, response.getConvertedAmount());
    }
}
