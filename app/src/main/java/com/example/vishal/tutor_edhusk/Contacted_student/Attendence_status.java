package com.example.vishal.tutor_edhusk.Contacted_student;

/**
 * Created by apple on 10/07/17.
 */

public class Attendence_status {

    private static String  status;
    public String Name;
    public String email;
    public String phone_num;
//    public String status;

    public Attendence_status(){

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getPhone_num() {
        return phone_num;
    }

    public void setPhone_num(String phone_num) {
        this.phone_num = phone_num;
    }

    public static String getStatus () {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
