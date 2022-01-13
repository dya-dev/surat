package com.dya.surat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.squareup.picasso.Picasso;

import java.util.List;

public class GalleryAdapter extends RecyclerView.Adapter <GalleryAdapter.MyViewHolder>{

    List<String> imageUrl;
    Context context;

    public GalleryAdapter(Context ct , List<String> getUrl){
        context = ct;
        imageUrl = getUrl;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.gallery_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        /*
        RequestManager requestManager = Picasso.with(this.context);
        RequestBuilder requestBuilder =requestManager.load(imageUrl.get(position));
        requestBuilder.into(holder.getImage);


        Picasso.with(this.context)
                .load(imageUrl.get(position))
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.getImage);

        */
        Picasso.get().load(imageUrl.get(position))
                .fit().centerCrop()
                .placeholder(R.drawable.ic_image_not)
                .error(R.drawable.ic_image_not)
                .into(holder.getImage);

    }

    @Override
    public int getItemCount() {
        return imageUrl.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView getImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           getImage= itemView.findViewById(R.id.getImage);

        }
    }
}
