package com.projarquistao.estoque.application.service.restriction;

import com.projarquistao.estoque.business.model.SaleItem;
import com.projarquistao.estoque.business.service.IRestriction;

import java.util.List;

public class NoRestriction implements IRestriction {

    public boolean canSell(List<SaleItem> saleItemList) {
        return true;
    }
}
