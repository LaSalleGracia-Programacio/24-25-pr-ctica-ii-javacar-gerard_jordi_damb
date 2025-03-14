package org.JavaCar;

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
    public void setTipus(String tipus) {
        this.tipus = tipus;
    }
    public int getPotencia() {
        return potencia;
    }
}
