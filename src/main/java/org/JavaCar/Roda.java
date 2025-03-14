package org.JavaCar;

public class Roda {
    private String marca;
    private double diametro;

    public Roda(String marca, int diametro) {
        this.marca = marca;
        this.diametro = diametro;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
}
