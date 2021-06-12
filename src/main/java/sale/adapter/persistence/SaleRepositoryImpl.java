package sale.adapter.persistence;

import sale.business.model.Sale;
import sale.business.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryImpl implements SaleRepository {

    private final SaleRepositoryJPA saleRepositoryJPA;

    @Autowired
    public SaleRepositoryImpl(SaleRepositoryJPA saleRepositoryJPA) {
        this.saleRepositoryJPA = saleRepositoryJPA;
    }

    @Override
    public void save(Sale sale) {
        saleRepositoryJPA.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepositoryJPA.findAll();
    }
}
