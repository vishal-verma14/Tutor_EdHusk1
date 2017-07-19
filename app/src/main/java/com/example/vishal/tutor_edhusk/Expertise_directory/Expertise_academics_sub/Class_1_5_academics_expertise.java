package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_1_5_academics_expertise extends AppCompatActivity {

    ListView lv_1_5_class;
    expertise_model[] modelItems_1_5_academics;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_1_5_academics_expertise);

        lv_1_5_class = (ListView) findViewById(R.id.class_1_5_academics_listview);
        modelItems_1_5_academics = new expertise_model[9];
        modelItems_1_5_academics[0] = new expertise_model ("All subjects", 0);
        modelItems_1_5_academics[1] = new expertise_model ("Vedic Maths", 0);
        modelItems_1_5_academics[2] = new expertise_model ("Mathematics", 0);
        modelItems_1_5_academics[3] = new expertise_model ("Science", 0);
        modelItems_1_5_academics[4] = new expertise_model ("English", 0);
        modelItems_1_5_academics[5] = new expertise_model ("Hindi", 0);
        modelItems_1_5_academics[6] = new expertise_model ("Environmental Studies", 0);
        modelItems_1_5_academics[7] = new expertise_model ("Mathematics - Science", 0);
        modelItems_1_5_academics[8] = new expertise_model ("Handwriting English/Hindi", 0);



        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_1_5_academics);
        lv_1_5_class.setAdapter(adapter);



    }
}
