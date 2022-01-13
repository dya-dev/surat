package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class About extends AppCompatActivity {

    ImageButton back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        back = (ImageButton)findViewById(R.id.back);

        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(About.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}