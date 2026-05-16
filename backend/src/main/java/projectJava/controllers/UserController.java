package projectJava.controllers;

import projectJava.models.User;
import projectJava.users.*;

import java.util.List;

public class UserController {

    private UserInsert insert = new UserInsert();
    private UserList list = new UserList();
    private UserDelete delete = new UserDelete();
    private UserUpdate update = new UserUpdate();

    public boolean createUser(User user) {

        if (
                user == null
                || user.getName() == null
                || user.getName().trim().isEmpty()
                || user.getLogin() == null
                || user.getLogin().trim().isEmpty()
                || user.getPassword() == null
                || user.getPassword().trim().isEmpty()
        ) {
            return false;
        }

        return insert.insert(user);
    }

    public List<User> getAllUsers() {
        return list.list();
    }

    public boolean updateUser(int id, User user) {

        if (
                user == null
                || user.getName() == null
                || user.getName().trim().isEmpty()
                || user.getLogin() == null
                || user.getLogin().trim().isEmpty()
        ) {
            return false;
        }

        return update.update(id, user);
    }

    public boolean removeUser(int id) {
        return delete.delete(id);
    }
}