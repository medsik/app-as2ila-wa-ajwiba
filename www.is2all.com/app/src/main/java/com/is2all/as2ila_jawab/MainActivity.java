package com.is2all.as2ila_jawab;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //////////////admob banner///////
        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    public void start(View view) {
        MediaPlayer media1 = MediaPlayer.create(this,R.raw.sound_click);
        media1.start();

        Intent windows_asila = new Intent(this, windows_asila.class);
        windows_asila.putExtra("rtn",false);
        startActivity(windows_asila);
    }

    public void returen(View view) {
        MediaPlayer media2 = MediaPlayer.create(this,R.raw.sound_click);
        media2.start();

        Intent windows_asila = new Intent(this, windows_asila.class);
        windows_asila.putExtra("rtn",true);
        startActivity(windows_asila);
    }

    public void addpoint(View view) {
        MediaPlayer media3 = MediaPlayer.create(this,R.raw.sound_click);
        media3.start();

        Intent addPoin = new Intent(this, addPoint.class);
        startActivity(addPoin);
    }

    public void Share(View view) {
        MediaPlayer media4 = MediaPlayer.create(this,R.raw.sound_click);
        media4.start();

        Intent myintent = new Intent(Intent.ACTION_SEND);
        myintent.setType("text/plain");
        String body = "تطبيق نسألك وانت تجيب رائع  \n" + "\n" +
                "https://play.google.com/store/apps/com.is2all.as2ila_jawab";
        String sub = "تطبيق نسالك وانت تجيب \n";
        myintent.putExtra(Intent.EXTRA_SUBJECT, sub);
        myintent.putExtra(Intent.EXTRA_TEXT, body);
        startActivity(Intent.createChooser(myintent, "مشاركة البرنامج"));
    }

    public void about(View view) {
        MediaPlayer media5 = MediaPlayer.create(this,R.raw.sound_click);
        media5.start();

        AlertDialog.Builder builder=new AlertDialog.Builder(this) ;
        builder.setTitle("حول البرنامج");
        builder.setMessage("إصدار البرنامج v1.0   \n  التطبيق بالكامل من إنجاز محمد الحيرش    \n " +
                "إذا كنت تريد اي استفسار أو تغييرات بالتطبيق ، أو تريد مراسلتي فلا تتردد في الاتصال بي عن طريق البريد الالكتروني: \n " +
                "medsikb@gmail.com");
        builder.setPositiveButton("موافق", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
            }
        });
        builder.show();
    }
}
