package com.example.hackathon_application;

import android.os.Bundle;

public class DriverClass {

    String name;
    int start, end;
    boolean isSelected = false;

    public DriverClass(String name, int start, int end){
        this.name = name;
        this.start = start;
        this.end = end;
    }

    public int getStart(){
        return start;
    }

    public int getEnd() {
        return end;
    }

    public String getName() {
        return name;
    }

    public void select(){

        isSelected = true;
    }



}
