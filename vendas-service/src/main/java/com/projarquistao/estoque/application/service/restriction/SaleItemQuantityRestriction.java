package com.projarquistao.estoque.application.service.restriction;

import com.projarquistao.estoque.business.model.SaleItem;
import com.projarquistao.estoque.business.service.IRestriction;

import java.util.List;

public class SaleItemQuantityRestriction  implements IRestriction {
    private final int maxQuantity = 25;

    public boolean canSell(List<SaleItem> saleItemList) {
        return saleItemList.size() <= maxQuantity;
    }
}
