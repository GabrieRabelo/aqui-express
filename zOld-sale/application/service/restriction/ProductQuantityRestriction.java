package sale.application.service.restriction;

import sale.business.model.SaleItem;
import sale.business.service.IRestriction;

import java.util.List;

public class ProductQuantityRestriction implements IRestriction {
    private final int maxProductQuantity = 100;

    public boolean canSell(List<SaleItem> saleItemList) {
        return saleItemList
                .stream()
                .noneMatch(saleItem -> saleItem.getQuantity() > maxProductQuantity);
    }
}
