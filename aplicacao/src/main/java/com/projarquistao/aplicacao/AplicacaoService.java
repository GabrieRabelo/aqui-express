package com.projarquistao.aplicacao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AplicacaoService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public boolean registrarVenda(List<SaleItem> saleItems){
        var obj = new ObjectMapper();
        var jsonStr = "";
        try {
            // Converting the Java object into a JSON string
            jsonStr = obj.writeValueAsString(saleItems);
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
}
