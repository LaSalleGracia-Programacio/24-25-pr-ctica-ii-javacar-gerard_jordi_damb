package org.JavaCar;
import org.JavaCar.users.*;

import java.util.Scanner;

import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        GestorUsuarisVehicles guv = new GestorUsuarisVehicles();
        Scanner sc = new Scanner(System.in);

        boolean seguir = true;
        while(seguir) {
            Usuari usuariActual = guv.iniciarSesio();

            boolean continuar = true;
            while (continuar) {
                int opcio = 0;
                if (usuariActual == null) {
                    seguir = false;
                    continuar = false;
                }else if (usuariActual.getAdmin()) {
                    System.out.println("\n\nHOLA ADMIN");
                    System.out.println("Que vols fer?\n" +
                            "[1]Veure llistat de vehicles\n" +
                            "[2]Calcul de lloguer\n" +
                            "[3]Afegir vehicle\n" +
                            "[4]Editar vehicle\n" +
                            "[5]Eliminar vehicle\n" +
                            "[6]Logout");
                    try {
                        opcio = sc.nextInt();
                    } catch (Exception e) {
                        sc.next();
                    }
                    switch (opcio) {
                        case 1:
                            guv.printarVehicles();
                            enterPerContinuar();
                            break;
                        case 2:
                            guv.calculVehicleDies();
                            enterPerContinuar();
                            break;
                        case 3:
                            guv.nouVehicle();
                            enterPerContinuar();
                            break;
                        case 4:
                            guv.editarVehicle();
                            enterPerContinuar();
                            break;
                        case 5:
                            guv.eliminarVehicle();
                            enterPerContinuar();
                            break;
                        case 6:
                            continuar = false;
                            break;
                        default:
                            System.err.println("Opcio invalida");
                            sleep(100);
                            break;
                    }
                } else {
                    System.out.println("\n\nHOLA " + usuariActual.getUsername());
                    System.out.println("Que vols fer?\n" +
                            "[1]Veure llistat de vehicles\n" +
                            "[2]Calcul de lloguer\n" +
                            "[3]Tramitar un lloguer\n" +
                            "[4]Veure vehicles en propietat\n" +
                            "[5]Cancelar alquiler\n" +
                            "[6]Logout");
                    try {
                        opcio = sc.nextInt();
                    } catch (Exception e) {
                        sc.next();
                    }
                    switch (opcio) {
                        case 1:
                            guv.printarVehicles();
                            enterPerContinuar();
                            break;
                        case 2:
                            guv.calculVehicleDies();
                            enterPerContinuar();
                            break;
                        case 3:
                            guv.tramitarLloguer(usuariActual);
                            enterPerContinuar();
                            break;
                        case 4:
                            usuariActual.mostrarVehiclesEnPropietat();
                            enterPerContinuar();
                            break;
                        case 5:
                            guv.cancelarLloguer(usuariActual);
                            enterPerContinuar();
                            break;
                        case 6:
                            continuar = false;
                            break;
                        default:
                            System.err.println("Opcio invalida");
                            sleep(100);
                            break;
                    }
                }
            }
        }
    }

    public static void enterPerContinuar() {
        Scanner sc = new Scanner(System.in);
        System.out.println ("**********************************\n" +
                            "        ENTER PER CONTINUAR\n" +
                            "**********************************");
        sc.nextLine();
    }
}