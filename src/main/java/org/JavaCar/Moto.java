package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, combustible, euro);
        this.cilindrada = cilindrada;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia, Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia,combustible, euro);
        this.cilindrada = cilindrada;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia);
        this.cilindrada = cilindrada;
        this.etiquetaAmbiental = calcularEtiqueta();
    }

    public int getCilindrada() {
        return cilindrada;
    }

    public EtiquetaAmbiental calcularEtiqueta() {
        if ((this.tipo == Tipo.PHEV || this.tipo == Tipo.HEV) && this.autonomia < 40) {
            return EtiquetaAmbiental.Eco;
        }
        else if (this.tipo == Tipo.BEV || this.tipo == Tipo.REEV
                || (this.tipo == Tipo.PHEV && autonomia > 40) || this.tipo == Tipo.Pila) {
            return EtiquetaAmbiental.ZeroEmissions;
        }
        else if (this.euro == 2) {
            return EtiquetaAmbiental.B;
        }
        else if (this.euro == 3 || this.euro == 4) {
            return EtiquetaAmbiental.C;
        }
        else {
            return EtiquetaAmbiental.SenseEtiqueta;
        }
    }


    @Override
    public double calcularPreu(int dies) {
        if (this.getCilindrada() > 500) {
            return (this.getPreuBase() + 5) * dies ;
        }else{
            return this.getPreuBase() * dies ;
        }
    }
}
