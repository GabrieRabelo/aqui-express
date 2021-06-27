package com.projarquistao.estoque.adapter.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.projarquistao.estoque.application.use_case.AddInventoryItemsUC;
import com.projarquistao.estoque.business.dto.ProductDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Receiver {

    private AddInventoryItemsUC addInventoryItemsUC;

    public Receiver(AddInventoryItemsUC addInventoryItemsUC) {
        this.addInventoryItemsUC = addInventoryItemsUC;
    }

    public void receiveMessage(String message) throws JsonProcessingException {
        var obj = new ObjectMapper();
        var list = obj.readValue(message, new TypeReference<List<ProductDTO>>() {});
        System.out.println("Received <" + message + ">");
        addInventoryItemsUC.addInventoryItems(list);
    }
}
