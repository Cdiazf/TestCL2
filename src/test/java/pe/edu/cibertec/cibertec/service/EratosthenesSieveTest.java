package pe.edu.cibertec.cibertec.service;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EratosthenesSieveTest {

//    Desarrolle el ejercicio solicitado a continuación aplicando Test driven development
//    Desarrolle mediante TDD una implementacién del algoritmo de la Criba de Eratéstenes
//    para calcular la lista de los nuimeros primos desde 2 hasta un numero n indicado. Si no existiera
//    ningun primo, el algoritmo devolvera una lista vacia. El algoritmo de la criba de Eratdstenes se
//    muestra a continuacion.
//
//1. Se crea una lista con los numeros desde 2 hasta n.
//
//            2. Se elige el siguiente numero x no marcado (inicialmente el 2).
//            3. Se marcan todos los multiplos de dicho numero (x*2, x*3, etc.).
//            4. Se repite desde el paso 2.
//
//    Cuando se ha terminado con todos los numeros aquellos que queden sin marcar son
//    primos. Mas informacién sobre la criba de Eratdstenes en la Wikipedia:
//
//    http://en.wikipedia.org/wiki/Sieve_of Eratosthenes

    @Test
    public void testGeneratePrimesUpTo10() {
        PrimeNumberGenerator sieve = new EratosthenesSieve();
        List<Integer> primes = sieve.generatePrimes(10);
        List<Integer> expectedPrimes = new ArrayList<>(Arrays.asList(2, 3, 5, 7));
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testGeneratePrimesUpTo20() {
        PrimeNumberGenerator sieve = new EratosthenesSieve();
        List<Integer> primes = sieve.generatePrimes(20);
        List<Integer> expectedPrimes = new ArrayList<>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19));
        assertEquals(expectedPrimes, primes);
    }

    @Test
    public void testGeneratePrimesUpTo1() {
        PrimeNumberGenerator sieve = new EratosthenesSieve();
        List<Integer> primes = sieve.generatePrimes(1);
        List<Integer> expectedPrimes = new ArrayList<>();
        assertEquals(expectedPrimes, primes);
    }
}
