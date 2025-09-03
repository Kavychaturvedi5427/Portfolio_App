package com.example.portfolio_app;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Skills_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_skills);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Java animation (your existing one)
        LottieAnimationView javaanim = findViewById(R.id.javaAnim);
        javaanim.playAnimation();
        javaanim.addAnimatorListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                javaanim.setProgress(1f);
            }
        });

        // Slider button + Loader
        LottieAnimationView slider = findViewById(R.id.slider);
        LottieAnimationView loading = findViewById(R.id.loading);

        slider.setOnClickListener(v -> {
            // Hide slider
            slider.setVisibility(View.GONE);

            // Show loading animation
            loading.setVisibility(View.VISIBLE);
            loading.playAnimation();

            // Wait for loading animation to finish, then move
            loading.addAnimatorListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    Intent intent = new Intent(Skills_activity.this, Section_activity.class);
                    startActivity(intent);
                }
            });
        });

        getSupportActionBar().setTitle("K's Portfolio");
    }
}
