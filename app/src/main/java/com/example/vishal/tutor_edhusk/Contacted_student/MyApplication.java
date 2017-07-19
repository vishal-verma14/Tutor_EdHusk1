package com.example.vishal.tutor_edhusk.Contacted_student;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.vishal.tutor_edhusk.Adapter.FirebaseAdapter;
import com.example.vishal.tutor_edhusk.Fragment.Contacted_Fragment;
import com.example.vishal.tutor_edhusk.Model.student_data;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MyApplication extends AppCompatActivity {

    int Position,pos;
    View view;
    RecyclerView listView;
    RecyclerView  recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference db;
    ArrayList<String> list = new ArrayList<>();
    ArrayAdapter<String> studeny_adapter;





    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application);
        recyclerView = (RecyclerView) findViewById(R.id.my_application_listview);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FirebaseAdapter(list,getApplicationContext());
        recyclerView.setAdapter(adapter);

//
//           studeny_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
//           listView.setAdapter(studeny_adapter);


        db= FirebaseDatabase.getInstance().getReference();
        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                @SuppressWarnings("ConstantConditions") String value = dataSnapshot.getValue(student_data.class).getName();
                list.add(value);
                adapter.notifyDataSetChanged();

            }




            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


    }

