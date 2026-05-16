package projectJava.db;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInit {

    public static void init() {

        String sql = "CREATE TABLE IF NOT EXISTS tb_users (" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(100) NOT NULL, " +
                "login VARCHAR(100) NOT NULL UNIQUE, " +
                "password VARCHAR(255) NOT NULL, " +
                "active TINYINT NOT NULL" +
                ");";

        try (
                Connection conn = ConnectionFactory.getConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela tb_users pronta");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}