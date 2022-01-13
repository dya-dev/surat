package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.hassanjamil.hqibla.CompassActivity;
import com.hassanjamil.hqibla.Constants;
import com.makeramen.roundedimageview.RoundedImageView;


import softpro.naseemali.ShapedNavigationView;

public class MainActivity extends AppCompatActivity{


    CardView allah,muhamad,pexambaran,quran,kteb,Paya,zikr,zakat,nwezh,dhikr;
    Animation open;
    DrawerLayout drawerLayout;
    ShapedNavigationView navigationView;
    ImageView btnMenu,btnQibla,btnGallery,btnAya,btnBang;
    RoundedImageView btnSuratFb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        open = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.frometope);
        drawerLayout = findViewById(R.id.navigation_drawer);
        btnMenu= findViewById(R.id.btnNav);
        btnSuratFb=findViewById(R.id.btnSuratFb);
        navigationView=findViewById(R.id.nav_view);

        btnQibla =findViewById(R.id.btnQibla);
        btnGallery =findViewById(R.id.btnGallery);
        btnAya =findViewById(R.id.btnAya);
        btnBang =findViewById(R.id.btnBang);




        quran = findViewById(R.id.quran);
        allah = findViewById(R.id.allah);
        muhamad = findViewById(R.id.muhamad);
        pexambaran = findViewById(R.id.pexambaran);
        kteb = findViewById(R.id.Kteb);
        Paya = findViewById(R.id.Paya);
        zikr = findViewById(R.id.Tasbih);
        zakat = findViewById(R.id.zakat);
        nwezh = findViewById(R.id.nwezh);
        dhikr = findViewById(R.id.dhikr);
        //////////


        LayoutInflater inflater =getLayoutInflater();
        View view =inflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_view));

        TextView txtToast = view.findViewById(R.id.txtToast);
        final  Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);



        // check krdny internet
        ConnectivityManager connectivityManager  = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

        ////////////
        navigationView.setNavigationItemSelectedListener(item -> {
            int id = item.getItemId();
            if (id==R.id.home){
                //nothing
            }else if (id== R.id.about){
                Intent intent = new Intent(MainActivity.this,About.class);
                startActivity(intent);
                finish();
            }else if (id==R.id.developerId){
                Intent intent = new Intent(MainActivity.this,Developer.class);
                startActivity(intent);
                finish();
            }else if (id==R.id.Share){
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                String shareSubject="Surat Application  Download now";
                String shareBode =" Surat::ئپڵیکەیشنی سورەت  \n  لەڕێگەی ئەم لینکەوە دایبەزێنە هەمیشە قورائانی پیرۆز لەگەڵتایە *** \n   \nhttp://play.googl.com/store/apps/details?id=com.dya.surat";
                shareIntent.putExtra(Intent.EXTRA_TEXT,shareBode);
                shareIntent.putExtra(Intent.EXTRA_SUBJECT,shareSubject);
                startActivity(Intent.createChooser(shareIntent,"share using"));

            }
            else if (id==R.id.Star){
                // review and rating
               try {

                   startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("market://details?id="+getPackageName())));

               }catch (ActivityNotFoundException e){
                   startActivity(new Intent(Intent.ACTION_VIEW,
                           Uri.parse("http://play.googl.com/store/apps/details?id="+getPackageName())));
               }
            }
            else if (id==R.id.Exit){
                onBackPressed();
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;

        });
        navigationView.setItemIconTintList(null);



        quran.setAnimation(open);
        allah.setAnimation(open);
        muhamad.setAnimation(open);
        pexambaran.setAnimation(open);
        kteb.setAnimation(open);
        Paya.setAnimation(open);
        zikr.setAnimation(open);
        zakat.setAnimation(open);
        nwezh.setAnimation(open);


        btnQibla.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, CompassActivity.class);
            intent.putExtra(Constants.TOOLBAR_BG_COLOR,"#003B46");
            intent.putExtra(Constants.TOOLBAR_TITLE,"قـیبلە نمـا");
            // intent.putExtra(Constants.TOOLBAR_TITLE_COLOR,"#003B46");

            intent.putExtra(Constants.COMPASS_BG_COLOR,"#003B46");
            intent.putExtra(Constants.DRAWABLE_QIBLA,R.drawable.ic_qibla);
            startActivity(intent);


        });



        btnGallery.setOnClickListener(v -> {

            // gar wifi yan mobile data habw ba download dastpebkat
            if (wifi.isConnected()|| mobileNetwork.isConnected()) {

                Intent intent = new Intent(MainActivity.this,GalleryActivity.class);
                startActivity(intent);

            }
            // agar wifi yan mobile data nabww massagek pishan bat
            else {
                txtToast.setText("تکایە دلنیابەرەوە لە هەبونی ئینتەرنێنت");
                toast.show();
            }

        });



        btnBang.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,ActivityBangdan.class);
            startActivity(intent);
        });



        btnAya.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,AyatKursyActivity.class);
            startActivity(intent);
        });



        btnSuratFb.setOnClickListener(v -> {

            String facbookUrl = "https://www.facebook.com/surat.islamic.app.krd/";
            try {
                int versinCode = getPackageManager().getPackageInfo("com.facebook.katana",0).versionCode;
                if (versinCode>=3002850){
                    Uri uri = Uri.parse("fb://facewebmodal/f?href="+facbookUrl);
                    startActivity(new Intent(Intent.ACTION_VIEW,uri));
                }else{
                    startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("fb://profile/105098568526484")));
                }
            } catch (PackageManager.NameNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse(facbookUrl)));
            }
        });

        btnMenu.setOnClickListener(v -> drawerLayout.openDrawer(GravityCompat.START));

        quran.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Quran.class);
            startActivity(intent);

        });


        allah.setOnClickListener(v -> {

           Intent intent = new Intent(MainActivity.this,Nawakany_xuda.class);
           startActivity(intent);

        });

        pexambaran.setOnClickListener(v -> {

              Intent intent = new Intent(MainActivity.this,NameP.class);
             startActivity(intent);

        });

        muhamad.setOnClickListener(v -> {

          Intent intent = new Intent(MainActivity.this,Zhian_Nama.class);
          startActivity(intent);

        });
        kteb.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Kteb.class);
            startActivity(intent);

        });

        Paya.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,PayaKan.class);
            startActivity(intent);

        });

        zikr.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Tasbih.class);
            startActivity(intent);

        });
        zakat.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Zakat.class);
            startActivity(intent);

        });
        nwezh.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Salah.class);
            startActivity(intent);

        });



        dhikr.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this,Zikr_Activity.class);
            startActivity(intent);

        });
    }

    @Override
    public void onBackPressed() {

        ViewGroup viewGroup =findViewById(android.R.id.content);

        Button btnYes,btnNo;


       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       View view= LayoutInflater.from(MainActivity.this).inflate(R.layout.close_dialog_layout,viewGroup,false);
       builder.setCancelable(false);
       builder.setView(view);

       btnYes =view.findViewById(R.id.btnYes);
       btnNo =view.findViewById(R.id.btnNo);

     final   AlertDialog alertDialog = builder.create();

     alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

       btnYes.setOnClickListener(v -> System.exit(0));

       btnNo.setOnClickListener(v -> alertDialog.dismiss());


       alertDialog.show();

    }


}