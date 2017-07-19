package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_hobbies_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Art_and_Craft_hobbies extends AppCompatActivity {

    ListView A_C_hobbies_listview;
    expertise_model[] modelItems_A_C_hobbies;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_art_and__craft_hobbies);

        A_C_hobbies_listview = (ListView) findViewById(R.id.A_C_hobbies_listview);
        modelItems_A_C_hobbies = new expertise_model[12];
        modelItems_A_C_hobbies[0] = new expertise_model ("Art for Kids", 0);
        modelItems_A_C_hobbies[1] = new expertise_model ("Calligraphy", 0);
        modelItems_A_C_hobbies[2] = new expertise_model ("Canvas Painting", 0);
        modelItems_A_C_hobbies[3] = new expertise_model ("Charcoal Painting", 0);
        modelItems_A_C_hobbies[4] = new expertise_model ("Basic Sketching", 0);
        modelItems_A_C_hobbies[5] = new expertise_model ("Oil Painting", 0);
        modelItems_A_C_hobbies[6] = new expertise_model ("Watercolor Painting", 0);
        modelItems_A_C_hobbies[7] = new expertise_model ("Pencil Sketching", 0);

        modelItems_A_C_hobbies[8] = new expertise_model ("Glass Painting", 0);

        modelItems_A_C_hobbies[9] = new expertise_model ("Jewellery Design", 0);

        modelItems_A_C_hobbies[10] = new expertise_model ("Knitting Classes", 0);

        modelItems_A_C_hobbies[11] = new expertise_model ("Mehendi Designing", 0);





        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_A_C_hobbies);
        A_C_hobbies_listview.setAdapter(adapter);

    }
}
