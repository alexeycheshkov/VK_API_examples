package main;

import models.JsonResponse;
import utils.ApiUtils;
import utils.Config;

public class ApiAppRequest {
    private static final String OWNER_ID = Config.get("owner_id");
    private static final String ACCESS_TOKEN = Config.get("access_token");
    private static final String API_VERSION = Config.get("api_version");

    public static String postTextMsgToTheWall(String text) {
        String request = String.format("%s?owner_id=%s&message=%s&access_token=%s&v=%s","wall.post",OWNER_ID,text,ACCESS_TOKEN,API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        return jsonResponse.getBody().toPrettyString();
    }

    public static String editPostOnTheWall(String text, String postId) {
        String request = String.format("%s?owner_id=%s&post_id=%s&message=%s&access_token=%s&v=%s","wall.edit",OWNER_ID,postId,text,ACCESS_TOKEN,API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        return jsonResponse.getBody().toPrettyString();
    }

    public static String deletePostFromTheWall(String postId) {
        String request = String.format("%s?owner_id=%s&post_id=%s&access_token=%s&v=%s","wall.delete",OWNER_ID,postId,ACCESS_TOKEN,API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        return jsonResponse.getBody().toPrettyString();
    }

}
