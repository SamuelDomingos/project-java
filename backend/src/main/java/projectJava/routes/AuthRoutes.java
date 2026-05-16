package projectJava.routes;

import static spark.Spark.*;

import com.google.gson.Gson;

import projectJava.dto.LoginRequest;
import projectJava.models.Auth;
import projectJava.utils.ResponseUtils;

public class AuthRoutes {

    public static void register() {

        Gson gson = new Gson();

        Auth auth = new Auth();

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

                boolean success = auth.login(
                        body.user,
                        body.password);

                if (!success) {

                    return ResponseUtils.error(
                            res,
                            401,
                            "Credenciais inválidas");
                }

                return ResponseUtils.success(
                        res,
                        200,
                        "Login realizado com sucesso");
            });

            post("/logout", (req, res) -> {

                boolean success = auth.logout();

                if (success) {

                    return ResponseUtils.success(
                            res,
                            200,
                            "Logout realizado com sucesso");
                }

                return ResponseUtils.error(
                        res,
                        400,
                        "Nenhum usuário logado");
            });
        });
    }
}