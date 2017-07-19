package com.example.vishal.tutor_edhusk.Fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SyncStats;
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
import com.example.vishal.tutor_edhusk.Model.student_data;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.auth.FirebaseAuth;
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


    public ArrayList<student_data> student_list = new ArrayList<student_data>();
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

                String student_name  =  student_list.get(Position).getName();

                student_list.remove(Position);
                adapter.notifyDataSetChanged();

                if (student_name != null){
                    mDatabase.child(userId).child("Name").setValue(student_name);
                    mDatabase.child(userId).child("Type").setValue(tutor_name);
                }
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

                        student_data item = new student_data();

                        ArrayList<String> temp =  new ArrayList<String>();

                        item.setName(object.getString("Name"));

                            JSONArray tagname =  object.getJSONArray("slots");
                        for (int j = 0;j<tagname.length();j++){
                            temp.add(tagname.getString(j));
                            Log.d("tagame",tagname.getString(j));
                            Log.d("tagndsaame",object.getString("Name"));

                        }

//                        JSONObject jsonObject = new JSONObject(data);
//                        JSONArray friends = jsonObject.getJSONArray("slots");
//                        for (int j=0; j<friends.length(); ++j){
//                            JSONObject currentFriend = friends.getJSONObject(j);
//                            temp.add(currentFriend.getString(String.valueOf(j)));;
//                            Log.d("tagame",currentFriend.getString(String.valueOf(j)));
//                        }


                        item.setLocation(object.getString("Location"));


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

