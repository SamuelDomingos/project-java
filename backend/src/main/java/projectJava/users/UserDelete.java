package projectJava.users;

import projectJava.db.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserDelete {

    public boolean delete(int userId) {

        String sql = "DELETE FROM tb_users WHERE id = ?";

        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);

            int affectedRows = stmt.executeUpdate();

            return affectedRows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}