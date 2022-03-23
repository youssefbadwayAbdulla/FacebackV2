package com.example.facebackv2.ui.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.facebackv2.R;
import com.example.facebackv2.databinding.PostItemBinding;
import com.example.facebackv2.pojo.PostModel;

import java.util.ArrayList;
import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.postHolder> {
    List<PostModel> postModelsList=new ArrayList<>();

    @NonNull
    @Override
    public postHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new postHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.post_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull postHolder holder, int position) {
        PostModel postModel=postModelsList.get(position);
        holder.binding.tvUserId.setText(postModel.getUserId()+"");
        holder.binding.tvTitle.setText(postModel.getTitle());
        holder.binding.tvBody.setText(postModel.getBody());

    }

    @Override
    public int getItemCount() {
        return postModelsList.size();
    }
    public void setList( List<PostModel> postModelsList){
        this.postModelsList=postModelsList;
        notifyDataSetChanged();
    }

    public class postHolder extends RecyclerView.ViewHolder {
        PostItemBinding binding;

        public postHolder(@NonNull PostItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
