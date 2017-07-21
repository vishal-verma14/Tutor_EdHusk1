package com.example.vishal.tutor_edhusk.Model;

/**
 * Created by vishalverma on 21/07/17.
 */

public class Selected_student  {

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
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }




    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStandard() {
        return Standard;
    }

    public void setStandard(String standard) {
        Standard = standard;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrice_Range() {
        return Price_Range;
    }

    public void setPrice_Range(String price_Range) {
        Price_Range = price_Range;
    }

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public Selected_student(String name, String standard, String address, int id, String price_Range, String subjects,String status) {
        this.Name = name;
        this.Standard = standard;
        this.Address = address;
        this.id = id;
        this.Price_Range = price_Range;
        this.subjects = subjects;
        this.status = status;
    }
}
