package com.projarquistao.aquiexpress.application.service;


import com.projarquistao.aquiexpress.business.service.ITaxCalculator;

public class TaxCalculatorValueBased implements ITaxCalculator {

    private final Double valueLimit;

    public TaxCalculatorValueBased(Double valueLimit) {
        this.valueLimit = valueLimit;
    }

    @Override
    public double calculateIVATaxPercentage(int saleValue) {
        if(saleValue > valueLimit)
            return 0.2;
        else return 0.15;
    }
}
