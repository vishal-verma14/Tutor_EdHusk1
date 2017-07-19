package com.example.vishal.tutor_edhusk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.vishal.tutor_edhusk.Contacted_student.MyApplication;
import com.example.vishal.tutor_edhusk.Fragment.Contacted_Fragment;
import com.example.vishal.tutor_edhusk.Fragment.NewsFeed_Feagment;
import com.example.vishal.tutor_edhusk.Fragment.Notification_fragment;
import com.google.firebase.auth.FirebaseAuth;

public class Landing_page extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,NewsFeed_Feagment.NewsFeed_Feagment_transfer{

    Fragment selectedFragment = null;

    private FirebaseAuth mAuth;
    public static final String MyPREFERENCES = "MyPrefs" ;

    SharedPreferences sharedPreferences;


    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {

            switch (item.getItemId()) {
                case R.id.newsfeed:
                    selectedFragment =  NewsFeed_Feagment.newInstance();
                    break;
                case R.id.notification:
                    selectedFragment =  Notification_fragment.newInstance();

                    break;

                case R.id.contacted:
                    selectedFragment =  Contacted_Fragment.newInstance();
                    break;
            }
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.content,selectedFragment);
            transaction.commit();
            return true;
        }
    };


    @Override
    protected void onCreate(final Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_landing_page);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);


        toggle.syncState();






        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        View navHeaderView = navigationView.inflateHeaderView(R.layout.nav_header_landing_page);

        ImageView userImage = (ImageView) navHeaderView.findViewById(R.id.nav_user_image);

//        TextView username = (TextView) navHeaderView.findViewById(R.id.nav_user_name);
//
//        TextView useremail = (TextView) navHeaderView.findViewById(R.id.nav_user_email);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content,NewsFeed_Feagment.newInstance());
        transaction.commit();

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() == null){

                    startActivity(new Intent(Landing_page.this,SignInActivity.class));
                }
            }
        };


        sharedPreferences = getSharedPreferences(MyPREFERENCES,MODE_PRIVATE);



        String url = sharedPreferences.getString("url","Error in getting url");
        Glide.with(this).load(url).thumbnail(0.8f).into(userImage);


    }

    @Override
    protected void onStart() {
        super.onStart();

        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_landing_page_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.home) {
            // Handle the camera action
            selectedFragment =  Notification_fragment.newInstance();

        } else if (id == R.id.account) {

            startActivity(new Intent(Landing_page.this, MyApplication.class));


        } else if (id == R.id.history) {


        } else if (id == R.id.change_bank_detail) {


        } else if (id == R.id.change_password) {


        } else if (id == R.id.contact) {


        }
        else if (id == R.id.log_out) {
            mAuth.signOut();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void setPosition(int i) {
        Contacted_Fragment contacted_fragment = (Contacted_Fragment) getSupportFragmentManager().findFragmentByTag("Contacted_Fragment");
        if (contacted_fragment != null){
            contacted_fragment.setpos(i);
            Log.e("setpos","setpos");

        }else {
            Contacted_Fragment contacted_frag = new Contacted_Fragment();
            Bundle args = new Bundle();
            args.putInt("pos", i);
            contacted_frag.setArguments(args);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content, contacted_frag)
                    .addToBackStack(null).commit();
                        contacted_frag.startpos();
        }
    }
}
