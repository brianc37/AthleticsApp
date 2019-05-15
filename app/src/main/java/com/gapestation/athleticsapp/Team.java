package com.gapestation.athleticsapp;

import java.util.ArrayList;

public class Team {
    Integer mWins;
    Integer mLosses;
    ArrayList<String> mRoster;
    String mSport;

    public Team(String sport){
        mSport = sport;
    }

    public Integer getWins() {
        return mWins;
    }

    public void setWins(Integer wins) {
        mWins = wins;
    }

    public Integer getLosses() {
        return mLosses;
    }

    public void setLosses(Integer losses) {
        mLosses = losses;
    }
}