package com.example.vishal.tutor_edhusk.DatabaseHandler;

/**
 * Created by apple on 15/07/17.
 */

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.ContactsContract;

import com.example.vishal.tutor_edhusk.Model.Notification_model;

public class Notification_Database_Handler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "NotifiationManager";

    // Contacts table name
    private static final String TABLE_NOTIFICATION = "Notification_table";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_N_HEADER = "head";
    private static final String KEY_N_BODY = "body";


    public Notification_Database_Handler (Context context) {
        super (context,DATABASE_NAME,null,DATABASE_VERSION);


    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_NOTIFICATION + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_N_HEADER + " TEXT,"
                + KEY_N_BODY + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    //NotificationID.getID() to get  unique notification

    @Override
    public void onUpgrade (SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTIFICATION);

        // Create tables again
        onCreate(sqLiteDatabase);
    }

   public void addNotification(Notification_model notification_model){

        SQLiteDatabase db = this.getWritableDatabase ();

        ContentValues values = new ContentValues ();
        values.put (KEY_N_HEADER, notification_model.get_Notification_header ());
        values.put (KEY_N_BODY, notification_model.getNotification_body ());


        db.insert (TABLE_NOTIFICATION,null,values);
        db.close ();

    }


    Notification_model getNotification(int id){
        SQLiteDatabase db = this.getReadableDatabase ();

        Cursor cursor = db.query(TABLE_NOTIFICATION, new String[] { KEY_ID,
                        KEY_N_HEADER, KEY_N_BODY }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        assert cursor != null;
        Notification_model notification_model = new Notification_model (Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return notification
        return notification_model;    }

    public List<Notification_model> getAllNotification() {
        List<Notification_model> contactList = new ArrayList<Notification_model>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_NOTIFICATION;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Notification_model notification_model = new Notification_model ();
                notification_model.set_Notification_id (Integer.parseInt(cursor.getString(0)));
                notification_model.set_Notification_header (cursor.getString(1));
                notification_model.setNotification_body (cursor.getString(2));
                // Adding notification to list
                contactList.add(notification_model);
            } while (cursor.moveToNext());
        }

        // return notification list
        return contactList;
    }


    // Updating single notification
    public int updateNotification(Notification_model notification_model) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_N_HEADER, notification_model.get_Notification_header ());
        values.put(KEY_N_BODY, notification_model.getNotification_body ());

        // updating row
        return db.update(TABLE_NOTIFICATION, values, KEY_ID + " = ?",
                new String[] { String.valueOf(notification_model.get_Notification_id ()) });
    }

    // Deleting single notification
    public void deleteNotification(Notification_model notification_model) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTIFICATION, KEY_ID + " = ?",
                new String[] { String.valueOf(notification_model.get_Notification_id ()) });
        db.close();
    }


    // Getting notification Count
    public int getNotificationCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NOTIFICATION;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }


}
