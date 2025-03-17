package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes) {
        super(matricula, marca, model, preuBase, motor, rodes);
        this.cilindrada = cilindrada;
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, combustible, euro);
        this.cilindrada = cilindrada;
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia, Combustible combustible, int euro) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia,combustible, euro);
        this.cilindrada = cilindrada;
    }

    public Moto(String matricula, String marca, String model, double preuBase, int cilindrada, Motor motor, Roda[] rodes,
                 Tipo tipo, int autonomia) {
        super(matricula, marca, model, preuBase, motor, rodes, tipo, autonomia);
        this.cilindrada = cilindrada;
    }

    public int getCilindrada() {
        return cilindrada;
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
