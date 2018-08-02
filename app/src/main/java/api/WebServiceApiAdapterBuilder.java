package api;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import utilities.Constants;

/**
 * Created by Mohamed Ramadan on 3/6/2017.
 */

public class WebServiceApiAdapterBuilder {
    private static InterfaceRequests interfaceRequests = null;
    private final static int DEFAULT_TIMEOUT_SECONDS = 30;
    private WebServiceApiAdapterBuilder() {

    }
    public static InterfaceRequests getInstance(){
        return getInstance(Constants.BASE_URL , DEFAULT_TIMEOUT_SECONDS);
    }
    public static InterfaceRequests getInstance(int timeoutSeconds){
        return getInstance(Constants.BASE_URL , timeoutSeconds);
    }

    public static InterfaceRequests getInstance(String baseURL , int timeoutSeconds) {

        Gson gson = new GsonBuilder()
                .create();

        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder()
                .readTimeout(timeoutSeconds , TimeUnit.SECONDS )
                .connectTimeout(timeoutSeconds , TimeUnit.SECONDS);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseURL)//("http://www.mocky.io")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .callFactory(httpClientBuilder.build())
                //.addConverterFactory(GsonConverterFactory.create())
                .build();
        interfaceRequests = retrofit.create(InterfaceRequests.class);


        return interfaceRequests;
    }


}