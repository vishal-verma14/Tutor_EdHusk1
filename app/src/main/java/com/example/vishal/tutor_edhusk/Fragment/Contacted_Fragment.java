package com.example.vishal.tutor_edhusk.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.example.vishal.tutor_edhusk.Adapter.FirebaseAdapter;
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

public class Contacted_Fragment extends Fragment {

    int Position,pos;
    View view;
    RecyclerView listView;
    RecyclerView  recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference db;
    ArrayList<contacted_data> data;
    ArrayAdapter<String> studeny_adapter;







    public static Contacted_Fragment newInstance() {
        Contacted_Fragment contacted_fragment = new Contacted_Fragment();

        return contacted_fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contacted_, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.contacted_listview);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        data =  new ArrayList<contacted_data>();




        adapter = new FirebaseAdapter(data);
        recyclerView.setAdapter(adapter);

//
//           studeny_adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,list);
//           listView.setAdapter(studeny_adapter);


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
        return view;

    }
    public void setpos(final int i)
    {
        Log.e("setpos","started");
        Position = i;
        System.out.println(i);
    }

    public void startpos(){
        new position_transfer().execute();
    }
    private class position_transfer extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {
            Bundle b = getArguments();
            pos =  b.getInt("pos");
            return null;
        }

        protected void onPostExecute(String result){
            setpos(pos);
        }
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

            data.add(new contacted_data(name, Standard, address, id, Price_Range, subjects, status));
            adapter.notifyDataSetChanged();

    }

}

