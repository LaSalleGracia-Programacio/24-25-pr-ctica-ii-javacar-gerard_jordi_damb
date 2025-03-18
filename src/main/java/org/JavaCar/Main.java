package org.JavaCar;

import org.JavaCar.users.Usuari;
import org.JavaCar.vehicles.Vehicle;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        ArrayList<Vehicle> vehiclesDisponibles = new ArrayList<>();
        usuaris.add(new Usuari("admin", "admin"));
        usuaris.add(new Usuari("a", "a"));

        Usuari usuariActual = iniciarSesio(usuaris);

        if (usuariActual.isAdmin() == true) {
            System.out.println("HOLA ADMIN");
        }else {
            System.out.println("HOLA " + usuariActual.getUsername());
        }

    }

    public static Usuari iniciarSesio(ArrayList<Usuari> usuaris) {
        Scanner sc = new Scanner(System.in);
        boolean iniciat = false;
        Usuari usuariActual = null;

        while (!iniciat) {
            System.out.println("BENVINGUT A JAVACAR\n" +
                    "Iniciar sesió[1]\n" +
                    "Registrar-se[2]");
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
                    usuaris.add(new Usuari(nom2, contrasenya2));
                    iniciat = true;
                    usuariActual = usuaris.get(usuaris.size() - 1);
            }
        }
        return usuariActual;
    }
}