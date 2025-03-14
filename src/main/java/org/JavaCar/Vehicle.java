package org.JavaCar;

public abstract class Vehicle implements Llogable{
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaAmbiental etiquetaAmbiental;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public double getPreuBase() {
        return preuBase;
    }

    public Motor getMotor() {
        return motor;
    }

    public Roda[] getRodes() {
        return rodes;
    }

    public EtiquetaAmbiental getEtiquetaAmbiental() {
        return etiquetaAmbiental;
    }

    @Override
    public double calcularPreu(int dies) {
        return preuBase * dies;
    }

    /*
    * ETIQUETA AMBIENTAL
    *
    * B:
    * - MOTO      : <50cc
    * - COCHE     : +8 plazas
    * - FURGONETA :
    *
    * C:
    * - MOTO      :
    * - COCHE     :
    * - FURGONETA :
    * */
}
