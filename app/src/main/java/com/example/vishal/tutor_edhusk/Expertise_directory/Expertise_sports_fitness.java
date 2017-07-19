package com.example.vishal.tutor_edhusk.Expertise_directory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Expertise_sports_fitness extends AppCompatActivity {

    ListView lv_sports;
    expertise_model[] modelItems_sports_skill;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_expertise_sports_fitness);
        lv_sports = (ListView) findViewById(R.id.expertise_sports_list);
        modelItems_sports_skill = new expertise_model[14];
        modelItems_sports_skill[0] = new expertise_model ("Badminton", 0);
        modelItems_sports_skill[1] = new expertise_model ("Basketball", 0);
        modelItems_sports_skill[2] = new expertise_model ("Chess", 0);
        modelItems_sports_skill[3] = new expertise_model ("Cricket", 0);
        modelItems_sports_skill[4] = new expertise_model ("Dietitian", 0);
        modelItems_sports_skill[5] = new expertise_model ("Football", 0);
        modelItems_sports_skill[6] = new expertise_model ("Martial Arts", 0);
        modelItems_sports_skill[7] = new expertise_model ("Running", 0);
        modelItems_sports_skill[8] = new expertise_model ("Skating", 0);
        modelItems_sports_skill[9] = new expertise_model ("Swimming", 0);
        modelItems_sports_skill[10] = new expertise_model ("Fitness Trainer", 0);
        modelItems_sports_skill[11] = new expertise_model ("Volleyball", 0);
        modelItems_sports_skill[12] = new expertise_model ("Yoga", 0);
        modelItems_sports_skill[13] = new expertise_model ("Zumba/Aerobics", 0);



        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_sports_skill);
        lv_sports.setAdapter(adapter);


    }
}
