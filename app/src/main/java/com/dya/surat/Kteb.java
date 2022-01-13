package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

public class Kteb extends AppCompatActivity  {

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kteb);
        back = (ImageButton)findViewById(R.id.back);
        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });

    }




}