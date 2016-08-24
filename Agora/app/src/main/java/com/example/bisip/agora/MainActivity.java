package com.example.bisip.agora;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    MediaPlayer ourSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        ourSong = MediaPlayer.create(MainActivity.this, R.raw.seikilosepitaph);
        ourSong.start();
    }

    protected void onPause(){
        super.onPause();
        ourSong.pause();
        //ourSong.release();
    }

    protected void showPlay(View view){
        Intent intent = new Intent(this, PlayActivity.class);
        onPause();
        startActivity(intent);
    }

    protected void showHelp(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        //onPause();
        startActivity(intent);
    }

    protected void showExit(View view){
        finish();
        System.exit(0);
    }
}
