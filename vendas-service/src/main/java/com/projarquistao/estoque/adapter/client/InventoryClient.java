package com.projarquistao.estoque.adapter.client;

import com.projarquistao.estoque.business.model.SaleItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class InventoryClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(InventoryClient.class);

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

    public Boolean withdrawInventory(List<SaleItem> saleItems) {
        return webClient
                .post()
                .uri(uriBuilder -> uriBuilder.path("estoque/baixa").build())
                .bodyValue(saleItems)
                .retrieve()
                .bodyToMono(Boolean.class)
                .block();
    }
}
