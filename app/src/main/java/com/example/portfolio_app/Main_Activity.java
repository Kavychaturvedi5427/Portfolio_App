package com.example.portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;


import com.airbnb.lottie.LottieAnimationView;

public class Main_Activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);  // this is to make sure that by default app opens in light mode
        setContentView(R.layout.activity_main);

        // sliding anim to move to next activity....
        LottieAnimationView slider_Anim= findViewById(R.id.sliderAnimation);
        Intent section_Intent= new Intent(Main_Activity.this , Section_activity.class);

        // loading anim to be displayed when the slide is clicked....
        LottieAnimationView loading_anim=findViewById(R.id.loadingAnimation);
        slider_Anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slider_Anim.setVisibility(View.GONE);
                // Show and start loading animation
                loading_anim.setVisibility(View.VISIBLE);
                loading_anim.playAnimation();

                // Delay to simulate loading, then start next activity
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(section_Intent);
                        finish(); // optional if you don’t want to come back
                    }
                }, 1000); // 2 second delay, adjust as needed
            }
        });

        // Lottie Animation to exit the app....
        LottieAnimationView exit_anim=findViewById(R.id.exit_anim);
        exit_anim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity(); // closes all activities in the app
                System.exit(0);   // kills the app process
            }
        });

        ImageView avtar_img=findViewById(R.id.avtar);
        Animation bounce_anim= AnimationUtils.loadAnimation(this,R.anim.bounce_anim);
        avtar_img.setAnimation(bounce_anim);

        TextView welcome_txt=findViewById(R.id.welcome);
        Animation fade_in_anim= AnimationUtils.loadAnimation(this,R.anim.fade_in_anim);
        welcome_txt.setAnimation(fade_in_anim);

        getSupportActionBar().setTitle("K's Portfolio");

    }
}