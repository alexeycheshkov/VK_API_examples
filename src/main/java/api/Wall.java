package api;

import models.JsonResponse;
import utils.ApiUtils;

public class Wall extends ApiAppRequest{

    public static String postPhotoOnTheWall(String photoId) {
        String request = String.format("%s?owner_id=%s&attachments=photo%s_%s&access_token=%s&v=%s","wall.post",OWNER_ID,OWNER_ID,photoId,ACCESS_TOKEN,API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        return jsonResponse.getBody().toPrettyString();
    }

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
