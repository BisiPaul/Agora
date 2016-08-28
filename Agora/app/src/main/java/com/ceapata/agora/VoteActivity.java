package com.ceapata.agora;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VoteActivity extends AppCompatActivity {

    Handler handler;
    TextView mSwitcher;
    Animation in;
    Animation out;
    int fadeCount;

    Button likeButton;
    Button dislikeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vote);

        TextView txTitle = (TextView) findViewById(R.id.textViewTitle);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/Caesar.ttf");
        txTitle.setTypeface(custom_font);

        getWindow().getDecorView().setBackgroundColor(Color.WHITE);

        final TextView timer = (TextView) findViewById(R.id.timer);
        timer.setTypeface(custom_font);

        new CountDownTimer(12000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining to vote : " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer.setTextSize(25);
                timer.setText("done!");

                likeButton.setClickable(false);
                dislikeButton.setClickable(false);

                showMain();
            }
        }.start();

        //changing buttons on click
        likeButton = (Button) findViewById(R.id.likebutton);
        likeButton.setOnClickListener(likeButtonHandler);

        dislikeButton = (Button) findViewById(R.id.dislikebutton);
        dislikeButton.setOnClickListener(dislikeButtonHandler);

        //animated textView
        fadeCount = 0;
        handler = new Handler();
        mSwitcher = txTitle;

        in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(2000);

        out = new AlphaAnimation(1.0f, 0.0f);
        out.setDuration(2000);
        out.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                fadeCount++;
                if (fadeCount == 1) {
                    RelativeLayout layout = (RelativeLayout) findViewById(R.id.linearlayout);
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)layout.getLayoutParams();
                    params.setMargins(0, 100, 0, 0);
                    layout.setLayoutParams(params);

                    mSwitcher.setText("What do you think about the topic?");
                    mSwitcher.setTextSize(40);
                }

                mSwitcher.startAnimation(in);
            }
            @Override
            public void onAnimationRepeat(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }
        });

        mSwitcher.setText("Let's vote!");
        mSwitcher.startAnimation(in);
        handler.postDelayed(mFadeOut, 2000);
    }

    private Runnable mFadeOut =new Runnable(){

        @Override
        public void run() {
            mSwitcher.startAnimation(out);

        }
    };

    View.OnClickListener likeButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            likeButton.setBackgroundResource(R.drawable.likebuttonclick);
            dislikeButton.setClickable(false);
        }
    };

    View.OnClickListener dislikeButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {
            dislikeButton.setBackgroundResource(R.drawable.dislikebuttonclick);
            likeButton.setClickable(false);
        }
    };

    private void showMain(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
    }
}

