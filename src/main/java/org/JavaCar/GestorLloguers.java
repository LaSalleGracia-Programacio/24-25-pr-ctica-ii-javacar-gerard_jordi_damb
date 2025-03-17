package org.JavaCar;

import java.util.List;

public class GestorLloguers {
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double total = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            total += vehicles.get(i).calcularPreu(dies);
        }
        return total;
    }
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> v, double preuMax) {
        List<Vehicle> r = v;
        return r;
    }
}
