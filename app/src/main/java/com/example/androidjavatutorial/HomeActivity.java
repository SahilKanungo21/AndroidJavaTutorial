package com.example.androidjavatutorial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs",
                Context.MODE_PRIVATE);
        String userName = sharedPreferences.getString("username", "");
        Toast.makeText(getApplicationContext(), "Welcome " + userName, Toast.LENGTH_SHORT).show();

        CardView exit = findViewById(R.id.cardExit);
        exit.setOnClickListener(view -> {
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.clear();
            editor.apply();
            startActivity(new Intent(HomeActivity.this, LoginActivity.class));
        });

        CardView findDoctor = findViewById(R.id.cardFindDoctor);
        findDoctor.setOnClickListener(view ->
                startActivity(new Intent(HomeActivity.this, FindDoctor.class))
        );

        CardView buyMedicine = findViewById(R.id.cardMedicine);
        buyMedicine.setOnClickListener(view -> {
            Intent medicineIntent = new Intent(HomeActivity.this,BuyMedicine.class);
            startActivity(medicineIntent);
        });

        CardView labTest = findViewById(R.id.cardLabTest);
        labTest.setOnClickListener(view -> {
            Intent labTestIntent = new Intent(HomeActivity.this, LabTest.class);
            startActivity(labTestIntent);
        });


    }
}