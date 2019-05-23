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

    public  DownloadThread(SiteScraping siteScraping){
        mSiteScraping = siteScraping;


    }

    public void setup(String sport, DataDownloadableListener downloadableListener){
        this.sport = sport;

        downloadResult = new ArrayList<>();
        mDownloadableListener = downloadableListener;
        setup = true;
    }



    @Override
    public void run() {
        if (setup) {
            try {
               downloadResult=mSiteScraping.getSchedule(sport);
               mDownloadableListener.onDataDownloaded(downloadResult);
               downloadResult2 = mSiteScraping.getRoster(sport);
               mDownloadableListener2.onDataDownloaded(downloadResult2);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
