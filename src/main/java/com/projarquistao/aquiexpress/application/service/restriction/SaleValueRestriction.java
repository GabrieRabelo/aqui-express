package com.projarquistao.aquiexpress.application.service.restriction;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.IRestriction;

import java.util.List;

public class SaleValueRestriction  implements IRestriction {
    private final int maxPrice = 1000;

    public boolean canSell(List<SaleItem> saleItemList) {
        var sum =  saleItemList.stream()
            .mapToDouble(SaleItem::getCurrentPrice)
            .sum();

        return sum <= maxPrice;
    }
}
