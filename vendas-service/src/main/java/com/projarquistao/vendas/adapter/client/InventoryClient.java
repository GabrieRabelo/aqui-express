package com.projarquistao.vendas.adapter.client;

import com.projarquistao.vendas.business.model.SaleItem;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@Component
public class InventoryClient {
    private final WebClient webClient;

    public InventoryClient() {
        this.webClient = WebClient.create("http://estoqueService:8080/");
    }

    public Boolean verifyProductAvailability(List<SaleItem> saleItems) {
        return webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("estoque/produtos/disponibilidade").build())
                .bodyValue(saleItems)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
