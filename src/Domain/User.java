package Domain;

import Application.Interfaces.IObserver;

public abstract class User {

    private String username;
    private String password;
    private String role;

    public User(String username, String password, String role){
        this.password = password;
        this.username = username;
        this.role = role;
    }

    public boolean verifyPassword(String isPassword){
        return this.password.equals(isPassword);
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

}
