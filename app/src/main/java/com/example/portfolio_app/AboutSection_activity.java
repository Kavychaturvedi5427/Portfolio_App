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
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.Lottie;
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
        Animation Bounce=AnimationUtils.loadAnimation(this,R.anim.bounce_anim);

        LottieAnimationView ai=findViewById(R.id.ai);
        LottieAnimationView random =findViewById(R.id.random);

        CardView AboutCard= findViewById(R.id.about_Card);
        CardView goals= findViewById(R.id.goalscard);
        CardView dev= findViewById(R.id.Dev_Card);

        selfImg.startAnimation(trans);
        AboutCard.startAnimation(Bounce);
        goals.startAnimation(Bounce);
        dev.startAnimation(Bounce);
        ai.startAnimation(Bounce);
        random.startAnimation(Bounce);

        LottieAnimationView back_slider=findViewById(R.id.sliderAnimation);
        LottieAnimationView loading_anim=findViewById(R.id.loadingAnimation);
        back_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backT0Section=new Intent(AboutSection_activity.this,Section_activity.class);
                back_slider.setVisibility(View.GONE);
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