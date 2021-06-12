package sale.application.service.tax;

import sale.business.service.ITaxCalculator;

public class TaxCalculatorNormal implements ITaxCalculator {

    @Override
    public double calculateIVATaxPercentage(int saleValue) {
        return 0.12;
    }
}
