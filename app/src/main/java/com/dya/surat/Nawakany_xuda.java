package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class Nawakany_xuda extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] s1;
    String[] s2;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nawakany_xuda);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        s1 =getResources().getStringArray(R.array.NawakanyXuda);
        s2 =getResources().getStringArray(R.array.mana);
        back = (ImageButton)findViewById(R.id.mback);

        myAdapter mAdapter = new myAdapter(this,s1,s2);
        recyclerView.setAdapter(mAdapter);
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