package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_6_10_academics_expertise extends AppCompatActivity {

    ListView class_6_10_academics_listview;
    expertise_model[] modelItems_6_10_academics;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_6_10_academics_expertise);

        class_6_10_academics_listview = (ListView) findViewById(R.id.class_6_10_academics_listview);
        modelItems_6_10_academics = new expertise_model[13];
        modelItems_6_10_academics[0] = new expertise_model ("All Subject", 0);
        modelItems_6_10_academics[1] = new expertise_model ("Mathematics", 0);
        modelItems_6_10_academics[2] = new expertise_model ("Science", 0);
        modelItems_6_10_academics[3] = new expertise_model ("Computer Science", 0);
        modelItems_6_10_academics[4] = new expertise_model ("English", 0);
        modelItems_6_10_academics[5] = new expertise_model ("Hindi", 0);
        modelItems_6_10_academics[6] = new expertise_model ("Social Science", 0);
        modelItems_6_10_academics[7] = new expertise_model ("Sanskrit", 0);
        modelItems_6_10_academics[8] = new expertise_model ("Environmental Studies", 0);
        modelItems_6_10_academics[9] = new expertise_model ("French", 0);
        modelItems_6_10_academics[10] = new expertise_model ("German", 0);
        modelItems_6_10_academics[11] = new expertise_model ("Spanish", 0);
        modelItems_6_10_academics[12] = new expertise_model ("Mathematics - Science (Combo)", 0);
        modelItems_6_10_academics[113] = new expertise_model ("Olympiad Maths/Science", 0);




        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_6_10_academics);
        class_6_10_academics_listview.setAdapter(adapter);

    }
}
