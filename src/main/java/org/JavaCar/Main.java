package org.JavaCar;
import org.JavaCar.users.*;
import org.JavaCar.vehicles.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorUsuarisVehicles guv = new GestorUsuarisVehicles();
        Scanner sc = new Scanner(System.in);

        Usuari usuariActual = guv.iniciarSesio();

        boolean continuar = true;
        while(continuar) {
            if (usuariActual.isAdmin() == true) {
                System.out.println("\n\nHOLA ADMIN");
            } else {
                System.out.println("\n\nHOLA " + usuariActual.getUsername());
                System.out.println("Que vols fer?\n" +
                        "[1]Veure llistat de vehicles\n" +
                        "[2]Calcul de lloguer\n" +
                        "[3]Tramitar un lloguer\n" +
                        "[4]Veure vehicles en propietat\n" +
                        "[5]Cancelar alquiler\n" +
                        "[6]Sortir");
                int opcio = sc.nextInt();
                switch (opcio) {
                    case 1:
                        guv.printarVehicles();
                        break;
                    case 2:
                        System.out.println("id del vehicle que vols calcular:");
                        int id = sc.nextInt();
                        System.out.println("quants de dies el voldries disposar?");
                        int dies = sc.nextInt();
                        guv.calculVehicleDies(id, dies);
                        break;
                    case 3:
                        System.out.println("id del vehicle a llogar:");
                        id = sc.nextInt();
                        System.out.println("Quants dies vols disposar del vehicle?");
                        dies = sc.nextInt();
                        guv.tramitarLloguer(id, dies, usuariActual);
                        break;
                    case 4:
                        usuariActual.mostrarVehiclesEnPropietat();
                        break;
                    case 5:
                        guv.cancelarLloguer(usuariActual);
                        break;
                    case 6:
                        continuar = false;
                        break;
                }
            }
        }
    }
}