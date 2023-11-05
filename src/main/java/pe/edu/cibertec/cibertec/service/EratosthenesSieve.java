package pe.edu.cibertec.cibertec.service;

import java.util.ArrayList;
import java.util.List;

public class EratosthenesSieve implements PrimeNumberGenerator {
    @Override
    public List<Integer> generatePrimes(int n) {
        if (n < 2) {
            return new ArrayList<>();
        }

        boolean[] isPrime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }

        return primes;
    }
}
