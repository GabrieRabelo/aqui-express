package sale.application.service.restriction;

import sale.business.model.SaleItem;
import sale.business.service.IRestriction;

import java.util.List;

public class NoRestriction implements IRestriction {

    public boolean canSell(List<SaleItem> saleItemList) {
        return true;
    }
}
