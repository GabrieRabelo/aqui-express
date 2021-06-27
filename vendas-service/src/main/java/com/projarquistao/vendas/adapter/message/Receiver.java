package com.projarquistao.vendas.adapter.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projarquistao.vendas.application.use_case.ConfirmSaleUC;
import com.projarquistao.vendas.business.model.SaleItem;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Receiver {

    private final ConfirmSaleUC confirmSaleUC;

    public Receiver(ConfirmSaleUC confirmSaleUC) {
        this.confirmSaleUC = confirmSaleUC;
    }

    public void receiveMessage(String message) throws JsonProcessingException {
        var obj = new ObjectMapper();
        var list = obj.readValue(message, new TypeReference<List<SaleItem>>(){});
        System.out.println("Received <" + message + ">");
        confirmSaleUC.confirmSale(list);
    }
}