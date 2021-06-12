package sale.application.service.restriction;

import sale.business.model.SaleItem;
import sale.business.service.IRestriction;

import java.util.List;

public class SaleItemQuantityRestriction  implements IRestriction {
    private final int maxQuantity = 25;

    public boolean canSell(List<SaleItem> saleItemList) {
        return saleItemList.size() <= maxQuantity;
    }
}
