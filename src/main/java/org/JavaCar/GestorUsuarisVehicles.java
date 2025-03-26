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
        printarVehicles();
        Scanner sc = new Scanner(System.in);
        System.out.println("id del vehicle que vols calcular:");
        int id = sc.nextInt();
        if (existeixID(id)) {
            System.out.println("Quants de dies el voldries disposar?");
            int dies = sc.nextInt();
            System.out.println(vehiclesDisponibles.get(id - 1).calcularPreu(dies) + "€");
        }else {
            System.out.println("No existeix aquesta id");
        }
    }

    public void tramitarLloguer(Usuari usuariActual){
        printarVehicles();
        Scanner sc = new Scanner(System.in);
        System.out.println("id del vehicle a llogar:");
        int id = sc.nextInt();
        if (existeixID(id)) {
            System.out.println("Quants dies vols disposar del vehicle?");
            int dies = sc.nextInt();
            sc.nextLine();
            Vehicle tramitant = vehiclesDisponibles.get(id - 1);
            System.out.println("Estas a punt de alquilar el/la " + tramitant.getMarca() +
                    " " + tramitant.getModel() + " per " + tramitant.calcularPreu(dies) + "€ durant " + dies + " dies");
            System.out.println("estas segur?[Y/N]");
            String s = sc.nextLine();
            if (s.equalsIgnoreCase("y")) {
                vehiclesDisponibles.remove(tramitant);
                vehiclesOcupats.add(tramitant);
                usuariActual.afegirVehicle(tramitant);
            }
        }else {
            System.out.println("No existeix aquesta id");
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

    public void afegirUsuari(Usuari usuari) {
        usuaris.add(usuari);
    }

    public void afegirVehicleDisponible(Vehicle vehicle) {
        vehiclesDisponibles.add(vehicle);
    }

    public ArrayList<Usuari> getUsuaris() {
        return usuaris;
    }

    public ArrayList<Vehicle> getVehiclesDisponibles() {
        return vehiclesDisponibles;
    }

    public void nouVehicle() { // FUNCION PARA AÑADIR VEHICULO (CREAR MENU DE CREACION DE VEHICULOS)
        Scanner sc = new Scanner(System.in);
        Vehicle nouVehicle = null;

        String matricula = null, marca = null, modelo = null;
        double preuBase = 0, capacitatCarga = 0;
        int nombrePlaces = 0, cilindrada = 0;

        int op = 0;

        System.out.println("Seleccionar tipus de vehicle");
        System.out.println("[1] Cotxe");
        System.out.println("[2] Furgoneta");
        System.out.println("[3] Moto");
        System.out.println("[4] Cancelar");
        op = sc.nextInt();

        if (op >= 1 && op <= 3) { // DEMANAR VALORS DE VEHICLES
            do {
                System.out.print("Inserti matricula: ");
                try {
                    matricula = sc.next();
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
            } while (matricula == null);
            do {
                System.out.print("Inserti marca: ");
                try {
                    marca = sc.next();
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
            } while (marca == null);
            do {
                System.out.print("Inserti modelo: ");
                try {
                    modelo = sc.next();
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
            } while (modelo == null);
            do {
                System.out.print("Inserti preu base: ");
                try {
                    preuBase = sc.nextFloat();
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
            } while (preuBase == 0);
            do {
                System.out.print("Inserti nombre places: ");
                try {
                    nombrePlaces = sc.nextInt();
                } catch (Exception e) {
                    System.err.println("ERROR: " + e.getMessage());
                }
            } while (nombrePlaces == 0);
        }

        switch (op) {
            case 1:
                // CREAR Y AFEGIR COTXE A LLISTA DE VEHICLES DISPONIBLES
                Cotxe nouCotxe = new Cotxe(matricula, marca, modelo, preuBase, nombrePlaces, null, null);
                afegirVehicleDisponible(nouCotxe);
                break;
            case 2:
                // CREAR Y AFEGIR MOTO A LLISTA DE VEHICLES DISPONIBLES
                Moto novaMoto = new Moto(matricula, marca, modelo, preuBase, nombrePlaces, null, null);
                afegirVehicleDisponible(novaMoto);
                break;
            case 3:
                // CREAR Y AFEGIR FURGONETA A LLISTA DE VEHICLES DISPONIBLES
                Furgoneta novaFurgoneta = new Furgoneta(matricula, marca, modelo, preuBase, nombrePlaces, null, null);
                afegirVehicleDisponible(novaFurgoneta);
                break;
            case 4:
                break;
            default:
                System.out.println("Opció invàlida");
                break;
        }
    }

    public void editarVehicle() {
        printarVehicles();
        System.out.println("ID del vehicle a editar");
        Scanner sc = new Scanner(System.in);
        int id = sc.nextInt();
        if (existeixID(id)) {
            Vehicle editarem = vehiclesDisponibles.get(id - 1);
            if (editarem.getClass() == Cotxe.class) {
                System.out.println("[1] Matricula:        " + editarem.getMatricula() + "\n" +
                        "[2] Marca:            " + editarem.getMarca() + "\n" +
                        "[3] Model:            " + editarem.getModel() + "\n" +
                        "[4] Numero de places: " + ((Cotxe) editarem).getNombrePlaces() + "\n" +
                        "[5] Preu Base:        " + editarem.getPreuBase());
                System.out.println("QUE VOLS EDITAR?");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        editarMatricula(editarem);
                        break;
                    case 2:
                        editarMarca(editarem);
                        break;
                    case 3:
                        editarModel(editarem);
                        break;
                    case 4:
                        System.out.println("introdueix nou numero de places:");
                        int places = sc.nextInt();
                        ((Cotxe) editarem).setNombrePlaces(places);
                        System.out.println("Numero de places modificat correctament a '" + places + "'");
                        break;
                    case 5:
                        editarPreuBase(editarem);
                        break;
                    default:
                        System.out.println("Opcio invalida, sortint del mode edicio");
                        break;
                }
            } else if (editarem.getClass() == Moto.class) {
                System.out.println("[1] Matricula:        " + editarem.getMatricula() + "\n" +
                        "[2] Marca:            " + editarem.getMarca() + "\n" +
                        "[3] Model:            " + editarem.getModel() + "\n" +
                        "[4] Cilindrada:       " + ((Moto) editarem).getCilindrada() + "\n" +
                        "[5] Preu Base:        " + editarem.getPreuBase());
                System.out.println("QUE VOLS EDITAR?");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        editarMatricula(editarem);
                        break;
                    case 2:
                        editarMarca(editarem);
                        break;
                    case 3:
                        editarModel(editarem);
                        break;
                    case 4:
                        System.out.println("introdueix la nova cilindrada:");
                        int cilindrada = sc.nextInt();
                        ((Moto) editarem).setCilindrada(cilindrada);
                        System.out.println("Cilindrada modificada correctament a '" + cilindrada + "'");
                        break;
                    case 5:
                        editarPreuBase(editarem);
                        break;
                    default:
                        System.out.println("Opcio invalida, sortint del mode edicio");
                        break;
                }
            } else {
                System.out.println("[1] Matricula:        " + editarem.getMatricula() + "\n" +
                        "[2] Marca:            " + editarem.getMarca() + "\n" +
                        "[3] Model:            " + editarem.getModel() + "\n" +
                        "[4] Capacitat carga:  " + ((Furgoneta) editarem).getCapacitatCarga() + "\n" +
                        "[5] Preu Base:        " + editarem.getPreuBase());
                System.out.println("QUE VOLS EDITAR?");
                int option = sc.nextInt();
                switch (option) {
                    case 1:
                        editarMatricula(editarem);
                        break;
                    case 2:
                        editarMarca(editarem);
                        break;
                    case 3:
                        editarModel(editarem);
                        break;
                    case 4:
                        System.out.println("introdueix la nova capacitat de carga:");
                        double carga = sc.nextDouble();
                        ((Furgoneta) editarem).setCapacitatCarga(carga);
                        System.out.println("Cilindrada modificada correctament a '" + carga + "'");
                        break;
                    case 5:
                        editarPreuBase(editarem);
                        break;
                    default:
                        System.out.println("Opcio invalida, sortint del mode edicio");
                        break;
                }

            }
        }else {
            System.out.println("No existeix aquesta id");
        }
    }

    private void editarMatricula(Vehicle editarem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introdueix nova matricula:");
        String matricula = sc.next();
        editarem.setMatricula(matricula);
        System.out.println("Matricula modificada correctament a '" + matricula + "'");
    }

    private void editarMarca(Vehicle editarem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introdueix nova marca:");
        String marca = sc.next();
        editarem.setMarca(marca);
        System.out.println("Marca modificada correctament a '" + marca + "'");
    }

    private void editarModel(Vehicle editarem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introdueix nou model:");
        String model = sc.next();
        editarem.setModel(model);
        System.out.println("Model modificat correctament a '" + model + "'");
    }

    private void editarPreuBase(Vehicle editarem) {
        Scanner sc = new Scanner(System.in);
        System.out.println("introdueix nou preu base:");
        double preuBase = sc.nextFloat();
        editarem.setPreuBase(preuBase);
        System.out.println("Preu base modificat correctament a '" + preuBase + "'");
    }

    private boolean existeixID(int id) {
        if (id <= vehiclesDisponibles.size() && id > 0) {
            return true;
        } else {
            return false;
        }
    }
}
