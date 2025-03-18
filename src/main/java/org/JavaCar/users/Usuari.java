package org.JavaCar.users;

public class Usuari {
    private String username;
    private String password;
    private boolean admin;

    public Usuari(String username, String password) {
        this.username = username;
        this.password = password;
        if (username.equals("admin")) {
            this.admin = true;
        }else {
            this.admin = false;
        }
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

    public boolean isAdmin() {
        return admin;
    }
}
