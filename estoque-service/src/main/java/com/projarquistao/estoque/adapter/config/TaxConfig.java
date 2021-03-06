package com.projarquistao.estoque.adapter.config;

import com.projarquistao.estoque.application.service.tax.TaxCalculatorNormal;
import com.projarquistao.estoque.application.service.tax.TaxCalculatorValueBased;
import com.projarquistao.estoque.business.service.ITaxCalculator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaxConfig {

    private final Double valueLimit;

    public TaxConfig(@Value("${tax.value.limit:8000}") Double valueLimit) {
        this.valueLimit = valueLimit;
    }

    @Bean
    @ConditionalOnProperty(name = "tax.calculation", havingValue = "normal", matchIfMissing = true)
    public ITaxCalculator opcaoRegraClassica() {
        return new TaxCalculatorNormal();
    }

    @Bean
    @ConditionalOnProperty(name = "tax.calculation", havingValue = "valueBased")
    public ITaxCalculator opcaoDesconsidera() {
        return new TaxCalculatorValueBased(valueLimit);
    }
}
