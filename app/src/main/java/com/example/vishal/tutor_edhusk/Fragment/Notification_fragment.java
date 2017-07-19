package com.example.vishal.tutor_edhusk.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.List;

import com.example.vishal.tutor_edhusk.Adapter.Notification_Adapter;
import com.example.vishal.tutor_edhusk.DatabaseHandler.Notification_Database_Handler;
import com.example.vishal.tutor_edhusk.Model.Notification_model;
import com.example.vishal.tutor_edhusk.R;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Notification_fragment extends Fragment {

    View view;
    private Notification_Database_Handler mDatabase;


    public static Notification_fragment newInstance () {
        Notification_fragment notification_fragment = new Notification_fragment ();

        return notification_fragment;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);

    }


    @Override
    public View onCreateView (LayoutInflater inflater, ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate (R.layout.fragment_notification_fragment, container, false);

        FrameLayout fLayout = (FrameLayout) view.findViewById(R.id.notification_frame);
        RecyclerView notificationView = (RecyclerView)view.findViewById(R.id.notification_list);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext ());
        notificationView.setLayoutManager(linearLayoutManager);
        notificationView.setHasFixedSize(true);
        mDatabase = new Notification_Database_Handler (getContext ());
        List<Notification_model> allNotification = mDatabase.getAllNotification();
        if(allNotification.size() > 0){
            notificationView.setVisibility(View.VISIBLE);
            Notification_Adapter mAdapter = new Notification_Adapter (getContext (), allNotification);
            notificationView.setAdapter(mAdapter);
        }else {
            notificationView.setVisibility(View.GONE);
            Toast.makeText(getContext (), "There is no product in the database. Start adding now", Toast.LENGTH_LONG).show();
        }
        return view;

    }





}
