package pe.edu.cibertec.cibertec.service;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import pe.edu.cibertec.cibertec.util.DivisasEnum;

public class CurrencyConverterTest {

//    Desarrollar el ´código suficiente para implementar esta funcionalidad y sus correspondientes casos de pruebas  con Junit y Mockito (sólo utilizar Mockito si fuera necesario )
//    Vamos a crear un programa que dependiendo del tipo de cambio transforme un tipo de divisa a su equivalente en dólares.
//    En el problema vamos a simular que existe un servicio que nos devuelve el tipo de cambio de dólares con la divisa que queramos probar en tiempo real.
//    Supongamos que el método para obtener el tipo de cambio es un servicio de terceros al que tenemos que conectarnos para obtener la información, no tenemos
//    control sobre su disponibilidad y sobre la información que regresa.
//    Así que es perfecto para utilizarlo como aplicación para el uso de la Librería Mockito. Por fines prácticos solo vamos a declararlo, pero no implementarlo.


    @Mock
    CurrencyConversionService conversionService;

    CurrencyConverter converter;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        converter = new CurrencyConverter(conversionService);
    }

    @Test
    public void testConvertSameCurrency() {
        when(conversionService.getExchangeRate(DivisasEnum.MXN, DivisasEnum.MXN)).thenReturn(1.0);
        double result = converter.convertCurrency(DivisasEnum.MXN, DivisasEnum.MXN, 100.0);
        assertEquals(100.0, result, 0.001);
    }

    @Test
    public void testConvertCurrencyWithExchangeRate() {
        when(conversionService.getExchangeRate(DivisasEnum.MXN, DivisasEnum.CAD)).thenReturn(0.75);
        double result = converter.convertCurrency(DivisasEnum.MXN, DivisasEnum.CAD, 100.0);
        assertEquals(75.0, result, 0.001);
    }

    @Test
    public void testConvertCurrencyExchangeRateNotAvailable() {
        when(conversionService.getExchangeRate(DivisasEnum.MXN, DivisasEnum.EURO)).thenReturn(0.0);
        assertThrows(IllegalArgumentException.class, () -> {
            converter.convertCurrency(DivisasEnum.MXN, DivisasEnum.EURO, 100.0);
        });
    }
}
