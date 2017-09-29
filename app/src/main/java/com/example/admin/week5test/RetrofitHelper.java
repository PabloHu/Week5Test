package com.example.admin.week5test;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by Admin on 9/29/2017.
 */

public class RetrofitHelper {
    public static final String BASE_URL = "http://api.flickr.com/";

    public static Retrofit create() {


        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
    //create a static method to use the interface verbs
  //  Call<List<Response>>
    public static Call<List<com.example.admin.week5test.model.Response>> createCallWeather(){
        Retrofit retrofit = create();
        ApiService apiService = retrofit.create(ApiService.class);
        return apiService.getCityForecast();
    }

    //create an interface to have all the paths and verbs for the REST api to use
    interface ApiService {
        //services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1
        @GET("services/feeds/photos_public.gne?tag=kitten&format=json&nojsoncallback=1")// id={id}APPID={key}")//{user} or {abc} will make it {abc} dynamically
     //   Call<List<com.example.admin.week5test.model.Response>> getCityForecast();
        Call<List<com.example.admin.week5test.model.Response> >getCityForecast();
    }

}
