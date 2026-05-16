package projectJava.routes;

import static spark.Spark.*;

import com.google.gson.Gson;

import projectJava.controllers.AuthController;
import projectJava.dto.LoginRequest;
import projectJava.utils.ResponseUtils;

public class AuthRoutes {

        public static void register() {

                Gson gson = new Gson();

                AuthController controller = new AuthController();

                path("/auth", () -> {

                        post("/login", (req, res) -> {

                                LoginRequest body = gson.fromJson(
                                                req.body(),
                                                LoginRequest.class);

                                if (body == null
                                                || body.user == null
                                                || body.user.trim().isEmpty()
                                                || body.password == null
                                                || body.password.trim().isEmpty()) {

                                        return ResponseUtils.error(
                                                        res,
                                                        400,
                                                        "Campos obrigatórios");
                                }

                                boolean success = controller.login(
                                                body.user,
                                                body.password);

                                if (!success) {

                                        return ResponseUtils.error(
                                                        res,
                                                        401,
                                                        controller.getErrorMessage());
                                }

                                return ResponseUtils.success(
                                                res,
                                                200,
                                                "Login realizado com sucesso");
                        });

                        post("/logout", (req, res) -> {

                                boolean success = controller.logout();

                                if (success) {

                                        return ResponseUtils.success(
                                                        res,
                                                        200,
                                                        "Logout realizado com sucesso");
                                }

                                return ResponseUtils.error(
                                                res,
                                                400,
                                                controller.getErrorMessage());
                        });
                });
        }
}