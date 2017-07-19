package com.example.vishal.tutor_edhusk.User_information_sub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_skill;
import com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_sports_fitness;
import com.example.vishal.tutor_edhusk.R;

public class Expertise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_expertise);

        Button ach_btn_expertise = (Button) findViewById (R.id.expertise_academics);
        ach_btn_expertise.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent mainIntent = new Intent (Expertise.this,
                        Expertise_academics.class);

                startActivity (mainIntent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

            }
        });

        Button s_f_btn_expertise = (Button) findViewById (R.id.expertise_s_f);
        s_f_btn_expertise.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent mainIntent = new Intent (Expertise.this,
                        Expertise_sports_fitness.class);

                startActivity (mainIntent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

            }
        });

        Button hobbies_btn_expertise = (Button) findViewById (R.id.expertise_h_s);
        hobbies_btn_expertise.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                Intent mainIntent = new Intent (Expertise.this,
                        Expertise_hobbies_skill.class);

                startActivity (mainIntent);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

            }
        });
    }
}
