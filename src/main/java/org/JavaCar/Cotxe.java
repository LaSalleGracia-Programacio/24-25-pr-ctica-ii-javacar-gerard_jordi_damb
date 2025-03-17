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

    public EtiquetaAmbiental calcularEtiqueta() {
        if (((this.tipo == Tipo.PHEV && autonomia < 40) || this.tipo == Tipo.HEV
                || this.tipo == Tipo.GNL || this.tipo == Tipo.GNC || this.tipo == Tipo.GLP)
                && (this.combustible == Combustible.Gasolina && (this.euro == 4 || this.euro == 5 || this.euro == 6)
                || (this.combustible == Combustible.Gasoil && this.euro == 6))) {
            return EtiquetaAmbiental.Eco;
        }
        else if (this.tipo == Tipo.BEV || this.tipo == Tipo.REEV
                || (this.tipo == Tipo.PHEV && autonomia > 40) || this.tipo == Tipo.Pila) {
            return EtiquetaAmbiental.ZeroEmissions;
        }
        else if ((this.combustible == Combustible.Gasolina && this.euro == 3) ||
                (this.combustible == Combustible.Gasoil && (this.euro == 4 || this.euro == 5)) ) {
            return EtiquetaAmbiental.B;
        }
        else if ((this.combustible == Combustible.Gasolina && (this.euro == 4 || this.euro == 5 || this.euro == 6))
                || (this.combustible == Combustible.Gasoil && this.euro == 6)) {
            return EtiquetaAmbiental.C;
        }
        else {
            return EtiquetaAmbiental.SenseEtiqueta;
        }
    }
}
