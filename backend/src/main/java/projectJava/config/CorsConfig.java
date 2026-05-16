package projectJava.config;

import static spark.Spark.*;

public class CorsConfig {

    public static void register() {

        before((req, res) -> {

            res.header(
                    "Access-Control-Allow-Origin",
                    "http://localhost:3000");

            res.header(
                    "Access-Control-Allow-Methods",
                    "GET,POST,PUT,DELETE,OPTIONS");

            res.header(
                    "Access-Control-Allow-Headers",
                    "Content-Type,Authorization");

            res.type("application/json");
        });

        options("/*", (req, res) -> {

            String accessControlRequestHeaders =
                    req.headers("Access-Control-Request-Headers");

            if (accessControlRequestHeaders != null) {

                res.header(
                        "Access-Control-Allow-Headers",
                        accessControlRequestHeaders);
            }

            String accessControlRequestMethod =
                    req.headers("Access-Control-Request-Method");

            if (accessControlRequestMethod != null) {

                res.header(
                        "Access-Control-Allow-Methods",
                        accessControlRequestMethod);
            }

            return "OK";
        });
    }
}