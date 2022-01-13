package com.dya.surat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class myAdapter extends RecyclerView.Adapter <myAdapter.MyViewHolder>{

    String[] data1;
    String[] data2;
    Context context;

    public myAdapter(Context ct , String[] s1, String[] s2){
        context = ct;
        data1 = s1;
        data2 = s2;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_name_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.mName.setText(data1[position]);
        holder.mMana.setText(data2[position]);
    }

    @Override
    public int getItemCount() {
        return data1.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView mName,mMana;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            mName= itemView.findViewById(R.id.name);
            mMana = itemView.findViewById(R.id.mana);

        }
    }
}
