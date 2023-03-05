package com.example.androidjavatutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText editUserName , editUserPassword;
    Button loginBtn;
    TextView signIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editUserName = findViewById(R.id.editTextLogInUserName);
        editUserPassword = findViewById(R.id.editTextLogInPassword);
        loginBtn = findViewById(R.id.buttonLogin);
        signIn = findViewById(R.id.textViewNewUser);

        loginBtn.setOnClickListener(view -> {
            String userName = editUserName.getText().toString();
            String password = editUserPassword.getText().toString();

            if(userName.isEmpty() || password.isEmpty()){
                Toast.makeText(getApplicationContext(),"Please Fill all details",Toast.LENGTH_SHORT)
                        .show();
            }else {
                Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT)
                        .show();
            }
        });

        signIn.setOnClickListener(view -> {
            startActivity(new Intent(LoginActivity.this,RegisterActivity.class));
        });
    }
}