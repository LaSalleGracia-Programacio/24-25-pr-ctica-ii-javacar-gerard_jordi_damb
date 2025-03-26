package org.JavaCar.vehicles;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta(String matricula, String marca, String model, double preuBase, double capacitatCarga, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.capacitatCarga = capacitatCarga;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes,
                     Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, combustible, euro);
        this.capacitatCarga = capacitatCarga;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes,
                     Tipo tipo, int autonomia, Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia,combustible, euro);
        this.capacitatCarga = capacitatCarga;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Furgoneta(String matricula, String marca, String model, double preuBase, int capacitatCarga, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia);
        this.capacitatCarga = capacitatCarga;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    public EtiquetaAmbiental calcularEtiqueta() {
        if (((this.tipo == Tipo.PHEV && autonomia < 40) || this.tipo == Tipo.HEV
                || this.tipo == Tipo.GNL || this.tipo == Tipo.GNC || this.tipo == Tipo.GLP)
                && this.euro == 6) {
            return EtiquetaAmbiental.Eco;
        }
        else if (this.tipo == Tipo.BEV || this.tipo == Tipo.REEV
                || (this.tipo == Tipo.PHEV && autonomia > 40) || this.tipo == Tipo.Pila) {
            return EtiquetaAmbiental.ZeroEmissions;
        }
        else if (this.euro == 4 || this.euro == 5) {
            return EtiquetaAmbiental.B;
        }
        else if (this.euro == 6) {
            return EtiquetaAmbiental.C;
        }
        else {
            return EtiquetaAmbiental.SenseEtiqueta;
        }
    }

    public void setCapacitatCarga(double capacitatCarga) {
        this.capacitatCarga = capacitatCarga;
    }

    @Override
    public double calcularPreu(int dies) {
        if (this.getCapacitatCarga() > 1000) {
            return (this.getPreuBase() + 10) * dies;
        } else {
            return this.getPreuBase() * dies;
        }
    }
}
