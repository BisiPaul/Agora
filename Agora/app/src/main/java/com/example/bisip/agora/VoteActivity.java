package com.example.bisip.agora;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        TextView tx = (TextView)findViewById(R.id.textView2);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/Caesar.ttf");
        tx.setTypeface(custom_font);
        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

    }


}
