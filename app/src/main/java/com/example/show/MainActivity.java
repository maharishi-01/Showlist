package com.example.show;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.show.Dat.DataAdapter;
import com.example.show.Network.NetworkHelper;
import com.example.show.Network.Web;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Dataapi>photoList;
    RecyclerView recyclerView;
    DataAdapter recyclerAdapter;
    private TextView mlog;
    Web mweb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // initView();
        mweb= NetworkHelper.getRetrofit().create(Web.class);
        photoList=new ArrayList<>();
        recyclerView=(RecyclerView)findViewById(R.id.maincard);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter=new DataAdapter(getApplicationContext(),photoList);
        recyclerView.setAdapter(recyclerAdapter);


        Call<List<Dataapi>> call=mweb.getPhotos();
        call.enqueue(new Callback<List<Dataapi>>() {
            @Override
            public void onResponse(Call<List<Dataapi>> call, Response<List<Dataapi>> response) {
                photoList = response.body();
                Log.d("TAG","Response = "+photoList);
                recyclerAdapter.setPhotoList(photoList);

            }

            @Override
            public void onFailure(Call<List<Dataapi>> call, Throwable t) {

            }
        });
    }


//
//    recycler.setAdapter(new ContentAdapter(, new ContentAdapter.OnItemClickListener() {
//        @Override public void onItemClick(ContentItem item) {
//            Toast.makeText(getContext(), "Item Clicked", Toast.LENGTH_LONG).show();
//        }
//    }));
//    private void getPhoto() {
//
//
//    }
}
