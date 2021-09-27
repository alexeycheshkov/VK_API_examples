package api;

import models.JsonResponse;
import utils.ApiUtils;

public class Photos extends ApiAppRequest {

    public static String getWallPhotoUploadServer() {
        String request = String.format("%s?user_id=%s&access_token=%s&v=%s", "photos.getWallUploadServer", OWNER_ID, ACCESS_TOKEN, API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        System.out.println(jsonResponse.getBody().toPrettyString());
        return jsonResponse.getBody().getObject().getJSONObject("response").getString("upload_url");
    }

    public static String saveUploadWallPhoto(String photo, String server, String hash) {
        String request = String.format("%s?user_id=%s&photo=%s&server=%s&hash=%s&access_token=%s&v=%s","photos.saveWallPhoto",OWNER_ID, photo,server,hash,ACCESS_TOKEN,API_VERSION);
        JsonResponse jsonResponse = ApiUtils.post(request);
        System.out.println(jsonResponse.getBody().toPrettyString());
        return jsonResponse.getBody().getObject().getJSONArray("response").getJSONObject(0).getString("id");
    }
}
