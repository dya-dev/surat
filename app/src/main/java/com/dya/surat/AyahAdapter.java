package com.dya.surat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AyahAdapter extends RecyclerView.Adapter<AyahAdapter.MyViewHolder> {

    ArrayList  aText ,aAyah , aTafsir;
    Context context;
    public AyahAdapter(Context ct , ArrayList iAyah , ArrayList iTafsir,ArrayList iText){
        context = ct;
        aAyah =iAyah;
        aTafsir = iTafsir;
        aText = iText;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_ayah_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mAyah.setText(String.valueOf(aText.get(position)));
        holder.mTafsir.setText(String.valueOf(aTafsir.get(position)));
       holder.mNum.setText(String.valueOf(aAyah.get(position)));


    }

    @Override
    public int getItemCount() {
        return aTafsir.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mAyah;
        TextView mTafsir;
        TextView mNum;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mAyah= itemView.findViewById(R.id.aya);
            mNum= itemView.findViewById(R.id.ayanum);
            mTafsir = itemView.findViewById(R.id.tafsir);
            constraintLayout = itemView.findViewById(R.id.ayaLayout);
        }
    }
}
