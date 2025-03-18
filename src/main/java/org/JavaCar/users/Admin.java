package org.JavaCar.users;

public class Admin extends Usuari{

    public Admin(String username, String password) {
        super(username, password);
        this.admin = true;
    }
}
