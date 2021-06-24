package com.projarquistao.vendas.application.service.restriction;

import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.service.IRestriction;

import java.util.List;

public class SaleItemQuantityRestriction  implements IRestriction {
    private final int maxQuantity = 25;

    public boolean canSell(List<SaleItem> saleItemList) {
        return saleItemList.size() <= maxQuantity;
    }
}
