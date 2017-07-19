package com.example.vishal.tutor_edhusk.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishal.tutor_edhusk.DatabaseHandler.Notification_Database_Handler;
import com.example.vishal.tutor_edhusk.Model.Notification_model;
import com.example.vishal.tutor_edhusk.R;
import com.example.vishal.tutor_edhusk.ViewHolder.Notification_view_holder;

import java.util.List;

/**
 * Created by apple on 15/07/17.
 */

public class Notification_Adapter extends RecyclerView.Adapter<Notification_view_holder>{

    private Context context;
    private List<Notification_model> notification_modelList;
    private Notification_Database_Handler mDatabase;


    public Notification_Adapter(Context context, List<Notification_model> notification_models) {
        this.context = context;
        this.notification_modelList = notification_models;
        mDatabase = new Notification_Database_Handler (context);
    }

    @Override
    public Notification_view_holder onCreateViewHolder (ViewGroup parent, int viewType) {

        View view = LayoutInflater.from (parent.getContext ()).inflate (R.layout.notification_fragment_card_view,parent,false);


        return new Notification_view_holder(view);
    }

    @Override
    public void onBindViewHolder (Notification_view_holder holder, int position) {

        final Notification_model notification_model = notification_modelList.get (position);

        holder.notification_title.setText (notification_model.get_Notification_header ());
        holder.noification_body.setText (notification_model.getNotification_body ());

    }

    @Override
    public int getItemCount () {


        return notification_modelList.size ();
    }
}
