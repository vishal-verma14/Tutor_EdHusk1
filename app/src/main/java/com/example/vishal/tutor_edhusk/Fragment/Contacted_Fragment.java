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
import android.widget.ListView;

import com.example.vishal.tutor_edhusk.Adapter.FirebaseAdapter;
import com.example.vishal.tutor_edhusk.Adapter.FoldingListAdapter;
import com.example.vishal.tutor_edhusk.Model.student_data;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Contacted_Fragment extends Fragment {

    int Position,pos;
    View view;

    RecyclerView  recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    DatabaseReference db;
    ArrayList<String> list = new ArrayList<>();







    public static Contacted_Fragment newInstance() {
        Contacted_Fragment contacted_fragment = new Contacted_Fragment();

        return contacted_fragment;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contacted_, container, false);


        recyclerView = (RecyclerView) view.findViewById(R.id.contacted_listview);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FirebaseAdapter(list,getActivity());
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


}

