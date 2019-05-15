package com.gapestation.athleticsapp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SiteScraping {

    public static void main(String[] args) throws IOException {
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/lacrosse/roster.htm").timeout(6000).get();
        Element ele=d.getElementById("roster");
        Elements inputElements = ele.getElementsByTag("tr");
        for (Element inputElement : inputElements) {
            String name = inputElement.getElementsByClass("name").text();
            String jerseyNumber = inputElement.getElementsByClass("jersey").text();
            System.out.println(jerseyNumber + " " + name);
        }
    }

    public ArrayList getSchedule(String sport) throws IOException {
        ArrayList<String> Schedule = null;
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/" + sport + "/schedule.htm").timeout(6000).get();
        Element ele=d.getElementById("schedule");
        Elements inputElements = ele.getElementsByTag("tr");
        for (Element inputElement : inputElements) {
            String score = inputElement.getElementsByClass("score").text();
            String opponent = inputElement.getElementsByClass("contest-type-indicator").text();
            Schedule.add(opponent + " " + score);
        }
        return Schedule;
    }
}
