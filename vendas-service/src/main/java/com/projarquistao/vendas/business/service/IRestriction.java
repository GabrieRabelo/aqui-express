package com.projarquistao.vendas.business.service;

import com.projarquistao.vendas.business.model.SaleItem;

import java.util.List;

public interface IRestriction {
    boolean canSell(List<SaleItem> items);
}
