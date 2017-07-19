package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Cooking_hobbies extends AppCompatActivity {

    ListView C_hobbies_listview;
    expertise_model[] modelItems_C_hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_cooking_hobbies);


        C_hobbies_listview = (ListView) findViewById(R.id.C_hobbies_listview);
        modelItems_C_hobbies = new expertise_model[2];
        modelItems_C_hobbies[0] = new expertise_model ("Cooking", 0);
        modelItems_C_hobbies[1] = new expertise_model ("Baking", 0);



        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_C_hobbies);
        C_hobbies_listview.setAdapter(adapter);
    }
}
