package org.JavaCar.users;

public class Client extends Usuari{

    public Client(String username, String password) {
        super(username, password);
        this.admin = false;
    }
}
