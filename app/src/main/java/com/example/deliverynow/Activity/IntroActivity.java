package com.example.deliverynow.Activity;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

import com.example.deliverynow.R;

public class IntroActivity extends AppCompatActivity {

    private ConstraintLayout startbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setLocale("es");

        setContentView(R.layout.activity_intro);

        startbtn = findViewById(R.id.startbtn);

        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            }
        });
    }

    private void setLocale(String languageCode) {
        Locale locale = new Locale(languageCode);
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.setLocale(locale);
        getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
    }
}
