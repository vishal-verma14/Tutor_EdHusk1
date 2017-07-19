package com.example.vishal.tutor_edhusk.Model;

/**
 * Created by apple on 15/07/17.
 */

public class Notification_model {

    public Notification_model (int _Notification_id, String _Notification_header, String notification_body) {
        this._Notification_id = _Notification_id;
        this._Notification_header = _Notification_header;
        Notification_body = notification_body;
    }

    public Notification_model (String _Notification_header, String notification_body) {
        this._Notification_header = _Notification_header;
        Notification_body = notification_body;
    }

    int _Notification_id;
    String _Notification_header;
    String Notification_body;


    public Notification_model () {
    }

    public int get_Notification_id () {
        return _Notification_id;
    }

    public void set_Notification_id (int _Notification_id) {
        this._Notification_id = _Notification_id;
    }

    public String get_Notification_header () {
        return _Notification_header;
    }

    public void set_Notification_header (String _Notification_header) {
        this._Notification_header = _Notification_header;
    }

    public String getNotification_body () {
        return Notification_body;
    }

    public void setNotification_body (String notification_body) {
        Notification_body = notification_body;
    }



}
