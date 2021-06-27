package com.projarquistao.aplicacao.application;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.projarquistao.aplicacao.application.dtos.ProductDTO;
import com.projarquistao.aplicacao.application.dtos.SaleItemDTO;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AplicacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean registrarVenda(List<SaleItemDTO> saleItemDTOS){
        var obj = new ObjectMapper();
        var jsonStr = "";
        try {
            // Converting the Java object into a JSON string
            jsonStr = obj.writeValueAsString(saleItemDTOS);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Sending message: "+ jsonStr);
        rabbitTemplate.convertAndSend("vendas-exchange", "vendas.registrar", jsonStr);
        return true;
    }

    public boolean adicionaEstoque(List<ProductDTO> productDTOs){
        var obj = new ObjectMapper();
        var jsonStr = "";
        try {
            // Converting the Java object into a JSON string
            jsonStr = obj.writeValueAsString(productDTOs);
            // Displaying Java object into a JSON string
            System.out.println(jsonStr);
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        System.out.println("Sending message: "+ jsonStr);
        rabbitTemplate.convertAndSend("estoque-exchange", "estoque.adicionar", jsonStr);
        return true;
    }
}
