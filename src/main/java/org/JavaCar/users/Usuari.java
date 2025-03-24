package org.JavaCar.users;
import org.JavaCar.vehicles.Vehicle;
import java.util.ArrayList;

public abstract class Usuari {
    protected String username;
    protected String password;
    protected boolean admin;
    private ArrayList<Vehicle> vehiclesEnPropietat;

    public Usuari(String username, String password) {
        this.username = username;
        this.password = password;
        this.vehiclesEnPropietat = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getAdmin() {
        return admin;
    }

    public ArrayList<Vehicle> getVehiclesEnPropietat() {
        return vehiclesEnPropietat;
    }

    public void setVehiclesEnPropietat(ArrayList<Vehicle> vehiclesEnPropietat) {
        this.vehiclesEnPropietat = vehiclesEnPropietat;
    }

    public boolean mostrarVehiclesEnPropietat() {
        if (vehiclesEnPropietat.isEmpty()) {
            System.out.println("Encara no tens vehicles en propietat");
            return false;
        }else {
            int contador = 1;
            for (Vehicle vehicle : vehiclesEnPropietat) {
                System.out.println("[" + contador + "] " + vehicle.getMarca() + " " + vehicle.getModel() + " " + vehicle.getMatricula());
                contador++;
            }
            return true;
        }
    }

    public void afegirVehicle(Vehicle vehicle){
        this.vehiclesEnPropietat.add(vehicle);
    }

    public void eliminarVehicle(int index) {
        vehiclesEnPropietat.remove(index);
    }
}
