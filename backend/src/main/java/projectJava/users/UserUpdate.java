package projectJava.users;

import projectJava.db.ConnectionFactory;
import projectJava.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserUpdate {

    public boolean update(int id, User user) {

        if (user.getName() == null
                || user.getName().trim().isEmpty()
                || user.getLogin() == null
                || user.getLogin().trim().isEmpty()) {
            return false;
        }

        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql;

            boolean hasPassword = user.getPassword() != null
                    && !user.getPassword().trim().isEmpty();

            if (hasPassword) {

                sql = "UPDATE tb_users " +
                        "SET name = ?, login = ?, password = ?, active = ? " +
                        "WHERE id = ?";

            } else {

                sql = "UPDATE tb_users " +
                        "SET name = ?, login = ?, active = ? " +
                        "WHERE id = ?";
            }

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, user.getName());
                stmt.setString(2, user.getLogin());

                if (hasPassword) {

                    stmt.setString(3, user.getPassword());
                    stmt.setInt(4, user.getActive());
                    stmt.setInt(5, id);

                } else {

                    stmt.setInt(3, user.getActive());
                    stmt.setInt(4, id);
                }

                int affectedRows = stmt.executeUpdate();

                return affectedRows > 0;
            }

        } catch (Exception e) {

            e.printStackTrace();

            return false;
        }
    }
}