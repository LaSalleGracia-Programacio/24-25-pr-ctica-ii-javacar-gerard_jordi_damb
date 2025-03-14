package org.JavaCar;

public interface Llogable {
    default double calcularPrecio(int dias) {
        return dias * 50;
    }
}
