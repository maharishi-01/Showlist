package com.example.show.Network;

import com.example.show.Dataapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Web {

@GET("studio")
    Call<List<Dataapi>>getPhotos();


}
