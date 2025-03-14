package org.JavaCar;

import java.util.ArrayList;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes, double capacitatCarga) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
}
