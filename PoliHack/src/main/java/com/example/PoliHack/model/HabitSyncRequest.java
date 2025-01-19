package com.example.PoliHack.model;

import java.util.List;

public class HabitSyncRequest {
    private int year;
    private int month;
    private List<Integer> stateVector;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public List<Integer> getStateVector() {
        return stateVector;
    }

    public void setStateVector(List<Integer> stateVector) {
        this.stateVector = stateVector;
    }
}