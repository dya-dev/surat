package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Zhian_Nama extends AppCompatActivity {

    RecyclerView recyclerView;
    String s1[];
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhian__nama);

        back = (ImageButton)findViewById(R.id.back);
        recyclerView = (RecyclerView)findViewById(R.id.ZHRecyclerView);
        s1 =getResources().getStringArray(R.array.Zhyan);

        ZHAdapter zhAdapter= new ZHAdapter(this,s1);
        recyclerView.setAdapter(zhAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
    }
}