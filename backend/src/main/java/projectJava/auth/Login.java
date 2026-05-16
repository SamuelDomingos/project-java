package projectJava.auth;

import projectJava.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Login {

    private boolean authenticated = false;

    private String user;

    private String errorMessage;

    public boolean authenticate(
            String login,
            String password) {

        if (login == null
                || login.trim().isEmpty()
                || password == null
                || password.trim().isEmpty()) {

            errorMessage = "Campos obrigatórios";

            return false;
        }

        String sql = "SELECT login, password, active " +
                "FROM tb_users " +
                "WHERE login = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();

                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login);

            ResultSet rs = stmt.executeQuery();

            if (!rs.next()) {

                errorMessage = "Usuário não encontrado";

                authenticated = false;

                return false;
            }

            String dbPassword = rs.getString("password");

            int active = rs.getInt("active");

            if (active == 0) {

                errorMessage = "Usuário inativo";

                authenticated = false;

                return false;
            }

            if (!dbPassword.equals(password)) {

                errorMessage = "Senha incorreta";

                authenticated = false;

                return false;
            }

            authenticated = true;

            user = rs.getString("login");

            errorMessage = null;

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            authenticated = false;

            errorMessage = "Erro interno do servidor";

            return false;
        }
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public String getUser() {
        return user;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}