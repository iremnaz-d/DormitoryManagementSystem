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

    public boolean isLegalUsername(){ //5-20 char
        return this.username.length() >= 5 && this.username.length() < 20;
    }

    public boolean isLegalPassword(){ //en az 1 uppercase, 7-20 char, en az 1 digit
        String s = this.password;
        if(s.length() < 7 || s.length() > 20) return false;
        int upperCtr = 0, digitCtr = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if((int) c >= 48 && (int) c <58) //c digit ise
                digitCtr++;
            else if((int) c >= 65 && (int) c < 90) //c upperCase ise
                upperCtr++;
        }
        return !(upperCtr == 0 || digitCtr == 0);
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
