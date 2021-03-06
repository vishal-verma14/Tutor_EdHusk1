package com.example.vishal.tutor_edhusk.Model;

import android.view.View;

import java.util.List;

/**
 * Created by vishal on 19/06/17.
 */

public class Student_data {



    private View.OnClickListener requestBtnClickListener;
    /**
     * Board : CBSE
     * Type : In a Batch
     * Travel : 0 - 1 Km
     * subjects : []
     * days : [1]
     * slots : [12]
     * Location : At tutor's location
     * Gender : Male
     * Name : Anuj1
     * Standard : Class 6
     * Address : Nai Dilli, Delhi
     * id : 1
     * Created_At : 2017-07-07T05:50:29.290221
     * Price_Range : 1
     * Lat : 26.911584
     * Long : 75.735393
     */

        private String Board;
        private String Type;
        private String Travel;
        private String Location;
        private String Gender;
        private String Name;
        private String Standard;
        private String Address;
        private int id;
        private String Created_At;
        private String Price_Range;
        private String Lat;
        private String Long;
        private String subjects;
        private String days;
        private String slots;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

        public Student_data(String name, String standard, String address, int id, String price_Range, String subjects, String status) {
            this.Name = name;
            this.Standard = standard;
            this.Address = address;
            this.id = id;
            this.Price_Range = price_Range;
            this.subjects = subjects;
            this.status = status;
        }

    public Student_data(){}




    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }


    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }


    public String getBoard() {
        return Board;
    }

    public void setBoard(String Board) {
        this.Board = Board;
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getTravel() {
        return Travel;
    }

    public void setTravel(String Travel) {
        this.Travel = Travel;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getContentName() {
        return Name;
    }

    public void setContentName(String Name) {
        this.Name = Name;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String Standard) {
        this.Standard = Standard;
    }

    public void setContentStandard(String Standard) {
        this.Standard = Standard;
    }

    public String getContentStandard() {
        return Standard;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getContentAddress() {
        return Address;
    }

    public void ContentsetAddress(String Address) {
        this.Address = Address;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreated_At() {
        return Created_At;
    }

    public void setCreated_At(String Created_At) {
        this.Created_At = Created_At;
    }

    public String getPrice_Range() {
        return Price_Range;
    }

    public void setPrice_Range(String Price_Range) {
        this.Price_Range = Price_Range;
    }

    public String getContentPrice_Range() {
        return Price_Range;
    }

    public void setContentPrice_Range(String Price_Range) {
        this.Price_Range = Price_Range;
    }

    public String getLat() {
        return Lat;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public String getLong() {
        return Long;
    }

    public void setLong(String Long) {
        this.Long = Long;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }


    public String getContentSubjects() {
        return subjects;
    }

    public void setContentSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getSlots() {
        return slots;
    }

    public void setSlots(String slots) {
        this.slots = slots;
    }
}
