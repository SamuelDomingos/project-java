package projectJava.routes;

import static spark.Spark.*;

import com.google.gson.Gson;

import projectJava.controllers.UserController;
import projectJava.models.User;
import projectJava.utils.ResponseUtils;

public class UserRoutes {

    public static void register() {

        Gson gson = new Gson();

        UserController controller = new UserController();

        path("/users", () -> {

            get("", (req, res) -> {

                res.type("application/json; charset=UTF-8");

                return gson.toJson(
                        controller.getAllUsers());
            });

            post("", (req, res) -> {

                User user = gson.fromJson(
                        req.body(),
                        User.class);

                boolean created = controller.createUser(user);

                if (created) {

                    return ResponseUtils.success(
                            res,
                            201,
                            "Usuário criado");
                }

                return ResponseUtils.error(
                        res,
                        400,
                        "Erro ao criar usuário");
            });

            put("/:id", (req, res) -> {

                int id = Integer.parseInt(
                        req.params(":id"));

                User user = gson.fromJson(
                        req.body(),
                        User.class);

                boolean updated = controller.updateUser(
                        id,
                        user);

                if (updated) {

                    return ResponseUtils.success(
                            res,
                            200,
                            "Usuário atualizado");
                }

                return ResponseUtils.error(
                        res,
                        400,
                        "Erro ao atualizar usuário");
            });

            delete("/:id", (req, res) -> {

                int id = Integer.parseInt(
                        req.params(":id"));

                boolean deleted = controller.removeUser(id);

                if (deleted) {

                    return ResponseUtils.success(
                            res,
                            200,
                            "Usuário removido");
                }

                return ResponseUtils.error(
                        res,
                        400,
                        "Erro ao remover usuário");
            });
        });
    }
}