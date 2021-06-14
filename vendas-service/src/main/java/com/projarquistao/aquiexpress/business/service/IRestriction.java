package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.business.model.SaleItem;

import java.util.List;

public interface IRestriction {
    boolean canSell(List<SaleItem> items);
}
