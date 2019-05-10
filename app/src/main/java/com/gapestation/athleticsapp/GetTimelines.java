package com.gapestation.athleticsapp;


import android.net.wifi.WifiConfiguration;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.conf.ConfigurationBuilder;

public class GetTimelines {
    public static void main(String[] args) throws TwitterException {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(String.valueOf(R.string.consumerKey))
                .setOAuthConsumerSecret(String.valueOf(R.string.consumerSecret))
                .setOAuthAccessToken(String.valueOf(R.string.accessToken))
                .setOAuthAccessTokenSecret(String.valueOf(R.string.accessTokenSecret));

        Twitter tf = new TwitterFactory(cb.build()).getInstance();
        List<Status> statuses = tf.getHomeTimeline();
        System.out.println("Showing home timeline.");
        for (Status status : statuses) {
            System.out.println(status.getUser().getName() + ":" +
                    status.getText());
        }
    }
}
