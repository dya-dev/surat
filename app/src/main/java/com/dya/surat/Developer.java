package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;

public class Developer extends AppCompatActivity {


    ImageButton back;
    ImageView fb,ig,yt,gm;
    Animation open,close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fab_open);
        close= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.close_fab);


        back = (ImageButton)findViewById(R.id.back);
        fb = (ImageView)findViewById(R.id.facebook);
        ig = (ImageView)findViewById(R.id.instagram);
        yt = (ImageView)findViewById(R.id.youtube);
        gm = (ImageView)findViewById(R.id.gmail);



        fb.setAnimation(open);
        ig.setAnimation(open);
        yt.setAnimation(open);
        gm.setAnimation(open);

        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
        fb.setOnClickListener(v -> {
            String facbookUrl = "https://www.facebook.com/dya.000/";
            try {
                int versinCode = getPackageManager().getPackageInfo("com.facebook.katana",0).versionCode;
                if (versinCode>=3002850){
                    Uri uri = Uri.parse("fb://facewebmodal/f?href="+facbookUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW,uri));
                }else{
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("fb://profile/218345114850283")));
                }
            } catch (PackageManager.NameNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(facbookUrl)));
            }
        });
        ig.setOnClickListener(v -> {

            Uri uri = Uri.parse("https://instagram.com/_u/dya_garmiany/");
            Intent linkIg = new Intent(Intent.ACTION_VIEW,uri);
            linkIg.setPackage("com.instagram.android");

            try {
                startActivity(linkIg);

            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.instagram.com/dya_garmiany/")));
            }
        });
        yt.setOnClickListener(v -> {
            Uri uri = Uri.parse(("https://www.youtube.com/channel/UCqOQuksZHtX0ug8qn-ZiaYw"));
            Intent linkYt = new Intent(Intent.ACTION_VIEW,uri);
            linkYt.setPackage("com.google.android.youtube");
            try {
                startActivity(linkYt);
            }catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/channel/UCqOQuksZHtX0ug8qn-ZiaYw")));
            }

        });
        gm.setOnClickListener(v -> {
            String mail ="dyarinasih51@gmail.com";
            Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:"+mail));
            startActivity(intent);
        });

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Developer.this,MainActivity.class);
        startActivity(intent);
        finish();
    }
}