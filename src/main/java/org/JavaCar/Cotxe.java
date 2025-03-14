package org.JavaCar;

import java.util.ArrayList;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, Motor motor, ArrayList<Roda> rodes, int nombrePlaces) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }
}
