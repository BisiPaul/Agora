package com.ceapata.agora;

import android.graphics.Color;
import android.graphics.Typeface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.Gravity;
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

        TextView tx_title = (TextView) findViewById(R.id.textView_title);
        Typeface custom_font_title = Typeface.createFromAsset(getAssets(), "fonts/Caesar.ttf");
        tx_title.setTypeface(custom_font_title);

        TextView tx_body = (TextView) findViewById(R.id.textView_body);
        Typeface custom_font_body = Typeface.createFromAsset(getAssets(), "fonts/Caesar.ttf");
        tx_body.setTypeface(custom_font_body);
        tx_body.setGravity(Gravity.CENTER); //Aligns the text vertically and horizontally

        tx_body.setMovementMethod(new ScrollingMovementMethod());

        ourSong = MediaPlayer.create(HelpActivity.this, R.raw.seikilosepitaph);
        ourSong.setLooping(true);
        ourSong.start();
    }

    public void onBackPressed() {
        ourSong.stop();
        super.onBackPressed();
    }
}
