package org.JavaCar;

import java.util.ArrayList;

public abstract class Vehicle {
    private String matricula;
    private String marca;
    private String model;
    private double preuBase;
    private Motor motor;
    private ArrayList<Roda> rodes;
    private EtiquetaAmbiental etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, ArrayList<Roda> rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;

    }
}
