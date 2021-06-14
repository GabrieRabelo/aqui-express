package com.projarquistao.estoque.application.service.tax;

import com.projarquistao.estoque.business.service.ITaxCalculator;

public class TaxCalculatorNormal implements ITaxCalculator {

    @Override
    public double calculateIVATaxPercentage(int saleValue) {
        return 0.12;
    }
}
