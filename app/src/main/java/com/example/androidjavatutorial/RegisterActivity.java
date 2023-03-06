package com.example.androidjavatutorial;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edUserName , edUserEmail, edUserPassword , edConfirmPassword;
    Button registerBtn;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUserName = findViewById(R.id.editTextSignInUserName);
        edUserEmail = findViewById(R.id.editTextFullName);
        edUserPassword = findViewById(R.id.editTextPassword);
        edConfirmPassword = findViewById(R.id.editTextConfirmPassword);

        registerBtn = findViewById(R.id.buttonRegister);

        tv = findViewById(R.id.textViewAlreadyUser);

        registerBtn.setOnClickListener(view -> {
            String userName = edUserName.getText().toString();
            String userEmail = edUserEmail.getText().toString();
            String userPassword = edUserPassword.getText().toString();
            String userConfirmPassword = edConfirmPassword.getText().toString();
            DatabaseConnectivity db = new DatabaseConnectivity(getApplicationContext(),
                    "healthcare",null,1);


            if(!userName.isEmpty() && !userEmail.isEmpty() &&
                    !userPassword.isEmpty() && !userConfirmPassword.isEmpty()) {
                if(userPassword.equals(userConfirmPassword)){
                    db.register(userName,userEmail,userPassword);
                    Toast.makeText(getApplicationContext(),"Successfully Register",
                            Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
                } else{
                    Toast.makeText(getApplicationContext(),
                            "Password does not match  Try Again !!",Toast.LENGTH_SHORT).show();
                }
            }
            else{
                Toast.makeText(getApplicationContext(),"Fill all the details",
                        Toast.LENGTH_SHORT).show();
            }
        });

        tv.setOnClickListener(view -> startActivity(new Intent(RegisterActivity.this,LoginActivity.class)));


    }
}