package com.example.facebackv2.data;

import com.example.facebackv2.pojo.PostModel;

import java.io.Serializable;
import java.util.List;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface PostInterface {
    @GET("posts")
    //CallBack
    // Call<List<PostModel>>getPosts();
    //RXJAVA
    Single<List<PostModel>> getPosts();
}
