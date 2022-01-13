package com.dya.surat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Zhyan_View extends AppCompatActivity {

    String getItem;
    TextView FirstView,FullView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhyan__view);

        FirstView = (TextView)findViewById(R.id.FirsView);
        FullView = (TextView)findViewById(R.id.fullView);

        getData();

    }

    public void getData(){
        getItem =getIntent().getStringExtra("fileName");
        if (getItem.equals("ناوی تەواوی")){

           FullView.setText(getResources().getString(R.string.FullName));
           FirstView.setText(getResources().getString(R.string.FName));

        }
        else if (getItem.equals("ڕەچەڵەکی")){

            FullView.setText(getResources().getString(R.string.FullRachalak));
            FirstView.setText(getResources().getString(R.string.FirstRachalak));
        }
        else if (getItem.equals("پشت و نەسەبی پێغەمبەر(ص)")){

            FullView.setText(getResources().getString(R.string.FullNasab));
            FirstView.setText(getResources().getString(R.string.FirstNasab));

        }
        else if (getItem.equals("ژیانی لە پێشبانگەواز")){

            FullView.setText(getResources().getString(R.string.FullZhyany));
            FirstView.setText(getResources().getString(R.string.FirstZhyany));

        }
        else if (getItem.equals("ساڵی فیل")){

            FullView.setText(getResources().getString(R.string.FullFil));
            FirstView.setText(getResources().getString(R.string.FirstFil));

        }
        else if (getItem.equals("خواپەرستی پێغمبەر(ص) لە ئەشکەوتی حراء")){

            FullView.setText(getResources().getString(R.string.FullHara));
            FirstView.setText(getResources().getString(R.string.FirstHara));

        }
        else if (getItem.equals("ژیانی کۆمەڵایەتی لە شاری مەککە")){

            FullView.setText(getResources().getString(R.string.FullKomalayaty));
            FirstView.setText(getResources().getString(R.string.FirstKomalayty));

        }
        else  if (getItem.equals("ژنهێنانی")){

            FullView.setText(getResources().getString(R.string.FullZhnhenan));
            FirstView.setText(getResources().getString(R.string.FirstZhnhenan));

        }
        else if (getItem.equals("بەڵگەو نیشانەکانی پێغەمبەرایەتی")){

            FullView.setText(getResources().getString(R.string.FullNishana));
            FirstView.setText(getResources().getString(R.string.FirstNishana));
        }
        else if (getItem.equals("بانگەوازی")){

            FullView.setText(getResources().getString(R.string.FullBangawzy));
            FirstView.setText(getResources().getString(R.string.FirstBangawazy));

        }
        else if (getItem.equals("سەرەتای بانگەواز")){

            FullView.setText(getResources().getString(R.string.FullSerta));
            FirstView.setText(getResources().getString(R.string.FirstSerta));

        }
        else if (getItem.equals("ئەوانەی بەدەم بانگەوازی ئیسلامەوەهاتن")){

            FullView.setText(getResources().getString(R.string.FullBadam));
            FirstView.setText(getResources().getString(R.string.FirstBadam));

        }

        else if (getItem.equals("کۆچکردن")){

            FullView.setText(getResources().getString(R.string.FullKoChKrdn));
            FirstView.setText(getResources().getString(R.string.FirstKochKrdn));

        }
        else if (getItem.equals("مەدینە پێش کۆجکردن")){

            FullView.setText(getResources().getString(R.string.FullMadina));
            FirstView.setText(getResources().getString(R.string.FirstMadina
            ));
        }
        else if (getItem.equals("کۆچی پێغەمبەر و وەرچەرخانێکی مێژوویی")){

            FullView.setText(getResources().getString(R.string.FullMezhw));
            FirstView.setText(getResources().getString(R.string.FirstMezhw));

        }
        else if (getItem.equals("گەیشتنی پێغمبەر (ص) بە مەدینە")){

            FullView.setText(getResources().getString(R.string.FullGaishtn));
            FirstView.setText(getResources().getString(R.string.FirstGaishtn));

        } else if (getItem.equals("دامەزراندنی دەوڵەتی ئیسلامی")){

            FullView.setText(getResources().getString(R.string.FullDamazrandn));
            FirstView.setText(getResources().getString(R.string.FirstDamazrandn));

        }
        else if (getItem.equals("دروستکردنی مزگەوتی پێغەمبەر(ص)")){

            FullView.setText(getResources().getString(R.string.FullDrustKrdn));
            FirstView.setText(getResources().getString(R.string.FirstDrustKrdn));

        }
        else if (getItem.equals("برایەتی نێوان کۆچکەران و پشتیوانان")){

            FullView.setText(getResources().getString(R.string.FUllBrayaty));
            FirstView.setText(getResources().getString(R.string.FirstBrayaty));

        }
        else if (getItem.equals("دەرئەنجامەکانی کۆچ")){

            FullView.setText(getResources().getString(R.string.FullDarAnjam));
            FirstView.setText(getResources().getString(R.string.FirstDarAnjam));

        }
        else if (getItem.equals("کۆچی دوای")){

            FullView.setText(getResources().getString(R.string.FullKochyDway));
            FirstView.setText(getResources().getString(R.string.FirstKochyDway));

        }
        else if (getItem.equals("پاش مردنی")){

            FullView.setText(getResources().getString(R.string.FullPash));
            FirstView.setText(getResources().getString(R.string.FirstPash));

        }

        else if (getItem.equals("٣٠ فەرمودەی پێغمبەری خودا(ص)")){

            FullView.setText(getResources().getString(R.string.FullFarmuda));
            FirstView.setText(getResources().getString(R.string.FirsFarmuda));

        }
        else if (getItem.equals("ئیسرا و میعراج")){
            FullView.setText(getResources().getString(R.string.FullEsra));
            FirstView.setText(getResources().getString(R.string.FirstEsra));

        }

    }
}