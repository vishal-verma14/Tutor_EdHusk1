package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Dance_hobbies extends AppCompatActivity {

    ListView D_hobbies_listview;
    expertise_model[] modelItems_D_hobbies;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_classical__dance_hobbies);

        D_hobbies_listview = (ListView) findViewById(R.id.D_hobbies_listview);
        modelItems_D_hobbies = new expertise_model[14];
        modelItems_D_hobbies[0] = new expertise_model ("Bhangra", 0);
        modelItems_D_hobbies[1] = new expertise_model ("Kathak", 0);
        modelItems_D_hobbies[2] = new expertise_model ("Bharatnatyam", 0);
        modelItems_D_hobbies[3] = new expertise_model ("Ghoomar", 0);
        modelItems_D_hobbies[4] = new expertise_model ("Kalbeliya", 0);
        modelItems_D_hobbies[5] = new expertise_model ("Other Classical Dances", 0);
        modelItems_D_hobbies[6] = new expertise_model ("Anybody Can Dance", 0);
        modelItems_D_hobbies[7] = new expertise_model ("Bollywood Dance", 0);

        modelItems_D_hobbies[8] = new expertise_model ("Jazz Dance", 0);

        modelItems_D_hobbies[9] = new expertise_model ("Hip Hop", 0);

        modelItems_D_hobbies[10] = new expertise_model ("Belly Dance", 0);

        modelItems_D_hobbies[11] = new expertise_model ("B-Boying", 0);

        modelItems_D_hobbies[12] = new expertise_model ("Contemporary Dance", 0);

        modelItems_D_hobbies[13] = new expertise_model ("Wedding Choreography", 0);






        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_D_hobbies);
        D_hobbies_listview.setAdapter(adapter);
    }
}
