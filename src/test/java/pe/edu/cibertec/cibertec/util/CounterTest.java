package pe.edu.cibertec.cibertec.util;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CounterTest {

//    Desarrolle el ejercicio solicitado a continuación aplicando Test driven development
//    Se desea crear una clase que funcione como un contador. Se cuenta con los siguientes requisitos
//- [ ] Al crear el contador indicamos el valor inicial del mismo, el incremento y e! valor limite.
//- [ ] El valor inicial y el incremento tomaran un valor de 0 y 1 respectivamente si no se indica nada. El limite es necesario indicarlo siempre.
//- [ ] Ninguno de los tres valores (valor inicial, incremento y limite) pueden cambiarse una vez creado el contador
//- [ ] Al incrementar el contador se suma al valor actual el incremento y nos indican si se supero el limite.
//- [ ] Cuando se supere el limite, el valor actual del contador vuelve a ser el valor inicial.
//- [ ] En cualquier momento sé puede conocer el valor actual del contador y
//- [ ] E cualquier momento se puede establecer el contador 2 su valor inicial.
//    Implemente los requisitos anteriores utilizando TDD.

    @Test
    public void testInitialCounterValue() {
        // Prueba que el valor inicial del contador sea 0 por defecto.
        Counter counter = new Counter(10);  // Limite de 10
        assertEquals(0, counter.getValue());
    }

    @Test
    public void testIncrementCounter() {
        // Prueba que el contador se incremente correctamente.
        Counter counter = new Counter(10);
        counter.increment();
        assertEquals(1, counter.getValue());
    }

    @Test
    public void testIncrementCounterWithLimit() {
        // Prueba que el contador se restablezca al valor inicial después de alcanzar el límite.
        Counter counter = new Counter(5);  // Limite de 5
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment();
        counter.increment(); // Llega al límite
        assertEquals(0, counter.getValue()); // Debe volver a 0
    }

    @Test
    public void testSetCounterToInitialValue() {
        // Prueba que se pueda establecer el contador a su valor inicial en cualquier momento.
        Counter counter = new Counter(10);
        counter.increment();
        counter.setInitialValue();
        assertEquals(0, counter.getValue());
    }
}
