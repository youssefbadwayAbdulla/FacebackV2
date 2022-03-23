package com.example.facebackv2.ui.main;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.facebackv2.data.PostsClient;
import com.example.facebackv2.pojo.PostModel;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.core.SingleObserver;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel extends ViewModel {
    private static final String TAG = "view";
    MutableLiveData<List<PostModel>> postMutableLiveData = new MutableLiveData<>();


    public void getPosts() {
        Single<List<PostModel>> observable = PostsClient.getInstance().getPosts()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                ;

        observable.subscribe(o-> postMutableLiveData.setValue(o),e-> Log.i(TAG, "getPosts: "+e));


    }
}
