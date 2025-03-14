package org.JavaCar;

import java.util.ArrayList;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, Motor motor, ArrayList<Roda> rodes, int cilindrada) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }
}
