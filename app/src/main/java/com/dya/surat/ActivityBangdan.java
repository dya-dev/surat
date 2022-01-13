package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ActivityBangdan extends AppCompatActivity {


    ImageButton back ;
    ImageView btnBangPlay;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bangdan);


        back =findViewById(R.id.back);
        btnBangPlay = findViewById(R.id.btnBangPlay);




        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });


        mediaPlayer = MediaPlayer.create(this,R.raw.bang);

        btnBangPlay.setOnClickListener(v -> {
            if (!mediaPlayer.isPlaying()) {
                mediaPlayer.start();
                btnBangPlay.setImageResource(R.drawable.ic_pause);


            }else {
                mediaPlayer.pause();
                btnBangPlay.setImageResource(R.drawable.ic_play);
            }
        });


        mediaPlayer.setOnCompletionListener(mp -> {
            btnBangPlay.setImageResource(R.drawable.ic_play);
            mediaPlayer.seekTo(0);
        });
    }
}