package projectJava.auth;

import io.github.cdimascio.dotenv.Dotenv;

public class Login {

    private static final Dotenv dotenv = Dotenv.load();

    private boolean authenticated = false;
    private String user;

    public boolean authenticate(String login, String password) {

        String envUser = dotenv.get("USER");
        String envPass = dotenv.get("PASS");

        if (login == null || login.isEmpty()
                || password == null || password.isEmpty()) {
            return false;
        }

        if (envUser == null || envPass == null) {
            return false;
        }

        if (login.equals(envUser) && password.equals(envPass)) {
            authenticated = true;
            user = login;
            return true;
        }

        authenticated = false;
        return false;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUser() {
        return user;
    }
}