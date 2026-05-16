package projectJava.users;

import projectJava.db.ConnectionFactory;
import projectJava.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;

public class UserList {

    public List<User> list() {

        List<User> users = new ArrayList<>();

        String sql = "SELECT id, name, login, active "
                + "FROM tb_users "
                + "ORDER BY name";
        try (
                Connection conn = ConnectionFactory.getConnection();
                PreparedStatement stmt = conn.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                User user = new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("login"),
                        "",
                        rs.getInt("active"));

                users.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return users;
    }
}