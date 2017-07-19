package com.example.vishal.tutor_edhusk.Expertise_directory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_1_5_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_6_10_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Pre_primary_academics_expertise;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Art_and_Craft_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Computer_Basics_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Cooking_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Dance_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Instrument_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Language_hobbies;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub.Vocals_hobbies;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Expertise_hobbies_skill extends AppCompatActivity implements View.OnClickListener {


    ListView lv_hobbies;
    expertise_model[] modelItems_hobbies_skill;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_expertise_hobbies_skill);



        Button A_C_hobbies = (Button) findViewById (R.id.A_C_hobbies);
        A_C_hobbies.setOnClickListener (this);

        Button C_B_hobbies = (Button) findViewById (R.id.C_B_hobbies);
        C_B_hobbies.setOnClickListener (this);

        Button c_hobbies = (Button) findViewById (R.id.c_hobbies);
        c_hobbies.setOnClickListener (this);

        Button D_hobbies = (Button) findViewById (R.id.D_hobbies);
        D_hobbies.setOnClickListener (this);

        Button I_hobbies = (Button) findViewById (R.id.I_hobbies);
        I_hobbies.setOnClickListener (this);

        Button V_hobbies = (Button) findViewById (R.id.V_hobbies);
        V_hobbies.setOnClickListener (this);


        Button L_hobbies = (Button) findViewById (R.id.L_hobbies);
        L_hobbies.setOnClickListener (this);


    }

    @Override
    public void onClick (View view) {

        switch (view.getId ()){

            case R.id.A_C_hobbies :
                startActivity (new Intent (Expertise_hobbies_skill.this, Art_and_Craft_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;

            case R.id.C_B_hobbies :
                startActivity (new Intent (Expertise_hobbies_skill.this, Computer_Basics_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.c_hobbies :

                startActivity (new Intent (Expertise_hobbies_skill.this, Cooking_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.D_hobbies :

                startActivity (new Intent (Expertise_hobbies_skill.this, Dance_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;
            case R.id.I_hobbies :
                startActivity (new Intent (Expertise_hobbies_skill.this, Instrument_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);


                break;

            case R.id.V_hobbies :
                startActivity (new Intent (Expertise_hobbies_skill.this, Vocals_hobbies.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);


                break;

            case R.id.L_hobbies :
                startActivity (new Intent (Expertise_hobbies_skill.this, Language_hobbies .class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);


                break;

        }

    }
}
