package main;

import api.ApiAppRequest;
import api.Photos;
import api.Wall;
import lombok.SneakyThrows;

import java.net.URLEncoder;
import java.util.List;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        String uploadUrl = Photos.getWallPhotoUploadServer();
        List<String> photoObj = ApiAppRequest.uploadPhotoOnTheWall(uploadUrl);
        String photo = photoObj.get(0);
        String server = photoObj.get(1);
        String hash = photoObj.get(2);
        String photoId = Photos.saveUploadWallPhoto(URLEncoder.encode(photo,"UTF-8"),server,hash);
        System.out.println(Wall.postPhotoOnTheWall(photoId));
    }
}
