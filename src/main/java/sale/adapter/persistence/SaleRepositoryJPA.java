package sale.adapter.persistence;

import sale.business.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepositoryJPA extends JpaRepository<Sale, Long> {

}
