package com.example.vishal.tutor_edhusk.Model;

/**
 * Created by apple on 14/07/17.
 */

public class expertise_model {

    String name;
    int value;

    public expertise_model (String name, int value){
        this.name = name;
        this.value = value;
    }
    public String getName(){
        return this.name;
    }
    public int getValue(){
        return this.value;
    }

}
