package com.projarquistao.aplicacao.adapter.controller;


import com.projarquistao.aplicacao.application.AplicacaoService;
import com.projarquistao.aplicacao.application.dtos.ProductDTO;
import com.projarquistao.aplicacao.application.dtos.SaleItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/vendas-fila")
public class AplicacaoController {

    private AplicacaoService aplicacaoService;

    @Autowired
    public AplicacaoController(AplicacaoService aplicacaoService) {
        this.aplicacaoService = aplicacaoService;
    }

    @PostMapping("/confirmacao")
    public boolean confirmaVenda(@RequestBody final List<SaleItemDTO> itens) {
        return aplicacaoService.registrarVenda(itens);
    }

    @PostMapping("/estoque/adicionar")
    public boolean adicionarEstoque(@RequestBody final List<ProductDTO> products) {
        return aplicacaoService.adicionaEstoque(products);
    }

}
