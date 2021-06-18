package com.projarquistao.vendas.application.service.restriction;

import com.projarquistao.vendas.business.model.SaleItem;
import com.projarquistao.vendas.business.service.IRestriction;

import java.util.List;

public class NoRestriction implements IRestriction {

    public boolean canSell(List<SaleItem> saleItemList) {
        return true;
    }
}
