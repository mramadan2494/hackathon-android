package api;


import com.google.gson.JsonObject;

import api.response.CustomerLoginResponse;
import api.response.User;
import api.response.UsersResponse;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Mohamed Ramadan on 3/6/2017.
 */
public interface InterfaceRequests {

    @GET("/users/{id}")
    Call<CustomerLoginResponse> login(@Path("id") String id);
    @GET("/users")
    Call<ResponseBody> getUsers();
    @GET("/locations")
    Call<ResponseBody> getLocations();



}