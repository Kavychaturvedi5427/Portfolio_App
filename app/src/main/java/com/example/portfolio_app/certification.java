package com.example.portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.airbnb.lottie.LottieAnimationView;

public class certification extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification);

        LottieAnimationView slider = findViewById(R.id.slider);
        LottieAnimationView back = findViewById(R.id.back);

        slider.setOnClickListener(v->{
            slider.setVisibility(View.GONE);
            back.setVisibility(View.VISIBLE);
            v.postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent intent = new Intent(getApplicationContext(),Section_activity.class);
                    startActivity(intent);

                }
            },1000);
        });

    }
}
