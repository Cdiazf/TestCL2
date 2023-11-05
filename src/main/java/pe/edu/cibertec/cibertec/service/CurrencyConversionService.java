package pe.edu.cibertec.cibertec.service;

import pe.edu.cibertec.cibertec.util.DivisasEnum;

public interface CurrencyConversionService {
    double getExchangeRate(DivisasEnum fromCurrency, DivisasEnum toCurrency);
}

