package com.example.deliverynow.Activity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout; // Agrega esta importación

import com.example.deliverynow.R;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Encuentra el LinearLayout con ID home_btn1
        LinearLayout homeBtn = findViewById(R.id.home_btn1);

        // Establece un clic en el LinearLayout para navegar a MainActivity
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Configura la intención para abrir la actividad MainActivity
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);

                // Inicia la actividad MainActivity
                startActivity(intent);
            }
        });
    }
}
