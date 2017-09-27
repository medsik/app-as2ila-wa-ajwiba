package com.is2all.as2ila_jawab;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class addPoint extends AppCompatActivity {

    int point=3 , site = 0, share = 0 ;
    Button  btn_site , btn_you, btn_fac, btn_apps , btn_share;
    boolean enable_you = true , enable_fac = true , enable_apps = true ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_point);

        btn_site = (Button)findViewById(R.id.site);
        btn_you = (Button)findViewById(R.id.you);
        btn_fac = (Button)findViewById(R.id.fac);
        btn_apps = (Button)findViewById(R.id.apps);
        btn_share = (Button)findViewById(R.id.share);

        LoadSating();

        if (site >= 5){
            btn_site.setEnabled(false);
        }
        if (share >= 5){
            btn_share.setEnabled(false);
        }


    }

    public void site(View view) {

        MediaPlayer mediasite = MediaPlayer.create(this,R.raw.sound_click);
        mediasite.start();

        site++;
        if (site >= 5){
            btn_site.setEnabled(false);
        }
            Uri uri = Uri.parse("http://www.is2all.com");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);

            point = point+1;
            SaveSating();
        Toast.makeText(this, "عدد زيارات الموقع: "+site+"\n"+"الحد الأقصى: 5", Toast.LENGTH_SHORT).show();
    }

    public void you(View view) {
        MediaPlayer mediayou = MediaPlayer.create(this,R.raw.sound_click);
        mediayou.start();

        Uri uri = Uri.parse("https://www.youtube.com/user/med9292/videos");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        point = point+3;
        enable_you = false;
        btn_you.setEnabled(false);
        SaveSating();
    }

    public void fac(View view) {
        MediaPlayer mediafac = MediaPlayer.create(this,R.raw.sound_click);
        mediafac.start();

        Uri uri = Uri.parse("https://www.facebook.com/tari9at9nya");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        point = point+3;
        enable_fac = false;
        btn_fac.setEnabled(false);
        SaveSating();
    }

    public void apps(View view) {
        MediaPlayer mediaapps = MediaPlayer.create(this,R.raw.sound_click);
        mediaapps.start();

        Uri uri = Uri.parse("https://play.google.com/store/search?q=is2all");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);

        point = point+3;
        enable_apps=false;
        btn_apps.setEnabled(false);
        SaveSating();
    }

    public void share(View view) {
        MediaPlayer mediashare = MediaPlayer.create(this,R.raw.sound_click);
        mediashare.start();

        share++;
        if (share >= 5){
            btn_share.setEnabled(false);
        }
            Intent myintent = new Intent(Intent.ACTION_SEND);
            myintent.setType("text/plain");
            String body = "شارك البرنامج مع أصدقائك للحصول على 5 نقط وابدأ اللعبة : \n" + "\n" +
                    "https://play.google.com/store/apps/com.is2all.as2ila_jawab";
            String sub = "5 نقط مقابل كل مشاركة للتطبيق \n";
            myintent.putExtra(Intent.EXTRA_SUBJECT, sub);
            myintent.putExtra(Intent.EXTRA_TEXT, body);
            startActivity(Intent.createChooser(myintent, "مشاركة البرنامج"));


        point = point+5 ;
            SaveSating();
        Toast.makeText(this, "عدد المشاركة: "+share+"\n"+"الحد الأقصى: 5", Toast.LENGTH_SHORT).show();

    }

    ////////////////////////// "حفظ التغييرات بالبرنامج" //////////////////////////////////
    public void SaveSating() {
        SharedPreferences savechange = this.getSharedPreferences("savechange", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = savechange.edit();

        editor.putInt("Point",point);
        editor.putInt("site",site);
        editor.putInt("share",share);

        editor.putBoolean("you" , enable_you);
        editor.putBoolean("fac" , enable_fac);
        editor.putBoolean("apps" ,enable_apps);

        editor.apply();
    }

    ////////////////////////// "جلب التغييرات السابقة للبرنامج"//////////////////////////////////
    public void LoadSating() {
        SharedPreferences savechange = this.getSharedPreferences("savechange", Context.MODE_PRIVATE);

        int Point = savechange.getInt("Point",point);
        point = Point;
        site = savechange.getInt("site",site);
        share = savechange.getInt("share",share);

        enable_you = savechange.getBoolean("you" , enable_you);
        btn_you.setEnabled(enable_you);

        enable_fac = savechange.getBoolean("fac" , enable_fac);
        btn_fac.setEnabled(enable_fac);

        enable_apps = savechange.getBoolean("apps" ,enable_apps);
        btn_apps.setEnabled(enable_apps);

    }
}
