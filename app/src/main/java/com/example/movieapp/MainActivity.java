package com.example.movieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText uName, passWord;
    ImageButton login;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uName = (EditText)findViewById(R.id.loginUsername);
        passWord = (EditText)findViewById(R.id.loginUPassword);
        login = (ImageButton) findViewById(R.id.loginButton);
        progressBar = (ProgressBar)findViewById(R.id.loginProgress);


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = uName.getText().toString();
                String Password = passWord.getText().toString();

                if(TextUtils.isEmpty(Username)){
                    uName.setError("Field can't be empty");
                    return;
                }
                if(TextUtils.isEmpty(Password)){
                    passWord.setError("Field can't be empty");
                }else if(Password.length()<8){
                    passWord.setError("Password is not strong");
                    return;
                }

                validate(Username,Password);

            }
        });



    }
    public void validate(String Username, String Password){

        if((Username.equals("Christy")) && (Password.equals("christy123"))){
            progressBar.setVisibility(View.VISIBLE);
            Toast.makeText(MainActivity.this,"You are successfully logged in",Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }else
        {
            progressBar.setVisibility(View.GONE);
            Toast.makeText(MainActivity.this,"Please check given usenname and password",Toast.LENGTH_SHORT).show();
        }

    }
}
