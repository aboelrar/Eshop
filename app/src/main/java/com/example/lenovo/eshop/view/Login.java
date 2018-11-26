package com.example.lenovo.eshop.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.eshop.R;

public class Login extends AppCompatActivity {
TextView GoToSignUp;
ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        GoToSignUp();
        back();



    }
    public void GoToSignUp()
    {
        GoToSignUp=(TextView)findViewById(R.id.gotosignup);
        GoToSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
startActivity(new Intent(Login.this,SignUp.class));
            }
        });
    }
    public void back()
    {
        back=(ImageView)findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
