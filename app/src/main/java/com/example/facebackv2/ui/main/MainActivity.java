package com.example.facebackv2.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.facebackv2.R;
import com.example.facebackv2.databinding.ActivityMainBinding;
import com.example.facebackv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    PostViewModel postViewModel;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        postViewModel = ViewModelProviders.of(this).get(PostViewModel.class);
        postViewModel.getPosts();
        postAdapter = new PostAdapter();
        binding.rvMain.setAdapter(postAdapter);
        postViewModel.postMutableLiveData.observe(this, new Observer<List<PostModel>>() {
            @Override
            public void onChanged(List<PostModel> postModels) {
                postAdapter.setList(postModels);
            }
        });


    }
}