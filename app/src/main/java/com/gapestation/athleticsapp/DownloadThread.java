package com.gapestation.athleticsapp;

import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

public class DownloadThread extends Thread implements Runnable {

    SiteScraping mSiteScraping;
    boolean setup = false;
    String sport;

    ArrayList<String> downloadResult;
    DataDownloadableListener mDownloadableListener;
    ArrayList<String> downloadResult2;
    DataDownloadableListener mDownloadableListener2;
    String downloadResult3;

    public  DownloadThread(SiteScraping siteScraping){
        mSiteScraping = siteScraping;


    }

    public void setup(String sport, DataDownloadableListener downloadableListener){
        this.sport = sport;

        downloadResult = new ArrayList<>();
        mDownloadableListener = downloadableListener;
        mDownloadableListener2 = downloadableListener;
        setup = true;
    }



    @Override
    public void run() {
        if (setup) {
            try {
               downloadResult = mSiteScraping.getSchedule(sport);
               downloadResult2 = mSiteScraping.getRoster(sport);
               downloadResult3 = mSiteScraping.getRecord(sport);
               mDownloadableListener2.onDataDownloaded(downloadResult, downloadResult2, downloadResult3);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
