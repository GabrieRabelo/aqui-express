package com.projarquistao.aquiexpress.application.service.tax;

import com.projarquistao.aquiexpress.business.service.ITaxCalculator;

public class TaxCalculatorNormal implements ITaxCalculator {

    @Override
    public double calculateIVATaxPercentage(int saleValue) {
        return 0.12;
    }
}
