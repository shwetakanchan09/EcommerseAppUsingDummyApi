package com.shweta.ecommerseappusingdummyapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;


import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;


public class ApiClient {
    public static EcommerceApp ecommerceApp;
    public static EcommerceApp getEcommerceApp(){
        if (ecommerceApp == null){
            OkHttpClient client = new OkHttpClient.Builder()
                    .readTimeout(80, TimeUnit.SECONDS)
                    .connectTimeout(80, TimeUnit.SECONDS)
                    .build();
            Gson gson = new GsonBuilder()
                    .setLenient().create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://dummyjson.com")
                    // .addConverterFactory(ScalerConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .client(client)
                    .build();
            ecommerceApp = retrofit.create(EcommerceApp.class);
        }
        return ecommerceApp;
    }
    public interface EcommerceApp {
        @GET("/products/categories")
        Call<ArrayList<AllProductModel>> getAllCategories();
        @GET("products/1")
        Call<SingleProduct> getSingleProduct();
        @GET("/products/categories")
        Call<ResponseBody> getData();

    }
}
