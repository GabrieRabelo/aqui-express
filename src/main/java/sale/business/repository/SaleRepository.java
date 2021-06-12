package sale.business.repository;

import sale.business.model.Sale;

import java.util.List;

public interface SaleRepository {
    void save(Sale sale);
    List<Sale> findAll();
}
