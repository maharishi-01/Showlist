package com.example.show.Dat;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.app.Activity;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.show.Dataapi;
import com.example.show.Main3Activity;
import com.example.show.MainActivity;
import com.example.show.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder>{
    private LayoutInflater inflater;
    Context context;
    List<Dataapi>photoList;
    private Object RequestOptions;

//    public DataAdapter(Context applicationContext, List<Dataapi> photoList) {
//
//    }
//
//    public interface OnItemClickListener {
//        void onItemClick(Dataapi item);
//    }

   // private final List<Dataapi> items;
  //  private final OnItemClickListener listener;
//
//    public DataAdapter(List<ContentItem> items, OnItemClickListener listener) {
//        this.items = items;
//        this.listener = listener;
//    }


    public DataAdapter(Context context,List<Dataapi>photoList){
        this.context=context;
        this.photoList=photoList;
        //this.listener=listener;
        inflater= LayoutInflater.from(context);
    }
    public void setPhotoList(List<Dataapi>photoList){
        this.photoList=photoList;
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(photoList.get(position).getSong());
        holder.textView2.setText(photoList.get(position).getSong());
      //  holder.button.play

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
              //  Toast.makeText(context,"The Item Clicked is: "+photoList.get(position).getUrl(),Toast.LENGTH_SHORT).show();


                String url = photoList.get(position).getUrl();
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });

        //holder.bind(photoList.get(position), listener);
       Glide.with(context).load(photoList.get(position).getCoverImage()).into(holder.imageView);




    }

    @Override
    public int getItemCount() {
        if(photoList !=null){
            return photoList.size();
        }
        return 0;
    }



    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView,textView2;
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textView =(TextView)itemView.findViewById(R.id.all_Title);
            textView2=(TextView)itemView.findViewById(R.id.artist) ;
            imageView=(ImageView)itemView.findViewById(R.id.photo);

        }

//        public void bind(final Dataapi dataapi, final OnItemClickListener listener) {
//
//
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override public void onClick(View v) {
//                   // listener.onItemClick(dataapi);
//
//                    Toast.makeText(context, "Item Clicked", Toast.LENGTH_LONG).show();
//                }
//            });
//        }
    }
}
