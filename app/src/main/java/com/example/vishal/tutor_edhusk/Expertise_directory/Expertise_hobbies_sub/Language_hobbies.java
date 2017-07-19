package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Language_hobbies extends AppCompatActivity {

    ListView L_hobbies_listview;
    expertise_model[] modelItems_L_hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_language_hobbies);


        L_hobbies_listview = (ListView) findViewById(R.id.L_hobbies_listview);
        modelItems_L_hobbies = new expertise_model[7];
        modelItems_L_hobbies[0] = new expertise_model ("English", 0);
        modelItems_L_hobbies[1] = new expertise_model ("French", 0);
        modelItems_L_hobbies[2] = new expertise_model ("Italian", 0);
        modelItems_L_hobbies[3] = new expertise_model ("Spanish", 0);
        modelItems_L_hobbies[4] = new expertise_model ("German", 0);
        modelItems_L_hobbies[5] = new expertise_model ("Bengali", 0);
        modelItems_L_hobbies[6] = new expertise_model ("Gujrati", 0);




        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_L_hobbies);
        L_hobbies_listview.setAdapter(adapter);
    }
}
