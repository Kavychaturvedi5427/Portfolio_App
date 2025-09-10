package com.example.portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class AboutSection_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_about_section);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Lottie animations
        LottieAnimationView back_slider = findViewById(R.id.sliderAnimation);
        LottieAnimationView loading_anim = findViewById(R.id.loadingAnimation);

        // Cards
        CardView AboutCard = findViewById(R.id.about_Card);
        CardView goals = findViewById(R.id.goalscard);
        CardView dev = findViewById(R.id.Dev_Card);

        // Images
        ImageView selfImg = findViewById(R.id.About_photo);
        ImageView aboutme = findViewById(R.id.aboutme);
        ImageView goal = findViewById(R.id.goals);
        ImageView Deve = findViewById(R.id.dev);

        Handler handler = new Handler();

        // Self image (after 0.5s)
        handler.postDelayed(() -> {
            selfImg.setVisibility(View.VISIBLE);
            selfImg.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_anim));
        }, 500);

        // About me image (also after 0.5s as in your code)
        handler.postDelayed(() -> {
            aboutme.setVisibility(View.VISIBLE);
            aboutme.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_anim));
        }, 500);

        // About card (after 4s)
        handler.postDelayed(() -> {
            AboutCard.setVisibility(View.VISIBLE);
            AboutCard.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce_anim));
        }, 4000);

        // Goals image (after 0.5s as in your code)
        handler.postDelayed(() -> {
            goal.setVisibility(View.VISIBLE);
            goal.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_anim));
        }, 500);

        // Goals card (after 8s)
        handler.postDelayed(() -> {
            goals.setVisibility(View.VISIBLE);
            goals.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce_anim));
        }, 8000);

        // Developer image (after 0.5s as in your code)
        handler.postDelayed(() -> {
            Deve.setVisibility(View.VISIBLE);
            Deve.startAnimation(AnimationUtils.loadAnimation(this, R.anim.slide_anim));
        }, 500);

        // Developer card (after 12s)
        handler.postDelayed(() -> {
            dev.setVisibility(View.VISIBLE);
            dev.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bounce_anim));
        }, 12000);

        // Back button with loading animation
        back_slider.setOnClickListener(v -> {
            Intent backT0Section = new Intent(AboutSection_activity.this, Section_activity.class);
            back_slider.setVisibility(View.GONE);
            loading_anim.setVisibility(View.VISIBLE);
            loading_anim.playAnimation();
            v.postDelayed(() -> startActivity(backT0Section), 500);
        });

        // ActionBar title
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("About");
        }
    }
}
