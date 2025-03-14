package org.JavaCar;

import java.util.ArrayList;

public class Cotxe extends Vehicle {
    private double capacitatCarga;

    public Cotxe(String matricula, String marca, String model, double preuBase, Motor motor, ArrayList<Roda> rodes, double capacitatCarga) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
    }
}
