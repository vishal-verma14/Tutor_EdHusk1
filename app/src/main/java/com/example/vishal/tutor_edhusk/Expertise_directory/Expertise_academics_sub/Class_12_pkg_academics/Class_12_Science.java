package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_12_pkg_academics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_12_Science extends AppCompatActivity {

    ListView class_12_Science_academics_listview;
    expertise_model[] modelItems_class_12_science_academics;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_12__science);

        class_12_Science_academics_listview = (ListView) findViewById(R.id.class_12_Science_academics_listview);
        modelItems_class_12_science_academics = new expertise_model[8];
        modelItems_class_12_science_academics[0] = new expertise_model ("Mathematics", 0);
        modelItems_class_12_science_academics[1] = new expertise_model ("Physics", 0);
        modelItems_class_12_science_academics[2] = new expertise_model ("Chemistry", 0);
        modelItems_class_12_science_academics[3] = new expertise_model ("English", 0);
        modelItems_class_12_science_academics[4] = new expertise_model ("PCB Combo", 0);
        modelItems_class_12_science_academics[5] = new expertise_model ("PCM Combo", 0);
        modelItems_class_12_science_academics[6] = new expertise_model ("Computer Science/Information Practices", 0);
        modelItems_class_12_science_academics[7] = new expertise_model ("Competitive Exam Preparation", 0);



        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_class_12_science_academics);
        class_12_Science_academics_listview.setAdapter(adapter);

    }
}
