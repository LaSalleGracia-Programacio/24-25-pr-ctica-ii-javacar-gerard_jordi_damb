package org.JavaCar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import org.JavaCar.users.*;
import org.JavaCar.vehicles.*;

public class GestorUsuarisVehicles {
    private ArrayList<Usuari> usuaris;
    private ArrayList<Vehicle> vehicles;

    public GestorUsuarisVehicles() {
        usuaris = new ArrayList();
        vehicles = new ArrayList();
        inicialitzacioArrays();
    }

    public Usuari iniciarSesio() {
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

    public  void printarVehicles() {
        System.out.printf("%-15s %-15s %s%n", "MARCA", "MODEL", "PREU/DIA");
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%-15s %-15s %.2f €%n",
                    vehicle.getMarca(), vehicle.getModel(), vehicle.getPreuBase());
        }
    }

    private void inicialitzacioArrays() {
        vehicles.add(new Moto("5678DEF", "Yamaha", "R3", 25.00, 300, null, null));
        vehicles.add(new Moto("9101GHI", "Honda", "CBR600RR", 45.00, 600, null, null));
        vehicles.add(new Moto("1121JKL", "Zero", "SR/F", 60.00, 250, null, null));
        vehicles.add(new Moto("3141MNO", "Ducati", "Panigale V4", 120.00, 1000, null, null));
        vehicles.add(new Moto("4151PQR", "Kawasaki", "Ninja H2", 150.00, 500, null, null));


        usuaris.add(new Admin("admin", "admin"));
        usuaris.add(new Client("a", "a"));
    }

    private void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    private void afegirVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
}
