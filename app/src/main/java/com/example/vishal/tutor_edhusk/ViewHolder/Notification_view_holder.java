package com.example.vishal.tutor_edhusk.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vishal.tutor_edhusk.R;

/**
 * Created by apple on 15/07/17.
 */

public class Notification_view_holder extends RecyclerView.ViewHolder {


    public TextView notification_title;
    public ImageView notification_logo;
    public TextView noification_body;

    public Notification_view_holder (View itemView) {
        super (itemView);

        notification_title = (TextView) itemView.findViewById (R.id.notification_title);
        noification_body = (TextView) itemView.findViewById (R.id.notification_body);
        notification_logo = (ImageView) itemView.findViewById (R.id.notification_image);


    }
}
