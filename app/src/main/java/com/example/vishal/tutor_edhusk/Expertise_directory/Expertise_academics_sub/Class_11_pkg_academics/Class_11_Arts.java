package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub.Class_11_pkg_academics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Class_11_Arts extends AppCompatActivity {

    ListView class_11_Arts_academics_listview;
    expertise_model[] modelItems_11_Arts_academics;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_class_11__arts);

        class_11_Arts_academics_listview = (ListView) findViewById(R.id.class_11_Arts_academics_listview);
        modelItems_11_Arts_academics = new expertise_model[7];
        modelItems_11_Arts_academics[0] = new expertise_model ("Geography", 0);
        modelItems_11_Arts_academics[1] = new expertise_model ("History", 0);
        modelItems_11_Arts_academics[2] = new expertise_model ("Political Science", 0);
        modelItems_11_Arts_academics[3] = new expertise_model ("Humanities", 0);
        modelItems_11_Arts_academics[4] = new expertise_model ("English", 0);
        modelItems_11_Arts_academics[5] = new expertise_model ("Psychology", 0);
        modelItems_11_Arts_academics[6] = new expertise_model ("Computer Science/Information Practices", 0);




        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_11_Arts_academics);
        class_11_Arts_academics_listview.setAdapter(adapter);


    }
}
