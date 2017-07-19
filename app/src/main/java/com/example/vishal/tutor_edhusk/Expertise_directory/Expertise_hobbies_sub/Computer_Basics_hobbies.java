package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Computer_Basics_hobbies extends AppCompatActivity {

    ListView C_B_hobbies_listview;
    expertise_model[] modelItems_C_B_hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_computer__basics_hobbies);

        C_B_hobbies_listview = (ListView) findViewById(R.id.C_B_hobbies_listview);
        modelItems_C_B_hobbies = new expertise_model[5];
        modelItems_C_B_hobbies[0] = new expertise_model ("Basic Computer Skill", 0);
        modelItems_C_B_hobbies[1] = new expertise_model ("Basic Web Designing", 0);
        modelItems_C_B_hobbies[2] = new expertise_model ("Learn Tally", 0);
        modelItems_C_B_hobbies[3] = new expertise_model ("Microsoft Office", 0);
        modelItems_C_B_hobbies[4] = new expertise_model ("Essential Computer Skills", 0);



        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_C_B_hobbies);
        C_B_hobbies_listview.setAdapter(adapter);
    }
}
