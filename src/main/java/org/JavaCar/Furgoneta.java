package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (this.getCapacitatCarga() > 1000) {
            return (this.getPreuBase() + 10) * dies ;
        }else{
            return this.getPreuBase() * dies ;
        }
    }
}
