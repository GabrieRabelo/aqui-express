package sale.business.service;

import sale.business.model.SaleItem;

import java.util.List;

public interface IRestriction {
    boolean canSell(List<SaleItem> items);
}
