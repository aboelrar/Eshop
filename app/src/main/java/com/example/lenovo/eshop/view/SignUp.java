package com.example.lenovo.eshop.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.lenovo.eshop.R;
import com.example.lenovo.eshop.interfaces.contract;
import com.example.lenovo.eshop.interfaces.signupinterface;
import com.example.lenovo.eshop.presenter.presenterCountry;
import com.example.lenovo.eshop.presenter.presenterGender;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity implements signupinterface.interfaces.View  {
    Spinner Country,Gender;
    presenterCountry presenterCountry;
    ImageView signup,back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        presenterCountry=new presenterCountry(this);
        presenterCountry.getCountryData();
        presenterCountry.getGenderData();



        }

    @Override
    public void element() {
        Country=(Spinner)findViewById(R.id.country);
        Gender=(Spinner)findViewById(R.id.gender);
    }

    @Override
    public void setviewCountrydata(ArrayList data) {
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
        Country.setAdapter(spinnerArrayAdapter);

    }

    @Override
    public void setviewGenderdata(ArrayList data) {
        ArrayAdapter spinnerArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_spinner_dropdown_item,
                data);
        Gender.setAdapter(spinnerArrayAdapter);
    }

public void back()
{
    ImageView back=(ImageView)findViewById(R.id.back);
    back.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    });
}
}
