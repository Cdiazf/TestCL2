package pe.edu.cibertec.cibertec.service;

import pe.edu.cibertec.cibertec.util.DivisasEnum;

public class CurrencyConverter {
    private CurrencyConversionService conversionService;

    public CurrencyConverter(CurrencyConversionService conversionService) {
        this.conversionService = conversionService;
    }

    public double convertCurrency(DivisasEnum fromCurrency, DivisasEnum toCurrency, double amount) {
        if (fromCurrency == toCurrency) {
            return amount; // No se necesita conversión
        }

        double exchangeRate = conversionService.getExchangeRate(fromCurrency, toCurrency);
        if (exchangeRate == 0.0) {
            throw new IllegalArgumentException("Tipo de cambio no disponible");
        }

        return amount * exchangeRate;
    }
}

