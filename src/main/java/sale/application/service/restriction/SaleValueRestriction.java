package sale.application.service.restriction;

import sale.business.model.SaleItem;
import sale.business.service.IRestriction;

import java.util.List;

public class SaleValueRestriction  implements IRestriction {
    private final int maxPrice = 1000;

    public boolean canSell(List<SaleItem> saleItemList) {
        var sum =  saleItemList.stream()
            .mapToDouble(it -> it.getCurrentPrice() * it.getQuantity())
            .sum();

        return sum <= maxPrice;
    }
}
