package com.projarquistao.aquiexpress;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendas")
public class SaleController {
    private final List<Product> produtos;
    private final List<String> vendasEfetuadas;

    public SaleController() {
        // Cria e carrega o estoque
        produtos = new ArrayList<>();
        produtos.add(new Product(10, "Geladeira", 2500.0f, 10));
        produtos.add(new Product(20, "Fogao", 1200.0f, 0));
        produtos.add(new Product(30, "Lava louça", 4300.0f, 7));
        produtos.add(new Product(40, "Lava roupa", 3350.0f, 11));
        produtos.add(new Product(50, "Aspirador de pó", 780.0f, 22));

        // Cria a lista de vendas efetuadas
        vendasEfetuadas = new ArrayList<>();
    }

    @GetMapping("/produtos")
    @CrossOrigin(origins = "*")
    public List<Product> listaProdutos() {
        return produtos;
    }

    @GetMapping("/autorizacao")
    @CrossOrigin(origins = "*")
    public boolean podeVender(@RequestParam final Integer codProd,
                              @RequestParam final Integer qtdade) {
        return produtos.stream().anyMatch(p -> p.getId() == codProd && p.getQuantity() >= qtdade);
    }

    @PostMapping("/confirmacao")
    @CrossOrigin(origins = "*")
    public boolean confirmaVenda(@RequestBody final SaleItem[] itens) {

        ArrayList<Product> listaProdutos = new ArrayList<>();
        ArrayList<Integer> listaQtdades = new ArrayList<>();

        for (SaleItem item : itens) {
            final Product produto =
                    produtos.stream().filter(p -> p.getId() == item.getId()).findAny().orElse(null);

            if (produto == null) {
                return false;
            }

            listaQtdades.add(item.getQuantity());
            listaProdutos.add(produto);
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < listaProdutos.size(); i++) {
            final Product produto = listaProdutos.get(i);
            final int qtdade = listaQtdades.get(i);
            produto.saidaDeProduto(qtdade);

            builder.append(produto.getId());
            builder.append(" ");
            builder.append(produto.getId());
            builder.append(" ");
            builder.append(qtdade);
            builder.append("\n");
        }

        vendasEfetuadas.add(builder.toString());
        return true;
    }

    @GetMapping("/historico")
    @CrossOrigin(origins = "*")
    public List<String> vendasEfetuadas() {
        return vendasEfetuadas;
    }

    @PostMapping("/subtotal")
    @CrossOrigin(origins = "*")
    public Integer[] calculaSubtotal(@RequestBody final SaleItem[] itens) {
        Integer subtotal = 0;
        Integer imposto = 0;

        for (final SaleItem it : itens) {
            // Procurar o produto pelo código
            final Product prod =
                    produtos.stream().filter(p -> p.getId() == it.getId()).findAny().orElse(null);

            if (prod != null) {
                subtotal += (int) (prod.getPrice() * it.getQuantity());
            } else {
                throw new IllegalArgumentException("Codigo invalido");
            }
        }
        imposto = (int) (subtotal * 0.1);
        final Integer[] resp = new Integer[3];
        resp[0] = subtotal;
        resp[1] = imposto;
        resp[2] = subtotal + imposto;
        return resp;
    }}