package com.gapestation.athleticsapp;

import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class SiteScraping{



    public static void main(String[] args) throws IOException {
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/girls-basketball/home.htm").timeout(6000).get();
        Element ele=d.getElementById("ctl00_NavigationWithContentOverRelated_ContentOverRelated_PageHeaderUserControl_TeamRecord");
        ArrayList<String> resultArray = new ArrayList<>();
        resultArray.add(ele.getElementById("ctl00_NavigationWithContentOverRelated_ContentOverRelated_PageHeaderUserControl_BottomRowOverallRecord").text());
        System.out.println(resultArray);
    }

    public ArrayList<String> getSchedule(String sport) throws IOException {
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/" + sport.toLowerCase() + "/schedule.htm").timeout(6000).get();
        Element ele=d.getElementById("schedule");
        ArrayList<String> resultArray = new ArrayList<>();
        Elements inputElements = ele.getElementsByTag("tr");
        try {
            for (Element inputElement : inputElements) {
                String score = inputElement.getElementsByClass("score").text();
                String opponent = inputElement.getElementsByClass("contest-type-indicator").text();
                resultArray.add(opponent + " - " + score+ "; ");
            }
            return resultArray;
        }
        catch (java.lang.NullPointerException exception){
            return resultArray;
        }
    }

    public ArrayList<String> getRoster(String sport) throws IOException {
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/" + sport.toLowerCase() + "/roster.htm").timeout(6000).get();
        Element ele=d.getElementById("roster");
        ArrayList<String> resultArray = new ArrayList<>();
        try {
            Elements inputElements = ele.getElementsByTag("tr");
            for (Element inputElement : inputElements) {
                String name = inputElement.getElementsByClass("name").text();
                String jerseyNumber = inputElement.getElementsByClass("jersey").text();
                resultArray.add(jerseyNumber + " " + name + "; ");
            }
            return resultArray;
        }
        catch (java.lang.NullPointerException exception){
            return resultArray;
        }
    }

    public String getRecord(String sport) throws IOException {
        Document d= Jsoup.connect("https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/" + sport.toLowerCase() + "/home.htm").timeout(6000).get();
        Element ele=d.getElementById("ctl00_NavigationWithContentOverRelated_ContentOverRelated_PageHeaderUserControl_TeamRecord");
        String resultArray = " ";
        try {
            resultArray = (ele.getElementById("ctl00_NavigationWithContentOverRelated_ContentOverRelated_PageHeaderUserControl_BottomRowOverallRecord").text());
            System.out.println(resultArray);
            return ("(" + resultArray + ")");
        }
        catch (java.lang.NullPointerException exception){
            return resultArray;
        }
    }

}
