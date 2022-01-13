package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class SplashScreen extends AppCompatActivity {

    CardView imageView;
    Animation  fromTop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        if (Build.VERSION.SDK_INT>+21){
            //bakardet bo goryny rangy status bar wata shryty nyshandany shabaka u sha7n
            Window window =this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.SplashScreenColor));

        }

        imageView =findViewById(R.id.cardeView);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.frometope);

        imageView.setAnimation(fromTop);

        Thread splashThread = new Thread(){

            @Override
            public void run() {
                try {
                    sleep(3000);
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        splashThread.start();

    }
}