package org.JavaCar;

import org.JavaCar.users.*;

import org.JavaCar.vehicles.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Usuari> usuaris = new ArrayList<>();
        ArrayList<Vehicle> vehiclesDisponibles = new ArrayList<>();
        vehiclesDisponibles.add(new Moto("5678DEF", "Yamaha", "R3", 25.00, 300, null, null));
        vehiclesDisponibles.add(new Moto("9101GHI", "Honda", "CBR600RR", 45.00, 600, null, null));
        vehiclesDisponibles.add(new Moto("1121JKL", "Zero", "SR/F", 60.00, 250, null, null));
        vehiclesDisponibles.add(new Moto("3141MNO", "Ducati", "Panigale V4", 120.00, 1000, null, null));
        vehiclesDisponibles.add(new Moto("4151PQR", "Kawasaki", "Ninja H2", 150.00, 500, null, null));

        usuaris.add(new Admin("admin", "admin"));
        usuaris.add(new Client("a", "a"));

        Usuari usuariActual = iniciarSesio(usuaris);

        if (usuariActual.isAdmin() == true) {
            System.out.println("\n\nHOLA ADMIN");
        }else {
            System.out.println("\n\nHOLA " + usuariActual.getUsername());
            System.out.println("Que vols fer?\n" +
                    "[1]Veure llistat de vehicles\n" +
                    "[2]Tramitar un lloguer\n" +
                    "[3]Calcul del lloguer");
            int opcio = sc.nextInt();
            switch (opcio) {
                case 1:
                    printarVehicles(vehiclesDisponibles);
            }
        }

    }

    public static void printarVehicles(ArrayList<Vehicle> vehiclesDisponibles) {
        System.out.printf("%-15s %-15s %s%n", "MARCA", "MODEL", "PREU/DIA");
        for (Vehicle vehicle : vehiclesDisponibles) {
            System.out.printf("%-15s %-15s %.2f €%n",
                    vehicle.getMarca(), vehicle.getModel(), vehicle.getPreuBase());
        }
    }

    public static Usuari iniciarSesio(ArrayList<Usuari> usuaris) {
        Scanner sc = new Scanner(System.in);
        boolean iniciat = false;
        Usuari usuariActual = null;

        while (!iniciat) {
            System.out.println("BENVINGUT A JAVACAR\n" +
                    "[1]Iniciar sesió\n" +
                    "[2]Registrar-se");
            int opcio = sc.nextInt();

            switch (opcio) {
                case 1:
                    System.out.print("Nom: ");
                    String nom = sc.next();
                    System.out.print("Contrasenya: ");
                    String contrasenya = sc.next();
                    for (int i = 0; i < usuaris.size(); i++) {
                        if (Objects.equals(usuaris.get(i).getUsername(), nom) && Objects.equals(usuaris.get(i).getPassword(), contrasenya)) {
                            iniciat = true;
                            usuariActual = usuaris.get(i);
                        }
                    }
                    if (!iniciat) {
                        System.out.println("Usuari i/o contrasenya incorrectes\n\n");
                    }
                    break;
                case 2:
                    System.out.print("Nom: ");
                    String nom2 = sc.next();
                    System.out.print("Contrasenya: ");
                    String contrasenya2 = sc.next();
                    usuaris.add(new Client(nom2, contrasenya2));
                    iniciat = true;
                    usuariActual = usuaris.get(usuaris.size() - 1);
            }
        }
        return usuariActual;
    }
}