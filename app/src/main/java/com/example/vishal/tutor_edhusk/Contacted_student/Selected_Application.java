package com.example.vishal.tutor_edhusk.Contacted_student;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;

import com.example.vishal.tutor_edhusk.Adapter.FirebaseAdapter;
import com.example.vishal.tutor_edhusk.Adapter.Selected_student_Adapter;
import com.example.vishal.tutor_edhusk.Model.Selected_student;
import com.example.vishal.tutor_edhusk.Model.Student_data;
import com.example.vishal.tutor_edhusk.Model.contacted_data;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Objects;

public class Selected_Application extends AppCompatActivity {

    RecyclerView  recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference db;
    ArrayList<Selected_student> data;
    ArrayAdapter<String> studeny_adapter;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_application);
        recyclerView = (RecyclerView) findViewById(R.id.my_application_listview);

        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        data =  new ArrayList<Selected_student>();

//        adapter = new FirebaseAdapter(list,getApplicationContext());
//        recyclerView.setAdapter(adapter);

//
//           studeny_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
//           listView.setAdapter(studeny_adapter);

        adapter = new Selected_student_Adapter(data);
        recyclerView.setAdapter(adapter);


        db= FirebaseDatabase.getInstance().getReference();
        db.addChildEventListener(new ChildEventListener() {

            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

                fetchData(dataSnapshot);


            }




            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void fetchData(DataSnapshot dataSnapshot)
    {
        @SuppressWarnings("ConstantConditions") String name = dataSnapshot.getValue(Student_data.class).getName();
        @SuppressWarnings("ConstantConditions") String Standard = dataSnapshot.getValue(Student_data.class).getStandard();
        @SuppressWarnings("ConstantConditions") String address = dataSnapshot.getValue(Student_data.class).getAddress();

        @SuppressWarnings("ConstantConditions") int id = dataSnapshot.getValue(Student_data.class).getId();
        @SuppressWarnings("ConstantConditions") String Price_Range = dataSnapshot.getValue(Student_data.class).getPrice_Range();
        @SuppressWarnings("ConstantConditions") String subjects = dataSnapshot.getValue(Student_data.class).getSubjects();
        @SuppressWarnings("ConstantConditions") String status = dataSnapshot.getValue(Student_data.class).getStatus();
        if (Objects.equals(status, "selected")) {
            data.add(new Selected_student(name, Standard, address, id, Price_Range, subjects, status));


            adapter.notifyDataSetChanged();
        }
    }


    }

