package pe.edu.cibertec.cibertec.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import pe.edu.cibertec.cibertec.repository.DataService;

public class CalculatorServiceImplTest {


// En el ejemplo a realizar se crearán dos interfaces CalculatorService y DataService,con los siguientes propósitos:
//   DataService : Contendrá el método int[] getListOfNumbers();
//        que devolverá una lista de números de una fuente de datos.
//   CalculatorService : Contendrá el método double calculateAverage();
//        que calculará el promedio de la lista de números devuelta por el servicio DataService.
//   Además se creará un test unitario que ayudará a probar el CalculatorService.

    @Mock
    DataService dataService;

    @InjectMocks
    CalculatorServiceImpl calculatorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCalculateAverage() {
        // Configurar el servicio de datos simulado utilizando Mockito
        Mockito.when(dataService.getListOfNumbers()).thenReturn(new int[]{1, 2, 3, 4, 5});

        // Crear una instancia de CalculatorServiceImpl con el servicio de datos simulado
        CalculatorService calculatorService = new CalculatorServiceImpl(dataService);

        // Calcular el promedio y verificar si es correcto
        double average = calculatorService.calculateAverage();
        assertEquals(3.0, average, 0.001); // Utilizamos delta para comparaciones de números decimales
    }
}
