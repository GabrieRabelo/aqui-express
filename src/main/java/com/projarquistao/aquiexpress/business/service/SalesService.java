package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.Product;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private final ProductService productService;

    @Autowired
    public SalesService(ProductService productService) {this.productService = productService;}

    public boolean confirmSale(SaleItem saleItem[]){
//        ArrayList<Product> listaProdutos = new ArrayList<>();
//        ArrayList<Integer> listaQtdades = new ArrayList<>();
//
//        for (SaleItem item : itens) {
//            final Product produto =
//                    produtos.stream().filter(p -> p.getId() == item.getId()).findAny().orElse(null);
//
//            if (produto == null) {
//                return false;
//            }
//
//            listaQtdades.add(item.getQuantity());
//            listaProdutos.add(produto);
//        }
//
//        StringBuilder builder = new StringBuilder();
//
//        for (int i = 0; i < listaProdutos.size(); i++) {
//            final Product produto = listaProdutos.get(i);
//            final int qtdade = listaQtdades.get(i);
////            produto.saidaDeProduto(qtdade);
//
//            builder.append(produto.getId());
//            builder.append(" ");
//            builder.append(produto.getId());
//            builder.append(" ");
//            builder.append(qtdade);
//            builder.append("\n");
//        }
//
//        vendasEfetuadas.add(builder.toString());
//        return true;
        return false;
    }
}
