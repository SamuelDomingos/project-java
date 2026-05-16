package projectJava.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseInit {

    public static void init() {

        String createTableSql = "CREATE TABLE IF NOT EXISTS tb_users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "login VARCHAR(100) NOT NULL UNIQUE, " +
                "password VARCHAR(255) NOT NULL, " +
                "active TINYINT NOT NULL" +
                ");";

        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {

            stmt.execute(createTableSql);

            System.out.println("Tabela tb_users pronta");

            String checkUserSql = "SELECT id FROM tb_users WHERE login = ?";

            try (
                    PreparedStatement checkStmt = conn.prepareStatement(checkUserSql)) {

                checkStmt.setString(1, "savir");

                ResultSet rs = checkStmt.executeQuery();

                boolean userExists = rs.next();

                if (!userExists) {

                    String insertUserSql = "INSERT INTO tb_users " +
                            "(name, login, password, active) " +
                            "VALUES (?, ?, ?, ?)";

                    try (
                            PreparedStatement insertStmt = conn.prepareStatement(insertUserSql)) {

                        insertStmt.setString(1, "Administrador");
                        insertStmt.setString(2, "savir");
                        insertStmt.setString(3, "1234");
                        insertStmt.setInt(4, 1);

                        insertStmt.executeUpdate();

                        System.out.println(
                                "Usuário padrão criado com sucesso");
                    }
                } else {

                    System.out.println(
                            "Usuário padrão já existe");
                }
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}