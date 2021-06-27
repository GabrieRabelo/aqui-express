package com.projarquistao.aplicacao;


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
    public boolean confirmaVenda(@RequestBody final List<SaleItem> itens) {
        return aplicacaoService.registrarVenda(itens);
    }

}
