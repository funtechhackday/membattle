package com.membattle;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

/**
 * Created by Севастьян on 25.09.2017.
 */


/* Retrofit 2.0 */



public interface APIService {
    @PUT("auth")
    Call<User> registration(@Body RegistrationUser user);
    @POST("auth")
    Call<User> auth(@Body RegistrationUser user);
}