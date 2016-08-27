package com.example.bisip.agora;

import android.graphics.Color;
import android.graphics.Typeface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        TextView tx = (TextView) findViewById(R.id.textView);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Caesar.ttf");
        tx.setTypeface(custom_font);

        ourSong = MediaPlayer.create(HelpActivity.this, R.raw.seikilosepitaph);
        ourSong.setLooping(true);
        ourSong.start();
    }

    public void onBackPressed() {
        ourSong.stop();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
