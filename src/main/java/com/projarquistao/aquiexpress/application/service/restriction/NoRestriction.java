package com.projarquistao.aquiexpress.application.service.restriction;

import com.projarquistao.aquiexpress.business.model.SaleItem;
import com.projarquistao.aquiexpress.business.service.IRestriction;

import java.util.List;

public class NoRestriction implements IRestriction {

    public boolean canSell(List<SaleItem> saleItemList) {
        return true;
    }
}
