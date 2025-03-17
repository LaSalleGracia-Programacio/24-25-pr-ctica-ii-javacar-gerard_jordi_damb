package org.JavaCar;

public abstract class Vehicle implements Llogable{
    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected EtiquetaAmbiental etiquetaAmbiental;
    protected Tipo tipo;
    protected Combustible combustible;
    protected int euro;
    protected int autonomia;

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
    }

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes,
                   Combustible combustible, int euro) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.combustible = combustible;
        this.euro = euro;
    }

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes,
                   Tipo tipo, int autonomia, Combustible combustible, int euro) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.tipo = tipo;
        this.autonomia = autonomia;
        this.combustible = combustible;
        this.euro = euro;
    }

    public Vehicle(String matricula, String marca, String model, double preuBase, Motor motor, Roda[] rodes,
                   Tipo tipo, int autonomia) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.preuBase = preuBase;
        this.motor = motor;
        this.rodes = rodes;
        this.tipo = tipo;
        this.autonomia = autonomia;
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
