package sale.business.service;

import sale.business.model.Sale;
import sale.business.model.SaleItem;
import sale.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    private final SaleRepository saleRepository;
    private final RestrictionFactory restrictionFactory;

    @Autowired
    public SalesService(SaleRepository saleRepository,
                        RestrictionFactory restrictionFactory) {
        this.saleRepository = saleRepository;
        this.restrictionFactory = restrictionFactory;
    }

    public void finishSale(List<SaleItem> saleItems) {

        var sale = new Sale(saleItems);
        saleRepository.save(sale);

    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public boolean canSell(List<SaleItem> saleItems) {

        var restrictionInstance = restrictionFactory.getInstance();

        return restrictionInstance.canSell(saleItems);

    }

}
