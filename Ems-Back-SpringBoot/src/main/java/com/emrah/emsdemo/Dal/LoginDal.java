package com.emrah.emsdemo.Dal;

public class LoginDal {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDal(String email, String password) {
        this.email = email;
        this.password = password;
    }
    public LoginDal() {
    }
}
