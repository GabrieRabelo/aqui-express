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
    private WebClient webClient;

    public InventoryClient() {
        this.webClient = WebClient.create("http://localhost:8082/");
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

    //    private HttpClient httpClient;
//
//    public InventoryClient() {
//        this.httpClient = HttpClient.newHttpClient();
//    }
//
//    public boolean isProductsAvailable(List<SaleItem> saleItems) {

//        HttpRequest.BodyPublisher bodyPublisher = new HttpRequest.BodyPublisher()
//
//        HttpRequest request = HttpRequest
//                .newBuilder()
//                .POST()
//                .uri(URI.create("http://localhost:8080/matematica/soma?valores=10,20,5,22,10"))
//                .build();
//
//        HttpResponse<String> response = null;
//        return true;
//    }
}
