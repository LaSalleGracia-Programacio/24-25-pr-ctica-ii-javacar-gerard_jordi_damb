package org.JavaCar;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import org.JavaCar.users.*;
import org.JavaCar.vehicles.*;

public class GestorUsuarisVehicles {
    private ArrayList<Usuari> usuaris;
    private ArrayList<Vehicle> vehiclesDisponibles;
    private ArrayList<Vehicle> vehiclesOcupats;

    public GestorUsuarisVehicles() {
        usuaris = new ArrayList();
        vehiclesDisponibles = new ArrayList();
        vehiclesOcupats = new ArrayList();
        inicialitzacioArrays();
    }

    public void cancelarLloguer(Usuari usuariActual){
        if (usuariActual.mostrarVehiclesEnPropietat()){
            Scanner sc = new Scanner(System.in);
            System.out.println("Introdueix el id del lloguer que vols cancelar:");
            int id = sc.nextInt();
            usuariActual.eliminarVehicle(id-1);
            System.out.println("el vehicle s'ha eliminat correctamente");
        }
    }

    public void calculVehicleDies(){
        Scanner sc = new Scanner(System.in);
        System.out.println("id del vehicle que vols calcular:");
        int id = sc.nextInt();
        if (id <= usuaris.size() + 1 && id > 0) {
            System.out.println("Quants de dies el voldries disposar?");
            int dies = sc.nextInt();
            System.out.println(vehiclesDisponibles.get(id - 1).calcularPreu(dies) + "€");
        }else {
            System.out.println("No existeix aquesta id");
        }
    }

    public void tramitarLloguer(int id, int dies, Usuari usuariActual){
        if (vehiclesDisponibles.get(id-1) != null) {
            Vehicle tramitant = vehiclesDisponibles.get(id - 1);
            System.out.println("Estas a punt de alquilar el/la " + tramitant.getMarca() +
                    " " + tramitant.getModel() + " per " + tramitant.calcularPreu(dies) + "€ durant " + dies + " dies");
            System.out.println("estas segur?[Y/N]");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                vehiclesDisponibles.remove(tramitant);
                vehiclesOcupats.add(tramitant);
                usuariActual.afegirVehicle(tramitant);
            }
        }
    }

    public Usuari iniciarSesio() {
        Scanner sc = new Scanner(System.in);
        boolean iniciat = false;
        Usuari usuariActual = null;

        while (!iniciat) {
            System.out.println("BENVINGUT A JAVACAR\n" +
                    "[1]Iniciar sesió\n" +
                    "[2]Registrar-se\n" +
                    "[3]Sortir");
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
                    break;
                case 3:
                    iniciat = true;
                    usuariActual = null;
            }
        }
        return usuariActual;
    }

    public  void printarVehicles() {
        System.out.printf("%-3s %-15s %-15s %s%n","ID", "MARCA", "MODEL", "PREU/DIA");
        int contador = 1;
        for (Vehicle vehicle : vehiclesDisponibles) {
            System.out.printf("[%-1s] %-15s %-15s %.2f €%n",
                    contador, vehicle.getMarca(), vehicle.getModel(), vehicle.getPreuBase());
            contador++;
        }
    }

    private void inicialitzacioArrays() {
        vehiclesDisponibles.add(new Moto("5678DEF", "Yamaha", "R3", 25.00, 300, null, null));
        vehiclesDisponibles.add(new Moto("9101GHI", "Honda", "CBR600RR", 45.00, 600, null, null));
        vehiclesDisponibles.add(new Moto("1121JKL", "Zero", "SR/F", 60.00, 250, null, null));
        vehiclesDisponibles.add(new Moto("3141MNO", "Ducati", "Panigale V4", 120.00, 1000, null, null));
        vehiclesDisponibles.add(new Moto("4151PQR", "Kawasaki", "Ninja H2", 150.00, 500, null, null));


        usuaris.add(new Admin("admin", "admin"));
        usuaris.add(new Client("a", "a"));
        usuaris.add(new Client("user", "user"));
    }

    private void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    private void afegirVehicleDisponible(Vehicle vehicle) {
        vehiclesDisponibles.add(vehicle);
    }

    public ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public ArrayList<Vehicle> getVehiclesDisponibles() {
        return vehiclesDisponibles;
    }
}
