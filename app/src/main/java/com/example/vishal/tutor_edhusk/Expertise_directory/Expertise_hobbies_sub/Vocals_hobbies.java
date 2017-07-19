package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Vocals_hobbies extends AppCompatActivity {

    ListView V_hobbies_listview;
    expertise_model[] modelItems_V_hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_vocals);


        V_hobbies_listview = (ListView) findViewById(R.id.V_hobbies_listview);
        modelItems_V_hobbies = new expertise_model[3];
        modelItems_V_hobbies[0] = new expertise_model ("Bollywood Vocal", 0);
        modelItems_V_hobbies[1] = new expertise_model ("Indian Classical Vocal", 0);
        modelItems_V_hobbies[2] = new expertise_model ("Western Vocal", 0);





        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_V_hobbies);
        V_hobbies_listview.setAdapter(adapter);
    }
}
