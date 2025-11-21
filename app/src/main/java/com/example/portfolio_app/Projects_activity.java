package com.example.portfolio_app;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.Lottie;
import com.airbnb.lottie.LottieAnimationView;

public class Projects_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

        setContentView(R.layout.activity_projects);

        // Handle insets safely
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return WindowInsetsCompat.CONSUMED;
            });
        }

        // GitHub project links
        ImageView Project1 = findViewById(R.id.gitLink1);
        ImageView Project2 = findViewById(R.id.gitLink2);
        ImageView Project3 = findViewById(R.id.gitLink3);

        LottieAnimationView sliderAnimation = findViewById(R.id.sliderAnimation);
        LottieAnimationView loadingAnimation =findViewById(R.id.loading);

        Project1.setOnClickListener(v -> {
            String gitURL = "https://github.com/ankit-prabhavak/FaceRecognitionUnifiedInterfaceTechnoloy.git";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(gitURL)));
        });

        Project2.setOnClickListener(v -> {
            String gitURL = "https://github.com/ankit-prabhavak/TomatoLeafAI.git";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(gitURL)));
        });

        Project3.setOnClickListener(v -> {
            String gitURL = "https://github.com/Kavychaturvedi5427/Portfolio_App.git";
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(gitURL)));
        });

       sliderAnimation.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               sliderAnimation.setVisibility(View.GONE);
               loadingAnimation.setVisibility(View.VISIBLE);
               loadingAnimation.playAnimation();
               Intent intent = new Intent(Projects_activity.this, Section_activity.class);
               v.postDelayed(new Runnable() {
                   @Override
                   public void run() {
                       startActivity(intent);
                   }
               },500);
           }
       });
       
        // Set action bar title
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setTitle("Projects");
//        }
    }
}
