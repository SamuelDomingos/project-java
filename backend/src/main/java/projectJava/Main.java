package projectJava;

import static spark.Spark.*;
import projectJava.db.DatabaseInit;

import projectJava.routes.UserRoutes;
import projectJava.routes.AuthRoutes;

import projectJava.config.CorsConfig;

public class Main {

    public static void main(String[] args) {
        port(4567);
        CorsConfig.register();
        System.out.println("=================================");
        System.out.println("Iniciando servidor...");
        System.out.println("=================================");

        exception(Exception.class, (e, req, res) -> {
            e.printStackTrace();

            res.type("application/json");
            res.status(500);

            res.body("{ \"error\": \"erro interno no servidor\" }");
        });

        DatabaseInit.init();
        System.out.println("Banco inicializado com sucesso");

        UserRoutes.register();
        AuthRoutes.register();
        System.out.println("=================================");
        System.out.println("Servidor rodando!");
        System.out.println("=================================");
        System.out.println("API:");
        System.out.println("http://localhost:4567");
    }
}