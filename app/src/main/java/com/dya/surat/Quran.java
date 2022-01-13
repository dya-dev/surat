package com.dya.surat;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Quran extends AppCompatActivity {

    MydbClass mydbClass;
    SQLiteDatabase db;
    RecyclerView recyclerView;
    ArrayList aSuratName , aSuratIn,aId,aLink;
    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quran);
       // overridePendingTransition(R.anim.frometope,R.anim.frometope);
        back = (ImageButton)findViewById(R.id.back);
        recyclerView = (RecyclerView)findViewById(R.id.MrecyclerView);

        mydbClass = new MydbClass(this);
        mydbClass.StartWork();
        db=mydbClass.getWritableDatabase();
        aSuratName = new ArrayList<>();
        aSuratIn = new ArrayList<>();
        aId = new ArrayList<>();
        aLink = new ArrayList<>();
        StoreDataInArrayList();


        MAdapter MAdapter = new MAdapter(this,aSuratName , aSuratIn,aId,aLink);
        recyclerView.setAdapter(MAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });


    }
    void StoreDataInArrayList(){

        Cursor cursor = mydbClass.readAllData();
        if (cursor.getCount() == 0){
            Toast.makeText(this, "no data ", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                aId.add(cursor.getString(0));
                aSuratName.add(cursor.getString(1));
                aSuratIn.add(cursor.getString(2));
                aLink.add(cursor.getString(5));


            }
        }
    }
}