package org.JavaCar.vehicles;

public class Motor {
    private String tipus;
    private int potencia;

    public Motor(String tipo, int potencia) {
        this.tipus = tipo;
        this.potencia = potencia;
    }
    public String getTipus() {
        return tipus;
    }
    public int getPotencia() {
        return potencia;
    }
}
