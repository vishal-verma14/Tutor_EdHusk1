package com.example.vishal.tutor_edhusk;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.vishal.tutor_edhusk.BlurBuilder.BlurBuilder;
import com.github.jlmd.animatedcircleloadingview.AnimatedCircleLoadingView;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;
import com.sothree.slidinguppanel.SlidingUpPanelLayout;

public class SignInActivity extends AppCompatActivity {

    private Button google_sign;
    private static final int RC_SIGN_IN = 9001;
    private static final String TAG = "SignInActivity";

    private GoogleApiClient mGoogleApiClient;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthStateListener;
    SharedPreferences.Editor editor;

    RelativeLayout relativeLayout1, relativeLayout2;


    public static final String MyPREFERENCES = "MyPrefs" ;

    AnimatedCircleLoadingView animatedCircleLoadingView;

    SlidingUpPanelLayout slide_up;


    ImageView Splash;
    private String email_user;
    private String name_user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);


        Splash = (ImageView) findViewById (R.id.imageView2);
        Bitmap splashBit = BlurBuilder.blur (this, BitmapFactory.decodeResource (getResources (),R.drawable.splash_img));
        Splash.setImageBitmap (splashBit);

        relativeLayout1  = (RelativeLayout) findViewById (R.id.rl1);
        relativeLayout2 = (RelativeLayout) findViewById (R.id.rl2);

        animatedCircleLoadingView = (AnimatedCircleLoadingView) findViewById (R.id.circle_loading_view);


        slide_up = (SlidingUpPanelLayout) findViewById (R.id.slide_up);

        ImageView imageView = (ImageView) findViewById (R.id.imageView) ;
        imageView.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                slide_up.setPanelState (SlidingUpPanelLayout.PanelState.EXPANDED);

            }
        });


        google_sign = (Button) findViewById(R.id.google_sign_in);

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mAuth = FirebaseAuth.getInstance();
        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if (firebaseAuth.getCurrentUser() != null){
                    startActivity(new Intent(SignInActivity.this,Landing_page.class));
                    overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                }
            }
        };

        mGoogleApiClient = new GoogleApiClient.Builder(getApplicationContext()).enableAutoManage(
                this, new GoogleApiClient.OnConnectionFailedListener() {
                    @Override
                    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
                        Toast.makeText(SignInActivity.this, "erroroccured", Toast.LENGTH_SHORT).show();
                    }
                }).addApi(Auth.GOOGLE_SIGN_IN_API, gso).build();
        google_sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();

            }
        });



        relativeLayout1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View view) {
                slide_up.setPanelState (SlidingUpPanelLayout.PanelState.EXPANDED);

            }
        });


        panelListener ();


    }



    private void signIn() {
        Intent signInIntent = Auth.GoogleSignInApi.getSignInIntent(mGoogleApiClient);
        startActivityForResult(signInIntent, RC_SIGN_IN);







    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null){ updateUI(currentUser);}




        mAuth.addAuthStateListener(mAuthStateListener);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            GoogleSignInResult result = Auth.GoogleSignInApi.getSignInResultFromIntent(data);
            if (result.isSuccess()) {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = result.getSignInAccount();
                startActivity(new Intent(SignInActivity.this,Landing_page.class));
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                firebaseAuthWithGoogle(account);
            } else {
                // Google Sign In failed, update UI appropriately
                // ...
            }
        }

    }


    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {
        Log.d(TAG, "firebaseAuthWithGoogle:" + acct.getId());

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            startActivity(new Intent(SignInActivity.this,Landing_page.class));
                            overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                            updateUI(user);

                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(SignInActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });
    }

    private void updateUI(FirebaseUser user) {
        if (user != null) {

            editor = getSharedPreferences(MyPREFERENCES, MODE_PRIVATE).edit();


            email_user = getString(R.string.google_status_fmt, user.getEmail());
            editor.putString("email", email_user);


            name_user = getString(R.string.google_status_fmt, user.getDisplayName());
            editor.putString("name", name_user);
            Toast.makeText(getApplicationContext(),name_user,Toast.LENGTH_SHORT).show();


            String url = getString(R.string.google_status_fmt, user.getPhotoUrl());
            editor.putString("url", url);


//            Uri photoUri = user.getPhotoUrl();
//
//            if(photoUri != null){
//                editor.putString("uri",photoUri.toString());
//            }else
//            {
//                Toast.makeText(getApplicationContext(),"error in reciveing image url",Toast.LENGTH_SHORT).show();
//            }

            editor.apply();


        }
    }
    public void panelListener () {

        slide_up.setPanelSlideListener (new SlidingUpPanelLayout.PanelSlideListener () {

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
