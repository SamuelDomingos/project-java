package projectJava.utils;

import java.util.HashMap;

import com.google.gson.Gson;

import spark.Response;

public class ResponseUtils {

    private static Gson gson = new Gson();

    public static String success(
            Response res,
            int status,
            String message
    ) {

        res.status(status);

        res.type("application/json; charset=UTF-8");

        HashMap<String, String> body =
                new HashMap<String, String>();

        body.put("message", message);

        return gson.toJson(body);
    }

    public static String error(
            Response res,
            int status,
            String message
    ) {

        res.status(status);

        res.type("application/json; charset=UTF-8");

        HashMap<String, String> body =
                new HashMap<String, String>();

        body.put("error", message);

        return gson.toJson(body);
    }
}