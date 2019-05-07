package com.gapestation.athleticsapp;


import android.net.wifi.WifiConfiguration;

import java.util.List;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class GetTimelines {
    public static void main(String[] args) {

        Twitter unauthenticatedTwitter = new TwitterFactory()
                .getInstance();
        System.out.println("Showing public timeline.");
        try {
            List<WifiConfiguration.Status> statuses = unauthenticatedTwitter
                    .getPublicTimeline();
            for (WifiConfiguration.Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
            if (args.length < 2) {
                System.out
                        .println("You need to specify TwitterID/Password combination to show UserTimelines.");
                System.out
                        .println("Usage: java twitter4j.examples.GetTimelines ID Password");
                System.exit(0);
            }

            // Other methods require authentication
            Twitter twitter = new TwitterFactory().getInstance(args[0],
                    args[1]);
            statuses = twitter.getFriendsTimeline();
            System.out.println("------------------------------");
            System.out.println("Showing " + args[0]
                    + "'s friends timeline.");
            for (WifiConfiguration.Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
            statuses = twitter.getUserTimeline();
            System.out.println("------------------------------");
            System.out.println("Showing " + args[0] + "'s timeline.");
            for (Status status : statuses) {
                System.out.println(status.getUser().getName() + ":"
                        + status.getText());
            }
            Status status = twitter.showStatus(81642112l);
            System.out.println("------------------------------");
            System.out.println("Showing " + status.getUser().getName()
                    + "'s status updated at " + status.getCreatedAt());
            System.out.println(status.getText());
            System.exit(0);
        } catch (TwitterException te) {
            System.out.println("Failed to get timeline: "
                    + te.getMessage());
            System.exit(-1);
        }
    }
}
