package org.test.utils;

public class User {
    private String login;
    private String password;
    private String fullName;

    public User(String uName, String uLogin, String uPassword){
        login = uLogin;
        password = uPassword;
        fullName = uName;
    }

    public User(String uLogin, String uPassword){
        login = uLogin;
        password = uPassword;
    }

    public String getFullName() {
        return fullName;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
