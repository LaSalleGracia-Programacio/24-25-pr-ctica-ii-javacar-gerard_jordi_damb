package org.JavaCar;
import org.JavaCar.users.*;
import org.JavaCar.vehicles.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorUsuarisVehicles guv = new GestorUsuarisVehicles();
        Scanner sc = new Scanner(System.in);


        Usuari usuariActual = guv.iniciarSesio(guv.getUsuaris());

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
                    guv.printarVehicles();
                    break;
            }
        }
    }
}