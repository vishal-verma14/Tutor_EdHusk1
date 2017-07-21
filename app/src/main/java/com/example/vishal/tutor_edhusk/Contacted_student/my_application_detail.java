package com.example.vishal.tutor_edhusk.Contacted_student;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vishal.tutor_edhusk.R;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;

public class my_application_detail extends AppCompatActivity {

    private SlidingUpPanelLayout mLayout;

    LinearLayout DragView;
    private static final String TAG = "sliding layout";
    SharedPreferences sharedPreferences;
    public static final String MyPREFERENCES = "MyPrefs";
    private FirebaseAuth mAuth;
    private  String userID;
    private DatabaseReference databaseReference;

    private FirebaseDatabase mFirebaseDatabase;

    public static final String[] status = new String[1];
    final String[] s = new String[1];

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_my_application_detail);
        Intent intent = getIntent ();

        mAuth = FirebaseAuth.getInstance ();
        mFirebaseDatabase = FirebaseDatabase.getInstance ();
        databaseReference = mFirebaseDatabase.getReference ();
        FirebaseDatabase mDatabase = FirebaseDatabase.getInstance ();
        databaseReference = mDatabase.getReference ();

//        userID = databaseReference.push ().getKey ();
//        databaseReference.child (userID).child ("Name").setValue ("Vishal");
//
//




        sharedPreferences = getSharedPreferences (MyPREFERENCES, MODE_PRIVATE);


        final String name = sharedPreferences.getString ("name", "Error in getting url");

        //String name = intent.getStringExtra("name");

//        databaseReference.setValue (name);


//
//
//        textView = (TextView) findViewById(R.id.text);
//
        mLayout = (SlidingUpPanelLayout) findViewById (R.id.sliding_Up_layout);
//
        DragView = (LinearLayout) findViewById (R.id.dragView);


        final TextView textView = (TextView) findViewById (R.id.name_detail);
        HashSet<Date> events = new HashSet<> ();
        events.add (new Date ());


        CalendarView cv = ((CalendarView) findViewById (R.id.calendar_view));
        cv.updateCalendar (events);

        SharedPreferences pref = getApplicationContext ().getSharedPreferences (cv.DatePREFERENCES, Context.MODE_PRIVATE);


        int day = pref.getInt ("day", 0);
        int month = pref.getInt ("month", 0);
        int year = pref.getInt ("year", 0);

        String date = day + "-" + month + "-" + year;

        Toast.makeText (getApplicationContext (), date, Toast.LENGTH_LONG).show ();
//        databaseReference.child ("tutor attendence").child ("Name").setValue (name);
//                databaseReference.child ("tutor attendence").child (name).child ("date").setValue (date);
//        databaseReference.child ("tutor attendence").child (name).child ("status").setValue (0);


        // assign event handler
        cv.setEventHandler (new CalendarView.EventHandler () {
            @Override
            public void onDayLongPress (Date date) {
                // show returned day
                DateFormat df = SimpleDateFormat.getDateInstance ();
                Toast.makeText (my_application_detail.this, df.format (date), Toast.LENGTH_SHORT).show ();
                mLayout.setPanelState (SlidingUpPanelLayout.PanelState.EXPANDED);
            }
        });

//        final CustomCalendarView calendarView = (CustomCalendarView) findViewById(R.id.calendar_view);
//
////Initialize calendar with date
//        final java.util.Calendar currentCalendar = java.util.Calendar.getInstance(Locale.getDefault());
//
////Show Monday as first date of week
//        calendarView.setFirstDayOfWeek(Calendar.MONDAY);
//
////Show/hide overflow days of a month
//        calendarView.setShowOverflowDate(false);
//
////call refreshCalendar to update calendar the view
//        calendarView.refreshCalendar(currentCalendar);
//
//
////Handling custom calendar events
//
//        calendarView.setCalendarListener(new CalendarListener() {
//            @Override
//            public void onDateSelected(Date date) {
//                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
//                Toast.makeText(my_application_detail.this, df.format(date), Toast.LENGTH_SHORT).show();
//                mLayout.setPanelState(SlidingUpPanelLayout.PanelState.EXPANDED);
//
//            }
//
//            @Override
//            public void onMonthChanged(Date date) {
//                SimpleDateFormat df = new SimpleDateFormat("MM-yyyy");
//                Toast.makeText(my_application_detail.this, df.format(date), Toast.LENGTH_SHORT).show();
//            }
//        });


        panelListener ();

        databaseReference.addValueEventListener (new ValueEventListener () {
            @Override
            public void onDataChange (DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists ()){
                    Attendence_status atstatus = new Attendence_status ();
//
//                    atstatus.setName(dataSnapshot.child ("Name").getValue(Attendence_status.class).getName()); //set the name

//                    s[0] = dataSnapshot.child ("Name").getValue ().toString ();
//                    status[0] = dataSnapshot.child ("Status").getValue ().toString ();
//
//                    atstatus.setStatus (status[0]);

//                    Toast.makeText (getApplicationContext (), s[0],Toast.LENGTH_LONG).show ();
//                    Toast.makeText (getApplicationContext (), status[0],Toast.LENGTH_LONG).show ();


                }else {
                    Toast.makeText (getApplicationContext (),"error in getting name",Toast.LENGTH_LONG).show ();

                }

            }

            @Override
            public void onCancelled (DatabaseError databaseError) {
                Toast.makeText (getApplicationContext (),"error application",Toast.LENGTH_LONG).show ();

            }
        });
    }

    public void panelListener () {

        mLayout.setPanelSlideListener (new SlidingUpPanelLayout.PanelSlideListener () {

            // During the transition of expand and collapse onPanelSlide function will be called.
            @Override
            public void onPanelSlide (View panel, float slideOffset) {

                Log.e (TAG, "onPanelSlide" + slideOffset);
            }

            // Called when secondary layout is dragged up by user
            @Override
            public void onPanelExpanded (View panel) {

                Log.e (TAG, "onPanelExpanded");
            }

            // Called when secondary layout is dragged down by user
            @Override
            public void onPanelCollapsed (View panel) {
                Log.e (TAG, "onPanelCollapsed");
            }

            @Override
            public void onPanelAnchored (View panel) {


                Log.e (TAG, "onPanelAncoured");
            }

            @Override
            public void onPanelHidden (View panel) {

                Log.e (TAG, "onPanelHidden");
            }
        });
    }

}
