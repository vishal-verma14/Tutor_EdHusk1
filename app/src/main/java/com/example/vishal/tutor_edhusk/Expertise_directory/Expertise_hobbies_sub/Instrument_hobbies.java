package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Instrument_hobbies extends AppCompatActivity {

    ListView I_hobbies_listview;
    expertise_model[] modelItems_I__hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_instrument_hobbies);


        I_hobbies_listview = (ListView) findViewById(R.id.I_hobbies_listview);
        modelItems_I__hobbies = new expertise_model[12];
        modelItems_I__hobbies[0] = new expertise_model ("Guitar-Acoustic-Bass-Electric", 0);
        modelItems_I__hobbies[1] = new expertise_model ("Tabla", 0);
        modelItems_I__hobbies[2] = new expertise_model ("Dholak", 0);
        modelItems_I__hobbies[3] = new expertise_model ("Harmonium", 0);
        modelItems_I__hobbies[4] = new expertise_model ("Veena", 0);
        modelItems_I__hobbies[5] = new expertise_model ("Mradanga", 0);
        modelItems_I__hobbies[6] = new expertise_model ("Sitar", 0);
        modelItems_I__hobbies[7] = new expertise_model ("Banshuri/Flute", 0);

        modelItems_I__hobbies[8] = new expertise_model ("Violin", 0);

        modelItems_I__hobbies[9] = new expertise_model ("Keyboard", 0);

        modelItems_I__hobbies[10] = new expertise_model ("Mouth Organ", 0);

        modelItems_I__hobbies[11] = new expertise_model ("Drums", 0);





        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_I__hobbies);
        I_hobbies_listview.setAdapter(adapter);
    }
}
