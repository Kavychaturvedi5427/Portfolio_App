package com.example.portfolio_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class Section_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_section);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        LottieAnimationView back_slider=findViewById(R.id.sliderAnimation);
        LottieAnimationView loading_anim=findViewById(R.id.loadingAnimation);

        CardView about=findViewById(R.id.about_card);
        CardView skills=findViewById(R.id.skills_card);
        CardView projects=findViewById(R.id.project_card);
        CardView contact=findViewById(R.id.contact_card);

        // OnClick activity for back button ....
        back_slider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_toMain=new Intent(Section_activity.this,Main_Activity.class);
                startActivity(back_toMain);
            }
        });

        // OnClick activity for about page...
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent about_Intent=new Intent(Section_activity.this,AboutSection_activity.class);
                startActivity(about_Intent);
            }
        });

        // OnClick activity for skills page....
        skills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent skills_intent=new Intent(Section_activity.this,Skills_activity.class);
                startActivity(skills_intent);
            }
        });

        // OnClick activity for projects page....
        projects.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent project_intent =new Intent(Section_activity.this, Projects_activity.class);
                startActivity(project_intent);
            }
        });

        // OnClick activity for contact page....
        contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent contact_intent=new Intent(Section_activity.this,Contact_activity.class);
                startActivity(contact_intent);
            }
        });

        // loading animation for back_slider....
        back_slider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                back_slider.setVisibility(View.GONE);
                loading_anim.setVisibility(View.VISIBLE);
                loading_anim.playAnimation();
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent back_toMain=new Intent(Section_activity.this,Main_Activity.class);
                        startActivity(back_toMain);
                    }
                },500);
            }
        });


        getSupportActionBar().setTitle("Content");
    }
}
