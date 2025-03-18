package org.JavaCar;

import org.JavaCar.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {
    public static double calcularIngressosTotals(List<Vehicle> vehicles, int dies) {
        double total = 0;
        for (int i = 0; i < vehicles.size(); i++) {
            total += vehicles.get(i).calcularPreu(dies);
        }
        return total;
    }
    public static List<Vehicle> filtrarPerPreu(List<Vehicle> llista, double preuMax) {
        List<Vehicle> filtrats = new ArrayList<Vehicle>();
        for (int i = 0; i < llista.size(); i++) {
            if (llista.get(i).getPreuBase() <= preuMax) {
                filtrats.add(llista.get(i));
            }
        }
        return filtrats;
    }
}
