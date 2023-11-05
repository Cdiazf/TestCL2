package pe.edu.cibertec.cibertec.service;

import pe.edu.cibertec.cibertec.repository.DataService;

public class CalculatorServiceImpl implements CalculatorService {
    private DataService dataService;

    public CalculatorServiceImpl(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public double calculateAverage() {
        int[] numbers = dataService.getListOfNumbers();
        if (numbers.length == 0) {
            return 0.0; // Evitar división por cero
        }

        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }

        return (double) sum / numbers.length;
    }
}

