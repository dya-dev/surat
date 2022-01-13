package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Salah extends AppCompatActivity {

    CardView wc,islam,tayamum,dasNwezh,nwezhkrdn,hala;
    Animation open;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salah);

        open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frometope);

        wc = (CardView)findViewById(R.id.wc);
        islam = (CardView)findViewById(R.id.islam);
        tayamum = (CardView)findViewById(R.id.tayamum);
        dasNwezh = (CardView)findViewById(R.id.dasNwezh);
        nwezhkrdn = (CardView)findViewById(R.id.nwezhkrdn);
        hala = (CardView)findViewById(R.id.hala);



        wc.setAnimation(open);
        islam.setAnimation(open);
        tayamum.setAnimation(open);
        dasNwezh.setAnimation(open);
        nwezhkrdn.setAnimation(open);
        hala.setAnimation(open);

        wc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,Wc.class);
                startActivity(intent);

            }
        });
        hala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,Halla.class);
                startActivity(intent);

            }
        });

        islam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,IslamB.class);
                startActivity(intent);

            }
        });

        tayamum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,Tayamum.class);
                startActivity(intent);

            }
        });

        nwezhkrdn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,SallahN.class);
                startActivity(intent);

            }
        });

        dasNwezh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Salah.this,Dasnwezh.class);
                startActivity(intent);

            }
        });

    }
}