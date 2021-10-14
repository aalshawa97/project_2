package com.example.myproject2.ui.main;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.myproject2.data.PostsClient;
import com.example.myproject2.model.PostModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostViewModel  extends ViewModel {

  MutableLiveData<List<PostModel>>  postsMutableLiveData = new MediatorLiveData<>();
  //

    public void getPosts(){

      PostsClient.getINSTANCE().getPosts().enqueue(new Callback<List<PostModel>>() {
        @Override
        public void onResponse(Call<List<PostModel>> call, Response<List<PostModel>> response) {
          postsMutableLiveData.setValue(response.body());

        }

        @Override
        public void onFailure(Call<List<PostModel>> call, Throwable t) {

        }
      });
    }

}
