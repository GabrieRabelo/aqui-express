package com.projarquistao.vendas.application.service.tax;

import com.projarquistao.vendas.business.service.ITaxCalculator;

public class TaxCalculatorNormal implements ITaxCalculator {

    @Override
    public double calculateIVATaxPercentage(int saleValue) {
        return 0.12;
    }
}
