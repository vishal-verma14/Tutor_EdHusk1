package com.example.vishal.tutor_edhusk.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ParseException;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.vishal.tutor_edhusk.Adapter.FoldingListAdapter;
import com.example.vishal.tutor_edhusk.Model.Api_data;
import com.example.vishal.tutor_edhusk.Model.Student_data;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ramotion.foldingcell.FoldingCell;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class NewsFeed_Feagment extends Fragment {

    public static final String MyPREFERENCES = "MyPrefs" ;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("tutor applying");

    SharedPreferences sharedPreferences;


    public ArrayList<Student_data> student_list = new ArrayList<Student_data>();
    public FoldingListAdapter adapter;
    View view;
    ListView listView;
    public int Position;
    NewsFeed_Feagment_transfer newsFeed_feagment_transfer;

    public interface NewsFeed_Feagment_transfer{
        public void  setPosition(int i);
    }



    public static NewsFeed_Feagment newInstance() {

        NewsFeed_Feagment newsFeed_feagment = new NewsFeed_Feagment();

        return newsFeed_feagment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_news_feed__feagment, container, false);

        sharedPreferences = this.getActivity().getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);


        final String tutor_name = sharedPreferences.getString("name","Error in getting name");


        Toast.makeText(getActivity(),tutor_name,Toast.LENGTH_SHORT).show();



        listView = (ListView) view.findViewById(R.id.mListView);

        final Api_data api_data = new Api_data();

        final   String userId = mDatabase.push().getKey();

        //noinspection ConstantConditions
        if (api_data != null) {
            new JSONAsyncTask().execute(Api_data.JsonUrl);
        }

        adapter = new FoldingListAdapter(getActivity(), R.layout.cell, student_list);

        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                int student_name  =  student_list.get(Position).getId();
                int student_id  =  student_list.get(Position).getId();
                String student_name  =  student_list.get(Position).getName();
                String student_address  =  student_list.get(Position).getAddress();
                String student_standard  =  student_list.get(Position).getStandard();
                String student_price_range  =  student_list.get(Position).getPrice_Range();
                String student_subject  =  student_list.get(Position).getSubjects();



                student_list.remove(Position);
                adapter.notifyDataSetChanged();


                    //mDatabase.child(userId).child("id").setValue(student_name);
//                    mDatabase.child(userId).child("Type").setValue(tutor_name);

                mDatabase.child(userId).child("id").setValue(student_id);
                mDatabase.child(userId).child("name").setValue(student_name);
                mDatabase.child(userId).child("address").setValue(student_address);
                mDatabase.child(userId).child("standard").setValue(student_standard);
                mDatabase.child(userId).child("Price_Range").setValue(student_price_range);
                mDatabase.child(userId).child("subjects").setValue(student_subject);
                mDatabase.child(userId).child("status").setValue("Pending");



                System.out.println(Position + 1);
                newsFeed_feagment_transfer.setPosition(Position + 1);
                System.out.println(Position + 1 + "start");

            }
        });



        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(position);
                Position = position;


            }
        });

        mDatabase  = FirebaseDatabase.getInstance().getReference();



        return view;

    }

    class JSONAsyncTask extends AsyncTask<String, Void, Boolean> {


        @Override
        protected void onPreExecute() {
            super.onPreExecute();

        }

        @Override
        public Boolean doInBackground(String... urls) {
            try {

                //------------------>>
                HttpGet httppost = new HttpGet(urls[0]);
                HttpClient httpclient = new DefaultHttpClient();
                HttpResponse response = httpclient.execute(httppost);

                // StatusLine stat = response.getStatusLine();
                int status = response.getStatusLine().getStatusCode();

                if (status == 200) {
                    HttpEntity entity = response.getEntity();
                    String data = EntityUtils.toString(entity);


                    JSONArray jarray = new JSONArray(data);
                    for (int i = 0; i < jarray.length(); i++) {
                        JSONObject object = jarray.getJSONObject(i);

                        Student_data item = new Student_data();

                        //id
                        item.setId(object.getInt("id"));
                        Log.d("id",object.getString("id"));


                        //name
                        item.setName(object.getString("Name"));
                        Log.d("name",object.getString("Name"));

                        //contentname
                        item.setContentName(object.getString("Name"));
                        Log.d("name",object.getString("Name"));


                        //slots

                        ArrayList<String> slots_list =  new ArrayList<String>();
                        JSONArray slotsArray =  object.getJSONArray("slots");


                        for (int j = 0;j<slotsArray.length();j++){

                            slots_list.add(slotsArray.getString(j));

//                            Log.d("slots",slotsArray.getString(j));

                        }


                    String slot = "";
                        for (int k=0;k < slotsArray.length();k++)
                        {
                            slot += slots_list.get(k) + ",";
                        }
                        item.setSlots(slot);

                        Log.d("Slots",slot);


                        //days
                        ArrayList<String> days_list =  new ArrayList<String>();
                        JSONArray daysArray =  object.getJSONArray("days");


                        for (int j = 0;j<daysArray.length();j++){

                            days_list.add(daysArray.getString(j));

//                            Log.d("slots",slotsArray.getString(j));

                        }


                        String days = "";
                        for (int k=0;k < daysArray.length();k++)
                        {
                            days += days_list.get(k) + ",";
                        }
                        item.setDays(days);
                        Log.d("days",days);




                        //subject

                        //days
                        ArrayList<String> subject_list =  new ArrayList<String>();
                        JSONArray subjectArray =  object.getJSONArray("subjects");


                        for (int j = 0;j<subjectArray.length();j++){

                            subject_list.add(subjectArray.getString(j));

//                            Log.d("slots",slotsArray.getString(j));

                        }


                        String subject = "";
                        for (int k=0;k < subjectArray.length();k++)
                        {
                            subject += subject_list.get(k) + ",";
                        }
                        item.setSubjects(subject);
                        Log.d("subject",subject);


                        item.setContentSubjects(subject);


//
//                        ArrayList<String> subject_list =  new ArrayList<String>();
//
//
//                        JSONArray subject_array =  object.getJSONArray("subjects");
//
//                        for (int l = 0;l<subject_array.length();l++){
//
//                            subject_list.add(slotsArray.getString(l));
//
////                            Log.d("slots",slotsArray.getString(j));
//
//                        }
//
//                        for (int k=0;k < subject_array.length();k++)
//                        {
//                            Log.i("Value of element "+object.getString("subjects") + "Index" + k,subject_list.get(k));
//                        }




                        //location
                        item.setLocation(object.getString("Location"));
                        Log.d("Location",object.getString("Location"));

                        //Board
                        item.setBoard(object.getString("Board"));
                        Log.d("Board",object.getString("Board"));


                        //Type
                        item.setType(object.getString("Type"));
                        Log.d("Type",object.getString("Type"));


                        //Travel
                        item.setTravel(object.getString("Travel"));
                        Log.d("Travel",object.getString("Travel"));


                        //Gender
                        item.setGender(object.getString("Gender"));
                        Log.d("Gender",object.getString("Gender"));

                        //Standard
                        item.setStandard(object.getString("Standard"));
                        Log.d("Standard",object.getString("Standard"));


                        //ContentStandard
                        item.setContentStandard(object.getString("Standard"));

                        //Address
                        item.setAddress(object.getString("Address"));
                        Log.d("Address",object.getString("Address"));


                        //ContentAddress
                        item.ContentsetAddress(object.getString("Address"));


                        //Created_At
                        item.setCreated_At(object.getString("Created_At"));
                        Log.d("Created_At",object.getString("Created_At"));


                        //Price_Range
                        item.setPrice_Range(object.getString("Price_Range"));
                        Log.d("Price_Range",object.getString("Price_Range"));

                        //Price_Range
                        item.setContentPrice_Range(object.getString("Price_Range"));
                        Log.d("Price_Range",object.getString("Price_Range"));

                        //Lat
                        item.setLat(object.getString("Lat"));
                        Log.d("Lat",object.getString("Lat"));

                        //Lat
                        item.setLong(object.getString("Long"));
                        Log.d("Long",object.getString("Long"));



                        student_list.add(item);
                    }
                    return true;
                }

                //------------------>>

            } catch (ParseException e1) {
                e1.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return false;
        }

        protected void onPostExecute(Boolean result) {
            adapter.notifyDataSetChanged();
            if (result == false)
                Toast.makeText(getActivity(), "Unable to fetch data from server", Toast.LENGTH_LONG).show();


        }



    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            newsFeed_feagment_transfer = (NewsFeed_Feagment_transfer)activity;
        } catch(ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnFragmentSendText");
        }

    }
}

