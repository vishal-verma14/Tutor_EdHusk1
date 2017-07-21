package com.example.vishal.tutor_edhusk.FCM;

/**
 * Created by vishal on 25/06/17.
 */
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.vishal.tutor_edhusk.Contacted_student.Selected_Application;
import com.example.vishal.tutor_edhusk.R;
import com.google.firebase.messaging.RemoteMessage;
import com.example.vishal.tutor_edhusk.DatabaseHandler.Notification_Database_Handler;
import com.example.vishal.tutor_edhusk.Model.Notification_model;

import java.util.List;

public class MyFirebaseMessagingService extends com.google.firebase.messaging.FirebaseMessagingService {

    private static final String TAG = "Android News App";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

        //It is optional
        Log.e(TAG, "From: " + remoteMessage.getFrom());
        Log.e(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        Notification_Database_Handler db = new Notification_Database_Handler (this);
        Log.d ("Insert: ", "Inserting ..");
        db.addNotification (new Notification_model (remoteMessage.getNotification().getTitle(),  remoteMessage.getNotification().getBody()));


        // Reading all notification
        Log.d ("Reading: ", "Reading all contacts..");
        List<Notification_model> notifications = db.getAllNotification ();

        for (Notification_model nt : notifications) {
            String log = "Id: " + nt.get_Notification_id () + " ,header: " + nt.get_Notification_header () + " ,body: " + nt.getNotification_body ();
            // Writing notification to log
            Log.d ("Name: ", log);

        }

//Calling method to generate notification
        sendNotification(remoteMessage.getNotification().getTitle(), remoteMessage.getNotification().getBody());
    }





    //This method is only generating push notification
    private void sendNotification(String title, String messageBody) {
        Intent intent = new Intent(this, Selected_Application.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        title = "Edhusk";

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.address_icon)
                .setContentTitle(title)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

}