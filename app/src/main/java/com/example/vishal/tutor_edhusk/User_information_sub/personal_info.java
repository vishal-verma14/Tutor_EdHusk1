package com.example.vishal.tutor_edhusk.User_information_sub;

import android.app.DatePickerDialog;
import android.app.Dialog;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.pkmmte.view.CircularImageView;

public class personal_info extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    TextView date_pic;
    TextView name_personal_tv,email_personal_tv;
    CircularImageView user_personal;
    String  name_personal,email_personal,phone_no_personal,address_personal,DOB_personal,city_personal,area_personal,
            street_personal,landmark_personal,pincode_personal,email,name,url;
    RadioGroup radioGenderGroup;
    Button profile_submit;
    private DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("user");
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedPreferences;
;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);
        final   String userId = mDatabase.push().getKey();


        date_pic= (TextView)findViewById(R.id.date_pic);

        name_personal_tv    = (TextView) findViewById(R.id.name_personal);
        email_personal_tv     = (TextView) findViewById(R.id.email_personal);
        phone_no_personal    = ((EditText) findViewById(R.id.ph_no_peronal)).getText().toString();
        user_personal  = (CircularImageView) findViewById(R.id.user_img_personal);
        address_personal     = ((EditText) findViewById(R.id.address_personal)).getText().toString();
        city_personal  = ((EditText) findViewById(R.id.city_personal)).getText().toString();
        area_personal   = ((EditText) findViewById(R.id.area_personal)).getText().toString();
        street_personal      = ((EditText) findViewById(R.id.street_personal)).getText().toString();
        landmark_personal   = ((EditText) findViewById(R.id.landmark_personal)).getText().toString();
        pincode_personal = ((EditText) findViewById(R.id.pincode_personal)).getText().toString();
        profile_submit = (Button) findViewById(R.id.profile_submit);

        sharedPreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);


        final String name = sharedPreferences.getString("name","Error in getting name");
        name_personal_tv.setText(name);
        email = sharedPreferences.getString("email","Error in getting name");
        email_personal_tv.setText(email);
        url = sharedPreferences.getString("url","Error in getting url");
        Glide.with(this).load(url).thumbnail(0.8f).into(user_personal);


        profile_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //noinspection ConstantConditions
                if (phone_no_personal != null && address_personal != null  && name !=null
                         && city_personal != null && area_personal!= null && street_personal != null &&
                        street_personal != null && landmark_personal != null && pincode_personal != null) {

                    mDatabase.child(userId).setValue(name);
                    mDatabase.child(userId).child(name).child("email").setValue(email);
                    mDatabase.child(userId).child(name).child("image").setValue(url);
                    mDatabase.child(userId).child(name).child("phone").setValue(phone_no_personal);
                    mDatabase.child(userId).child(name).child("address").setValue(address_personal);
                    mDatabase.child(userId).child(name).child("city").setValue(city_personal);
                    mDatabase.child(userId).child(name).child("area").setValue(area_personal);
                    mDatabase.child(userId).child(name).child("street").setValue(street_personal);
                    mDatabase.child(userId).child(name).child("landmark").setValue(landmark_personal);
                    mDatabase.child(userId).child(name).child("pincode").setValue(pincode_personal);



                }

            }
        });



    }

    public void date_pic(View view){

        DatePickerFragment fragment = new DatePickerFragment();
        fragment.show(getSupportFragmentManager(),"date");

    }

private void setDate(final Calendar calendar){
    final DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);
            date_pic.setText(dateFormat.format(calendar.getTime()));

}




    @Override
    public void onDateSet(DatePicker view, int year, int month, int day) {

        Calendar calendar = new GregorianCalendar(year,month,day);
        setDate(calendar);
    }


    public static class DatePickerFragment extends android.support.v4.app.DialogFragment{
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month =  calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            return new DatePickerDialog(getActivity(),(DatePickerDialog.OnDateSetListener)getActivity(),year,month,day);
        }
    }
}
