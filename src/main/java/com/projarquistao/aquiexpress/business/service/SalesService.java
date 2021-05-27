package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.Sale;
import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.repository.ProductRepository;
import com.projarquistao.aquiexpress.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SaleRepository saleRepository;
    private final ITaxCalculator taxCalculator;
    private final RestrictionFactory restrictionFactory;
    private final ProductRepository productRepository;

    @Autowired
    public SalesService(SaleRepository saleRepository,
                        ITaxCalculator taxCalculator,
                        RestrictionFactory restrictionFactory,
                        ProductRepository productRepository) {
        this.saleRepository = saleRepository;
        this.taxCalculator = taxCalculator;
        this.restrictionFactory = restrictionFactory;
        this.productRepository = productRepository;
    }

    public boolean confirmSale(List<SaleItem> saleItems){

        var restrictionInstance = restrictionFactory.getInstance();

        if (!restrictionInstance.canSell(saleItems))
            return false;

        var sale = new Sale(saleItems);
        saleRepository.save(sale);

        return true;
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public int[] calculateSubtotal(final SaleItem[] itens) {
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
        imposto = (int) (subtotal * taxCalculator.calculateIVATaxPercentage(subtotal));

        return new int[] {subtotal, imposto, subtotal + imposto};
    }
}
