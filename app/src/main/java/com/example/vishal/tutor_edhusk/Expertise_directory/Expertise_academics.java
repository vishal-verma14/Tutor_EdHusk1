package com.example.vishal.tutor_edhusk.Expertise_directory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.view.WindowManager;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_1_5_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_6_10_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Pre_primary_academics_expertise;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Expertise_academics extends AppCompatActivity implements View.OnClickListener {


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_expertise_academics);


        Button p_p_btn = (Button) findViewById (R.id.P_P_EA);
        p_p_btn.setOnClickListener (this);

        Button c_1_5_btn = (Button) findViewById (R.id.C_1_5_EA);
        c_1_5_btn.setOnClickListener (this);

        Button c_6_10_btn = (Button) findViewById (R.id.C_6_10_EA);
        c_6_10_btn.setOnClickListener (this);

        Button c_11_btn = (Button) findViewById (R.id.C_11_EA);
        c_11_btn.setOnClickListener (this);

        Button c_12_btn = (Button) findViewById (R.id.C_12_EA);
        c_12_btn.setOnClickListener (this);






    }

    @Override
    public void onClick (View view) {

        switch (view.getId ()){

            case R.id.P_P_EA :
                startActivity (new Intent (Expertise_academics.this, Pre_primary_academics_expertise.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;

            case R.id.C_1_5_EA :
                startActivity (new Intent (Expertise_academics.this, Class_1_5_academics_expertise.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.C_6_10_EA :

                startActivity (new Intent (Expertise_academics.this, Class_6_10_academics_expertise.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.C_11_EA :

                startActivity (new Intent (Expertise_academics.this, Class_11_academics_expertise.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.C_12_EA :
                startActivity (new Intent (Expertise_academics.this, Class_12_academics_expertise.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);


                break;

        }

    }
}
