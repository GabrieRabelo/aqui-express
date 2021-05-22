package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.Product;
import com.projarquistao.aquiexpress.business.model.Sale;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.repository.InventoryItemRepository;
import com.projarquistao.aquiexpress.business.repository.ProductRepository;
import com.projarquistao.aquiexpress.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalesService {

    private final ProductRepository productRepository;
    private final SaleRepository saleRepository;
    private final InventoryItemRepository inventoryItemRepository;

    @Autowired
    public SalesService(ProductRepository productRepository, SaleRepository saleRepository, InventoryItemRepository inventoryItemRepository) {
        this.productRepository = productRepository;
        this.saleRepository = saleRepository;
        this.inventoryItemRepository = inventoryItemRepository;
    }

    public boolean confirmSale(SaleItem[] saleItems){

        List<SaleItem> saleItemList = new ArrayList<>();

        for (SaleItem saleItem : saleItems) {
            final var productOptional = productRepository.findById(saleItem.getProduct().getId());
            if (productOptional.isEmpty()) return false;

            saleItem.setCurrentPrice(productOptional.get().getPrice());
            saleItemList.add(saleItem);
        }

        for (SaleItem saleItem : saleItems) {
            final var inventoryItem = inventoryItemRepository.findById(saleItem.getProduct().getId());

            if (inventoryItem.isEmpty()) return false;
            inventoryItem.get().subtractQuantity(saleItem.getQuantity());
        }

        var sale = new Sale(saleItemList);
        saleRepository.save(sale);

        return true;
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public Integer[] calculateSubtotal(final SaleItem[] itens) {
        var subtotal = 0;
        var imposto = 0;

        for (final SaleItem item : itens) {

            final var prod = productRepository.findById(item.getId());

            if (prod.isPresent()) {
                subtotal += (int) (prod.get().getPrice() * item.getQuantity());
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
    }
}
