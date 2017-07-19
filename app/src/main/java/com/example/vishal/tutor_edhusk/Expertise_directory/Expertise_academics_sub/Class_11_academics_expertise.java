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
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Arts;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Commerce;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics.Class_11_Science;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_11_academics_expertise extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_11_academics_expertise);

        Button C_11_ARTS = (Button) findViewById (R.id.C_11_ARTS);
        C_11_ARTS.setOnClickListener (this);

        Button C_11_SCIENCE = (Button) findViewById (R.id.C_11_SCIENCE);
        C_11_SCIENCE.setOnClickListener (this);

        Button C_11_COMMERCE = (Button) findViewById (R.id.C_11_COMMERCE);
        C_11_COMMERCE.setOnClickListener (this);



    }


        @Override
        public void onClick (View view) {

            switch (view.getId ()){

                case R.id.C_11_ARTS :
                    startActivity (new Intent (Class_11_academics_expertise.this, Class_11_Arts.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                    break;

                case R.id.C_11_SCIENCE :
                    startActivity (new Intent (Class_11_academics_expertise.this, Class_11_Science.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                    break;
                case R.id.C_11_COMMERCE :

                    startActivity (new Intent (Class_11_academics_expertise.this, Class_11_Commerce.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                    break;




        }
    }
}
