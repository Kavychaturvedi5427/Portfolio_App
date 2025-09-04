package com.example.portfolio_app;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.airbnb.lottie.LottieAnimationView;

public class Contact_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_contact);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ImageView insta=findViewById(R.id.instagram);
        ImageView linkedIn=findViewById(R.id.linked);
        ImageView github=findViewById(R.id.git);
        ImageView tweet=findViewById(R.id.x);


        LottieAnimationView slider=findViewById(R.id.slider);

        // adding insta url....
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String insta_url="https://www.instagram.com/kavy___17/";
                        Intent insta_intent=new Intent(Intent.ACTION_VIEW, Uri.parse(insta_url));
                        startActivity(insta_intent);

                    }
                }, 500);
            }
        });

        // addind linkedin url....
        linkedIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String linkedIn_url = "https://www.linkedin.com/in/kavya-chaturvedi-1a181932a/";
                        Intent Linked_inten=new Intent(Intent.ACTION_VIEW, Uri.parse(linkedIn_url));
                        startActivity(Linked_inten);

                    }
                }, 500);
            }
        });

        // adding gitHub url....
        github.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String git_url="https://github.com/Kavychaturvedi5427";
                        Intent git_intent=new Intent(Intent.ACTION_VIEW, Uri.parse(git_url));
                        startActivity(git_intent);
                    }
                },500);
            }
        });

        // adding twitter url....
        tweet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        String tweet_url="https://x.com/kavychaturvedi";
                        Intent tweet_intent=new Intent(Intent.ACTION_VIEW, Uri.parse(tweet_url));
                        startActivity(tweet_intent);

                    }
                },500);
            }
        });

        // slider back to section....
        slider.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent back_toSection=new Intent(Contact_activity.this,Section_activity.class);
                startActivity(back_toSection);
            }
        });

        // Openning calling app functionality....

        LinearLayout calling= findViewById(R.id.phone);
        calling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent call_App=new Intent(Intent.ACTION_DIAL);
                call_App.setData(Uri.parse("tel:"+"+917355968041"));
                startActivity(call_App);
            }
        });

        //  mail functionality....
        LinearLayout email=findViewById(R.id.email);
        email.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String[] mails={"ss3207428@gmail.com","2k23.cscys2311172@gmail.com"};
                Intent send_mail=new Intent(Intent.ACTION_SENDTO);
                send_mail.setData(Uri.parse("mailto:"));
                send_mail.putExtra(Intent.EXTRA_EMAIL,mails);
                startActivity(send_mail);
            }
        });

        // Map functionality...
        LinearLayout map=findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String address="V-21 Yashoda Nagar, Near Namak Factory Chauraha, Kanpur, Uttar Pradesh";
                Uri mapuri=Uri.parse("geo:0,0?q="+Uri.encode(address));
                Intent map_intent=new Intent(Intent.ACTION_VIEW,mapuri);
                map_intent.setPackage("com.google.android.apps.maps");
                startActivity(map_intent);
            }
        });

        getSupportActionBar().setTitle("Contact Info");
    }
}
