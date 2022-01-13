package com.dya.surat;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.dya.surat.R.color.black;
import static com.dya.surat.R.color.greenColor;
import static com.dya.surat.R.color.redColor;

public class Tasbih extends AppCompatActivity {

    RecyclerView recyclerView;
    String[] s1;
    ImageButton back;
    String getItem;
    ScrollView test;
    ConstraintLayout layoutBar;
    TextView txTextView , txtNum ,txtNum2;
    int num=0, num3=33, num2=-1;

    ImageButton btnZHm , btnMult , btnRetry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasbih);


        back =findViewById(R.id.back);
        btnMult = findViewById(R.id.multy);
        btnRetry =findViewById(R.id.retry);
        recyclerView =findViewById(R.id.MrecyclerView);

        s1 =getResources().getStringArray(R.array.Zikr);
        test =findViewById(R.id.testl);
        txtNum =findViewById(R.id.txtNum);
        txtNum2 =findViewById(R.id.txtNum2);
        txTextView =findViewById(R.id.txt) ;

        btnZHm =findViewById(R.id.btnzhmardn);
        layoutBar =findViewById(R.id.layoutBar);
        txtNum2.setText(String.valueOf(num3));

        btnMult.setOnClickListener(v -> {


            if (num==0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(black));
                }
            }

           if(num3==33) {
               num3=100;
               txtNum2.setText(String.valueOf(num3));
           }
           else if (num3==100){
               num3=500;
               txtNum2.setText(String.valueOf(num3));
           }
           else if (num3==500){
               num3=1000;
               txtNum2.setText(String.valueOf(num3));
           }
           else if (num3==1000){
               num3=33;
               txtNum2.setText(String.valueOf(num3));
           }

        });


        btnRetry.setOnClickListener(v -> {
            num3=33;
            num=0;
            txtNum.setText(String.valueOf(num));
            txtNum2.setText(String.valueOf(num3));
            if (num==0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(black));
                }
            }
        });

        btnZHm.setOnClickListener(v -> {
            num++;
            num2++;
             if (num>0 && num<15 && num3 == 33 ){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(redColor));
                    }
                }else if (num!=0 && num>15 ){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(greenColor));
                    }
                }else if (num==0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(black));
                    }
                }
              if (num<50 && num!=0 && num3 == 100){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(redColor));
                    }
                }else if (num>50 && num!=0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(greenColor));
                    }
                }else if (num==0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(black));
                    }
                }

           if (num<250 && num!=0 && num3 == 500){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(redColor));
                    }
                }else if (num>250 && num!=0){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(greenColor));
                    }
                }else if (num==0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                        txtNum.setTextColor(getResources().getColor(black));
                    }
                }


            if (num<500 && num!=0 && num3 == 500){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(redColor));
                }
            }else if (num>500 && num!=0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(greenColor));
                }
            }else if (num==0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(black));
                }
            }

            if (num>33 && num3==33){

                num=0;


            }else if (num>100 && num3==100){
                num=0;

            }
            else if (num>500 && num3==500){
                num=0;

            }
            else if (num>1000 && num3==1000){
                num=0;

            }
            txtNum.setText(String.valueOf(num));

            if (num==0){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    txtNum.setTextColor(getResources().getColor(black));
                }
            }


        });


        getItem =getIntent().getStringExtra("fileName");

        if (getItem!=null){
            test.setVisibility(View.VISIBLE);
            layoutBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
            txTextView.setText(getItem);
        }

        TasbihAdapter tasbihAdapter = new TasbihAdapter(this,s1);
        recyclerView.setAdapter(tasbihAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        back.setOnClickListener(v -> {
            onBackPressed();
            finish();
        });
    }
}