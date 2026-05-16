package projectJava.users;

import projectJava.db.ConnectionFactory;
import projectJava.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserInsert {

    public boolean insert(User user) {

        if (
                user.getName().isEmpty()
                || user.getLogin().isEmpty()
                || user.getPassword().isEmpty()
        ) {
            return false;
        }

        String sql = "INSERT INTO tb_users "
                + "(name, login, password, active) "
                + "VALUES (?, ?, ?, ?)";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLogin());
            stmt.setString(3, user.getPassword());
            stmt.setInt(4, user.getActive());

            stmt.executeUpdate();

            return true;

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}