package com.gapestation.athleticsapp;

import java.util.ArrayList;

public class Team extends SiteScraping {
    Integer mWins;
    Integer mLosses;
    ArrayList<String> mRoster;
    String mSport;
    public DownloadThread downloadThread;

    public Team(String sport) {
        //mSport = sport;
        downloadThread = new DownloadThread(this);
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