package com.dya.surat;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MAdapter extends RecyclerView.Adapter<MAdapter.MyViewHolder> {

    ArrayList aSuratName , aSuratIn,aId,aLink;
    Context context;
    public MAdapter(Context ct , ArrayList SuratName , ArrayList SuratIn , ArrayList id , ArrayList link){
        this.context = ct;
        this.aSuratName =SuratName;
        this.aSuratIn = SuratIn;
        this.aId = id;
        this.aLink = link;




    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.my_surat_row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.mSurat.setText(String.valueOf(aSuratName.get(position)));
        holder.mInfo.setText(String.valueOf(aSuratIn.get(position)));
        holder.mId.setText(String.valueOf(aId.get(position)));
        holder.mLink=String.valueOf(aLink.get(position));
        MydbClass mydbClass=new MydbClass(context);


        holder.constraintLayout.setOnClickListener(v -> {
            String iSurat=String.valueOf(aSuratName.get(position));
            String iId=String.valueOf(aId.get(position));
            String iLink = String.valueOf(aLink.get(position));
            mydbClass.readAllAyahData(iId);
            Intent intent =new Intent(context,SuratView.class);
            intent.putExtra("sura",iSurat);
            intent.putExtra("id",iId);
            intent.putExtra("link",iLink);
           context.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return aSuratIn.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mSurat;
        TextView mInfo;
        TextView mId;
        String mLink;
        ConstraintLayout constraintLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            mSurat= itemView.findViewById(R.id.Surat);
            mInfo = itemView.findViewById(R.id.mInfo);
            mId = itemView.findViewById(R.id.sId);
            constraintLayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
