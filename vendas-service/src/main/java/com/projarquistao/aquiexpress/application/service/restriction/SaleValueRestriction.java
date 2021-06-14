package com.projarquistao.aquiexpress.application.service.restriction;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.IRestriction;
import org.springframework.stereotype.Component;

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
