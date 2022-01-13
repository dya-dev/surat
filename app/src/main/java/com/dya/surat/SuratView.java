package com.dya.surat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.Manifest;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;


public class SuratView extends AppCompatActivity {

    TextView txtSuaratName ;
    ImageView btnPlay ,btnDownload;
    MediaPlayer mediaPlayer;
    MydbClass mydbClass;
    SQLiteDatabase db;
    String id,filename,fileUrl,FolderName=Environment.DIRECTORY_MUSIC;
    RecyclerView sRecyclerView;
    ImageButton back;
    ArrayList aAyah , aTafsir,aText;
    SeekBar seekBar;
    Handler handler = new Handler();
    Runnable runnable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surat_view);


        back = (ImageButton)findViewById(R.id.sBack);
        sRecyclerView=findViewById(R.id.sRecyclerView);
        txtSuaratName = findViewById(R.id.txtSuratNAm);
        btnPlay = findViewById(R.id.btnPlay);
        btnDownload  = findViewById(R.id.btnDownload);
        seekBar = findViewById(R.id.seek_bar);

        mydbClass = new MydbClass(this);

        mediaPlayer= new MediaPlayer();
        mydbClass.StartWork();
        db=mydbClass.getWritableDatabase();

        aText = new ArrayList<>();
        aAyah = new ArrayList<>();
        aTafsir = new ArrayList<>();
        id=getIntent().getStringExtra("id");
        fileUrl=getIntent().getStringExtra("link");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });


        LayoutInflater inflater =getLayoutInflater();
        View view =inflater.inflate(R.layout.toast_layout,(ViewGroup)findViewById(R.id.toast_view));

        TextView txtToast = view.findViewById(R.id.txtToast);
        final  Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.BOTTOM,0,50);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setView(view);


        StoreDataInArrayList();
        StoreTafsirInArrayList();

        AyahAdapter ayahAdapter = new AyahAdapter(this, aAyah ,aTafsir, aText );
        sRecyclerView.setAdapter(ayahAdapter);
        sRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        txtSuaratName.setText(getIntent().getStringExtra("sura"));

        filename=txtSuaratName.getText().toString()+".mp3";


        // file aka bda ba medya playar
        String cPath = Environment.getExternalStorageDirectory().getPath()+"/Music/" +filename;
        Uri url = Uri.parse(cPath);
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioAttributes(new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .build());
        try {
            mediaPlayer.setDataSource(SuratView.this, url);
            mediaPlayer.prepare();

        } catch (IOException e) {
            e.printStackTrace();
        }

        ///////////////////////////////////////////
        runnable = new Runnable() {
            @Override
            public void run() {
          seekBar.setProgress(mediaPlayer.getCurrentPosition());

          handler.postDelayed(this,500);

            }
        };
        // agar file aka habu ba eshbkat agar nya ba download bet
        String path = Environment.getExternalStorageDirectory().getPath()+"/Music/" +filename;
        File file = new File(path);
        if (file.exists()){
            btnDownload.setImageResource(R.drawable.ic_download_done);
            btnPlay.setVisibility(View.VISIBLE);
            seekBar.setVisibility(View.VISIBLE);
        }
        else {
            btnDownload.setImageResource(R.drawable.ic_download);
            btnPlay.setVisibility(View.GONE);
            seekBar.setVisibility(View.GONE);
        }
//////////////////
        // check krdny internet
        ConnectivityManager connectivityManager  = (ConnectivityManager)
                this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo wifi = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        NetworkInfo mobileNetwork = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        // download files
        btnDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // CreateFolder();
                // dawakrdny dasalaty storeg
                if (ContextCompat.checkSelfPermission(SuratView.this,Manifest.permission.READ_EXTERNAL_STORAGE)!=PackageManager.PERMISSION_GRANTED){

                    ActivityCompat.requestPermissions(SuratView.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},100);
                }else{
                        // agar file a ka habet ba dwbara download y  nakat .......
                        String path = Environment.getExternalStorageDirectory().getPath() + "/Music/" + filename;
                        File file = new File(path);
                        if (file.exists()) {
                            txtToast.setText("ئەم فایلە پێشتر دابەزێنراوە..");
                            toast.show();
                        } else {
                            // gar wifi yan mobile data habw ba download dastpebkat
                            if (wifi.isConnected()|| mobileNetwork.isConnected()) {
                                downloadFiles(fileUrl, filename);
                                txtToast.setText("داونلۆد دەستی پێکرد ...");
                                toast.show();
                            }
                            // agar wifi yan mobile data nabww massagek pishan bat
                            else {
                                txtToast.setText("تکایە دلنیابەرەوە لە هەبونی ئینتەرنێنت");
                                toast.show();
                            }
                        }
                }

            }
        });



      btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!mediaPlayer.isPlaying()) {
                    mediaPlayer.start();
                    btnPlay.setImageResource(R.drawable.ic_pause);
                    seekBar.setMax(mediaPlayer.getDuration());
                    handler.postDelayed(runnable, 0);

                }else {
                    mediaPlayer.pause();
                    btnPlay.setImageResource(R.drawable.ic_play);
                }

               }

        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // Check condition
                if(fromUser){
                    // when drag the seek bar
                    // set progress on seek bar
                    mediaPlayer.seekTo(progress);
                }

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());

            }
        });


            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    btnPlay.setImageResource(R.drawable.ic_play);
                    mediaPlayer.seekTo(0);
                }
            });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode==100 && (grantResults.length>0)&&(grantResults[0]==
                PackageManager.PERMISSION_GRANTED)){

        }
    }

    //////////////////////////////////////////////////

    void StoreDataInArrayList(){


            Cursor cursor = mydbClass.readAllAyahData(id);

            if (cursor.getCount() == 0) {
                Toast.makeText(this, "no data ", Toast.LENGTH_SHORT).show();
            } else {
                while (cursor.moveToNext()) {
                    aAyah.add(cursor.getString(1));
                    aText.add(cursor.getString(2));
                }
            }

    }


    void StoreTafsirInArrayList(){

        Cursor cursor = mydbClass.readAllTafsirData(id);
        if (cursor.getCount() == 0){
            Toast.makeText(this, "no data ", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                aTafsir.add(cursor.getString(3));

            }
        }
    }

    ///////////////////////////////////////////

    public void downloadFiles(String url , String outPutFileName){
        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
        request.setTitle(filename);
        request.setDescription("Downloading  " + filename );
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.allowScanningByMediaScanner();
        request.setDestinationInExternalPublicDir(FolderName,outPutFileName);
        DownloadManager downloadManager = (DownloadManager)getSystemService(Context.DOWNLOAD_SERVICE);
        downloadManager.enqueue(request);
    }

    ////////////////////////////////

    public void CreateFolder(){
        File folder = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+File.separator+"Quran mp3 with Surat");
        folder.mkdirs();
        if (folder.exists()){
            Toast.makeText(SuratView.this, "haya", Toast.LENGTH_SHORT).show();
        }
        else {
            folder.mkdirs();
            if (folder.isDirectory()){
                Toast.makeText(this, "create", Toast.LENGTH_SHORT).show();
            }
            else {
                AlertDialog.Builder builder = new AlertDialog.Builder(SuratView.this);
                String sMessage = "Message : failed to create directory"+
                        "\nPath:"+Environment.getExternalStorageDirectory()+
                        "\nmkdirs :"+folder.mkdirs();
                builder.setMessage(sMessage);
                builder.show();

            }

        }

    }





}