package api;

import models.JsonResponse;
import utils.ApiUtils;
import utils.Config;

import java.util.LinkedList;
import java.util.List;

public class ApiAppRequest {
    protected static final String OWNER_ID = Config.get("owner_id");
    protected static final String ACCESS_TOKEN = Config.get("access_token");
    protected static final String API_VERSION = Config.get("api_version");

    public static List<String> uploadPhotoOnTheWall(String uploadUrl) {
        JsonResponse jsonResponse = ApiUtils.upLoad(uploadUrl, "src/main/resources/upload_photo.png", "photo");
        List<String> photoObj = new LinkedList<>();
        photoObj.add(jsonResponse.getBody().getObject().getString("photo"));
        photoObj.add(jsonResponse.getBody().getObject().getString("server"));
        photoObj.add(jsonResponse.getBody().getObject().getString("hash"));
        System.out.println(jsonResponse.getBody().toPrettyString());
        return photoObj;
    }



}
