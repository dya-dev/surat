package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class NameP extends AppCompatActivity {

    ImageButton back;
    RecyclerView recyclerView;
    String s1[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_p);

        back = (ImageButton)findViewById(R.id.back);

        recyclerView = (RecyclerView)findViewById(R.id.NPRecyclerView);
        s1 =getResources().getStringArray(R.array.NameP);

        NMAdapter nmAdapter = new NMAdapter(this,s1);
        recyclerView.setAdapter(nmAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}