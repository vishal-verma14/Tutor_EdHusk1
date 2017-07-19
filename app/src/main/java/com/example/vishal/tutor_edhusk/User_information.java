package com.example.vishal.tutor_edhusk;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.vishal.tutor_edhusk.User_information_sub.Bank_Detail;
import com.example.vishal.tutor_edhusk.User_information_sub.Expertise;
import com.example.vishal.tutor_edhusk.User_information_sub.Qualification;
import com.example.vishal.tutor_edhusk.User_information_sub.personal_info;

public class User_information extends AppCompatActivity implements View.OnClickListener {

    LinearLayout profile_ly,expertise_ly,bank_ly,qualification_ly;
    final Context context = this;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_user_information);


        profile_ly = (LinearLayout) findViewById (R.id.ui_Quilification_ly);
        profile_ly.setOnClickListener (this);

        expertise_ly = (LinearLayout) findViewById (R.id.ui_expertise_ly);
        expertise_ly.setOnClickListener (this);

        bank_ly = (LinearLayout) findViewById (R.id.ui_bank_information_ly);
        bank_ly.setOnClickListener (this);

        qualification_ly = (LinearLayout) findViewById (R.id.ui_profile_ly);
        qualification_ly.setOnClickListener (this);

//        buildDialog (R.style.DialogAnimation_2,"up-down Animation");


    }

    @Override
    public void onClick (View view) {
        switch (view.getId ()){

            case R.id.ui_profile_ly:

                Intent quli = new Intent(User_information.this, personal_info.class);

                // Starts TargetActivity

                startActivity(quli);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;


            case R.id.ui_expertise_ly:
                Intent Exp = new Intent(User_information.this, Expertise.class);

                // Starts TargetActivity

                startActivity(Exp);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);


                break;

            case R.id.ui_bank_information_ly:
                Intent bank = new Intent(User_information.this, Bank_Detail.class);

                // Starts TargetActivity

                startActivity(bank);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;

            case R.id.ui_Quilification_ly:
                Intent profile = new Intent(User_information.this, Qualification.class);

                // Starts TargetActivity

                startActivity(profile);
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

                break;

        }



    }
    private void buildDialog(int animationSource, String type) {
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setTitle("Animation Dialog");
//        builder.setMessage(type);
//
//        builder.setNegativeButton("OK", null);
//        AlertDialog dialog = builder.create();
//        dialog.getWindow().getAttributes().windowAnimations = animationSource;
//        dialog.show();

        final Dialog dialog = new Dialog(context);
        dialog.requestWindowFeature (Window.FEATURE_NO_TITLE);

        dialog.setContentView(R.layout.profile_dashboard_alert_box);

        // set the custom dialog components - text, image and button

//        ImageView dialod_back = (ImageView) dialog.findViewById (R.id.pd_imge_alert);
//        Bitmap dialogBlur = BlurBuilder.blur (this,BitmapFactory.decodeResource (getResources (),R.drawable.splash_img));
//        dialod_back.setImageBitmap (dialogBlur);



        Button dialogButton = (Button) dialog.findViewById(R.id.alert_button_dismiss);
        // if button is clicked, close the custom dialog
        dialogButton.setOnClickListener(new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });



        dialog.getWindow ().getAttributes ().windowAnimations = animationSource;

        dialog.show();
    }

}
