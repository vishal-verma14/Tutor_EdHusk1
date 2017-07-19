package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Arts;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Commerce;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Science;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_pkg_academics.Class_12_Arts;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_pkg_academics.Class_12_Commerce;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_pkg_academics.Class_12_Science;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_12_academics_expertise extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_12_academics_expertise);

        Button C_12_ARTS = (Button) findViewById (R.id.C_12_ARTS);
        C_12_ARTS.setOnClickListener (this);

        Button C_12_SCIENCE = (Button) findViewById (R.id.C_12_SCIENCE);
        C_12_SCIENCE.setOnClickListener (this);

        Button C_12_COMMERCE = (Button) findViewById (R.id.C_12_COMMERCE);
        C_12_COMMERCE.setOnClickListener (this);




    }


    @Override
    public void onClick (View view) {

        switch (view.getId ()){

            case R.id.C_12_ARTS :
                startActivity (new Intent (Class_12_academics_expertise.this, Class_12_Arts.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;

            case R.id.C_12_SCIENCE :
                startActivity (new Intent (Class_12_academics_expertise.this, Class_12_Science.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.C_12_COMMERCE :

                startActivity (new Intent (Class_12_academics_expertise.this, Class_12_Commerce.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;




        }
    }


}
