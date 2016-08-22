package com.example.bisip.agora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void showPlay(View view){
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    protected void showHelp(View view){
        Intent intent = new Intent(this, HelpActivity.class);
        startActivity(intent);
    }

    protected void showExit(View view){
        finish();
        System.exit(0);
    }
}
