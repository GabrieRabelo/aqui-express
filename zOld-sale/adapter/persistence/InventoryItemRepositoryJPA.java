package sale.adapter.persistence;

import sale.business.model.InventoryItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryItemRepositoryJPA extends JpaRepository<InventoryItem, Long> {
}
