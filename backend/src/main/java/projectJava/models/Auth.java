package projectJava.models;

import projectJava.auth.Login;

public class Auth {

    private String loggedUser = null;

    public boolean login(String user, String password) {

        Login login = new Login();

        boolean success = login.authenticate(user, password);

        if (success) {
            loggedUser = login.getUser();
        }

        return success;
    }

    public boolean logout() {

        if (loggedUser == null) {
            return false;
        }

        loggedUser = null;

        return true;
    }
}