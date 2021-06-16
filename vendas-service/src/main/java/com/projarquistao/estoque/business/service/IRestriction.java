package com.projarquistao.estoque.business.service;

import com.projarquistao.estoque.business.model.SaleItem;

import java.util.List;

public interface IRestriction {
    boolean canSell(List<SaleItem> items);
}
