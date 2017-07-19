package com.example.vishal.tutor_edhusk.Expertise_directory.Expertise_academics_sub;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.Expertise_custom_adapter;
import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

public class Pre_primary_academics_expertise extends AppCompatActivity {

    ListView lv_pre_primary;
    expertise_model[] modelItems_pre_primary;


    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView (R.layout.activity_pre_primary_academics_expertise);

        lv_pre_primary = (ListView) findViewById(R.id.pre_primary_list_academics);
        modelItems_pre_primary = new expertise_model[4];
        modelItems_pre_primary[0] = new expertise_model ("Abacus", 0);
        modelItems_pre_primary[1] = new expertise_model ("Handwriting Basic", 0);
        modelItems_pre_primary[2] = new expertise_model ("English", 0);
        modelItems_pre_primary[3] = new expertise_model ("KG Academic Class", 0);


        Expertise_custom_adapter adapter = new Expertise_custom_adapter(this, modelItems_pre_primary);
        lv_pre_primary.setAdapter(adapter);

    }
}
