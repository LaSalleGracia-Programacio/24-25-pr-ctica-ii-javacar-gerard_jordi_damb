package org.JavaCar;

public interface Llogable {
    public default double calcularPreu(int dies) {
        return dies*50;
    }
}
