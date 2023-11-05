package pe.edu.cibertec.cibertec.util;

public class Counter {
    private int value;
    private int initialValue;
    private int increment;
    private int limit;

    public Counter(int limit) {
        this.value = 0;
        this.initialValue = 0;
        this.increment = 1;
        this.limit = limit;
    }

    public int getValue() {
        return value;
    }

    public void increment() {
        value += increment;
        if (value >= limit) {
            value = initialValue;
        }
    }

    public void setInitialValue() {
        value = initialValue;
    }
}

