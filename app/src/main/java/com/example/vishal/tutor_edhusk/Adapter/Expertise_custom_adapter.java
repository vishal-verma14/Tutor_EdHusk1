package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.app.Activity;
import android.view.LayoutInflater;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.vishal.tutor_edhusk.Model.expertise_model;
import com.example.vishal.tutor_edhusk.R;

/**
 * Created by apple on 14/07/17.
 */

public class Expertise_custom_adapter extends ArrayAdapter<expertise_model>{

    expertise_model[] modelItems = null;
    Context context;

    public Expertise_custom_adapter (@NonNull Context context, expertise_model[] resource) {
        super (context, R.layout.expertise_academics_ui,resource);
        this.context = context;
        this.modelItems = resource;

    }

    @NonNull
    @Override
    public View getView (int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.expertise_academics_ui, parent, false);
        TextView name = (TextView) convertView.findViewById(R.id.ck_text);
        CheckBox cb = (CheckBox) convertView.findViewById(R.id.ck_expert);
        name.setText(modelItems[position].getName());
        if(modelItems[position].getValue() == 1)
            cb.setChecked(true);
        else
            cb.setChecked(false);
        return convertView;    }
}
