package com.example.portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
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



        ImageView selfImg= findViewById(R.id.About_photo);
        Animation trans = AnimationUtils.loadAnimation(this,R.anim.slide_anim);

        TextView aboutTitle = findViewById(R.id.aboutTitle);
        Animation bounceAnim = AnimationUtils.loadAnimation(this, R.anim.bounce_anim);
        aboutTitle.startAnimation(bounceAnim);


        LottieAnimationView back_slider=findViewById(R.id.sliderAnimation);
        LottieAnimationView loading_anim=findViewById(R.id.loadingAnimation);
        back_slider.setOnClickListener(new View.OnClickListener() {
            Intent backT0Section=new Intent(AboutSection_activity.this,Section_activity.class);
            @Override
            public void onClick(View v) {
                loading_anim.setVisibility(View.VISIBLE);
                loading_anim.playAnimation();
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(backT0Section);
                    }
                },500);
            }
        });
        getSupportActionBar().setTitle("About");

    }
}