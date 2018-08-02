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

/**
 * Created by Mohamed Ramadan on 3/6/2017.
 */
public interface InterfaceRequests {

    @POST("/api/user/login")
    Call<CustomerLoginResponse> login(@Body JsonObject customerLoginReq);
    @GET("/users")
    Call<ResponseBody> getUsers();

    ;

}