package org.JavaCar.vehicles;

public class Roda {
    private String marca;
    private double diametre;

    public Roda(String marca, int diametre) {
        this.marca = marca;
        this.diametre = diametre;
    }
    public String getMarca() {
        return marca;
    }
    public double getDiametre() {
        return diametre;
    }
}
