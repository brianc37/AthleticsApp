package com.gapestation.athleticsapp;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;

public class SiteScraping {

    private static final String baseUrl = "https://www.maxpreps.com/high-schools/dover-eagles-(dover,pa)/baseball/home.htm";

    public static void main(String[] args){
        WebClient client = new WebClient();

        client.getOptions().setJavaScriptEnabled(false);
        client.getOptions().setCssEnabled(false);
        client.getOptions().setUseInsecureSSL(true);

        try{
            HtmlPage page = client.getPage(baseUrl);
            System.out.println(page.asXml());
        } catch(IOException e){
            e.printStackTrace();
        }

    }

}

