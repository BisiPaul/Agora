package com.ceapata.agora;
import android.graphics.Color;
import android.media.AudioManager;
import android.media.MediaPlayer;
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
        ourSong.setLooping(true);
        ourSong.start();
    }

    @Override
    protected void onPause(){
        super.onPause();
        ourSong.stop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        ourSong = MediaPlayer.create(MainActivity.this, R.raw.seikilosepitaph);
        ourSong.setLooping(true);
        ourSong.start();
    }

    public void showPlay(View view){
        Intent intent = new Intent(this, PlayActivity.class);
        ourSong.stop();
        startActivity(intent);
    }

    public void showHelp(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        ourSong.stop();
        startActivity(intent);
    }

    public void showExit(View view){
        finish();
        System.exit(0);
    }
}
