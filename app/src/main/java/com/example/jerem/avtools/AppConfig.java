package com.example.jerem.avtools;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by jerem on 12/2/2016.
 */

public class AppConfig {

    public interface insert {
        @FormUrlEncoded
        @POST("/avtoolsapp/create_plane.php")
        void insertData(
                @Field("pname") String editPlaneName,
                @Field("ptype") String editPlaneType,
                Callback<Response> callback);

    }

}
