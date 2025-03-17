package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.nombrePlaces = nombrePlaces;
    }

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes,
                 Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, combustible, euro);
        this.nombrePlaces = nombrePlaces;
    }

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia, Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia,combustible, euro);
        this.nombrePlaces = nombrePlaces;
    }

    public Cotxe(String matricula, String marca, String model, double preuBase, int nombrePlaces, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia);
        this.nombrePlaces = nombrePlaces;
    }

    public int getNombrePlaces() {
        return nombrePlaces;
    }
}
