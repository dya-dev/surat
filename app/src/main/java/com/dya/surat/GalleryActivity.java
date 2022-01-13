package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class GalleryActivity extends AppCompatActivity {

    List<String> imageUrl;

    RecyclerView gRecyclerView;
    RecyclerView.LayoutManager gridLayoutManager ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        gRecyclerView = findViewById(R.id.gRecyclerView);

        imageUrl =new ArrayList<>();

        imageUrl.add("https://drive.google.com/uc?id=1obAb2ux2ACFIiLA8xN44OdrycOGFs1Pz");
        imageUrl.add("https://drive.google.com/uc?id=1oZYP38mJYzEeBhK58nod2JgQaUoeYUgK");
        imageUrl.add("https://drive.google.com/uc?id==1obpEbZrMSmG26TjaUU6D4eRiKuud-APJ");
        imageUrl.add("https://drive.google.com/uc?id=1pL6vWZah1Hv8_adb0k8A9ZsxxEg21mR3");
        imageUrl.add("https://drive.google.com/uc?id=1pFgOT3k_D4A-TPTjfTcFkHhZu20I9Ibh");
        imageUrl.add("https://drive.google.com/uc?id=1pflg0E7p_7BCivkBEHoA_jGGBsx2JrzX");
        imageUrl.add("https://drive.google.com/uc?id=1pDkLPn_WZeLJUWXGAGfwZg9TejACvTjs");
        imageUrl.add("https://drive.google.com/uc?id=1pKD9MhCqjBm1LgeJ1dIEjHNuGtXO6VRk");
        imageUrl.add("https://drive.google.com/uc?id=1ooVMQPiC4vhG5WqsM2kHt6McoK1v5VI9");
        imageUrl.add("https://drive.google.com/uc?id=1ocnoR_0gcyQ3D1Eu6F9ddwfIb8TSFnQB");
        imageUrl.add("https://drive.google.com/uc?id=1o7Ct3XnP1Vpw6I6Oy8WPwEfY2rtvaiCO");
        imageUrl.add("https://drive.google.com/uc?id=1oiaB4M29lJBlUOmFm0P4y8jB1EwUqqV9");
        imageUrl.add("https://drive.google.com/uc?id=1pifvLuRlO625cinNbihzrBlEfioTsxNH");
        imageUrl.add("https://drive.google.com/uc?id=1pmp2EuXoh56xCacfiiYWxDtE7xGFEM-M");
        imageUrl.add("https://drive.google.com/uc?id=1plgpL3SjX5tsVkqof58Q9SaE7HGqfo1E");
        imageUrl.add("https://drive.google.com/uc?id=1pVIVaqQzd5CVykpSVxRamMmQ1F8CEO0S");
        imageUrl.add("https://drive.google.com/uc?id=1pLt-Jh4WWw6XfkLAjGvWVM7WbcV5izcO");
        imageUrl.add("https://drive.google.com/uc?id=1oosPDHDLQ9g4FU5riMZ2LVo8Qi8xwkqc");
        imageUrl.add("https://drive.google.com/uc?id=1oNeiTjNQpqMKQ1fn4OjLFWBVijcDPWsy");
        imageUrl.add("https://drive.google.com/uc?id=1oUihFrZY4QhG0Xhi9m46yghRgTq5iyIY");
        imageUrl.add("https://drive.google.com/uc?id=1oPGFlOBcIdwhUPJXI5vx8FkSjAVk9DqC");
        imageUrl.add("https://drive.google.com/uc?id=1ojmNkPO3xVfW_qao35cEadpKMtCNfZ2j");
        imageUrl.add("https://drive.google.com/uc?id=1ohQMpotzYQwCSE5c4BBy_NQ7R9gA9Qu8");

        GalleryAdapter galleryAdapter = new GalleryAdapter(this,imageUrl);

        gridLayoutManager =new GridLayoutManager(this,2);
        gRecyclerView.setLayoutManager(gridLayoutManager);
        gRecyclerView.setAdapter(galleryAdapter);


    }
}