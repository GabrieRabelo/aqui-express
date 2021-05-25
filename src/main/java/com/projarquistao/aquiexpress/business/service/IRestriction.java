package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.SaleItem;

import java.util.List;

public interface IRestriction {
    public boolean canSell(List<SaleItem> items);
}
