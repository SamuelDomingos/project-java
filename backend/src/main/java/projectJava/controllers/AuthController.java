package projectJava.controllers;

import projectJava.auth.Login;

public class AuthController {

    private String errorMessage;

    public boolean login(
            String user,
            String password) {

        Login login = new Login();

        boolean authenticated = login.authenticate(
                user,
                password);

        if (!authenticated) {

            errorMessage = login.getErrorMessage();
        }

        return authenticated;
    }

    public boolean logout() {

        return true;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}