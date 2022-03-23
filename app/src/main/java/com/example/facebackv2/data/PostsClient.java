package com.example.facebackv2.data;

import android.util.Log;

import com.example.facebackv2.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class PostsClient {
    private PostInterface postInterface;
    private static final String TAG = "maing";
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    public static PostInterface getInstance() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                    .build();
            Log.i(TAG, "getInstance: "+retrofit);
        }
        return retrofit.create(PostInterface.class);
    }
//CALLBACK
//    public Call<List<PostModel>> getPosts() {
//        return postInterface.getPosts();
//    }
    //RxjAVA
    public Single<List<PostModel>> getPosts() {
    return postInterface.getPosts();
}
}
