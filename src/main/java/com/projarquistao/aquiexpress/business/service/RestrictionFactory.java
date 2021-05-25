package com.projarquistao.aquiexpress.business.service;

import com.projarquistao.aquiexpress.application.service.restriction.NoRestriction;
import com.projarquistao.aquiexpress.application.service.restriction.ProductQuantityRestriction;
import com.projarquistao.aquiexpress.application.service.restriction.SaleItemQuantityRestriction;
import com.projarquistao.aquiexpress.application.service.restriction.SaleValueRestriction;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class RestrictionFactory {
    public IRestriction getInstance() {
        var now = LocalDateTime.now();

        if (now.getHour() >= 5 && now.getHour() <= 7) {
            return new ProductQuantityRestriction();
        } else if (now.getHour() >= 8 && now.getHour() <= 12) {
            return new SaleItemQuantityRestriction();
        } else if (now.getHour() > 15) {
            return new SaleValueRestriction();
        }
        return new NoRestriction();
    }
}
