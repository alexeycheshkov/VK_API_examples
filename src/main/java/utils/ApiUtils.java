package utils;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.jackson.JacksonObjectMapper;
import models.JsonResponse;

import java.io.File;

public class ApiUtils {

    static {
        Unirest.config().defaultBaseUrl(Config.get("api_base_url"));
    }

    public static JsonResponse get(String requestPath) {
        HttpResponse<JsonNode> response = Unirest.get(requestPath).asJson();
        Unirest.shutDown();
        return new JsonResponse (response.getStatus(),response.getBody());
    }

    public static JsonResponse post(String requestPath) {
        HttpResponse<JsonNode> response = Unirest.post(requestPath).asJson();
        Unirest.shutDown();
        return new JsonResponse (response.getStatus(),response.getBody());
    }

}
