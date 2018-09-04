package parsers;

//import org.htmlcleaner.*;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class ParsedUPS {

    private final String trackingLink="https://wwwapps.ups.com/tracking/tracking.cgi?tracknum=";
    private final String trackingDetailsLink="https://wwwapps.ups.com/WebTracking/detail?multiship=true&loc=en_US&datakey=line1&progressIsLoaded=Y&shipmentsAreLoaded=N&showPkgProgress=true&showAsscShipments=false&showAssociatedPkgs1=true&HIDDEN_FIELD_SESSION=";
    private final String trackingNumber;

    private String tr_status;
    private String tr_date;
    private String tr_weight;
    private int tr_count;

    public ParsedUPS(String s) {
        this.trackingNumber = s;
        this.tr_weight = null;
        this.tr_count = 1;
    }

    public void run() throws MalformedURLException, IOException {
        System.out.println("Track: " + trackingNumber);
        //File file = new File("1ZA3W8760362754668.html");

        Document doc = Jsoup.connect(trackingLink + trackingNumber).get();
        //Document doc = Jsoup.parse(file, "UTF-8");

        // статус трека
        Element elem0 = doc.select("div.pkgstep1 h3").first();
        tr_status = elem0.html(); // this.tr_status;

        // дата статуса
        elem0 = doc.select("div.seccol18 div.secBody div.marginBegin dl dd").first();
        tr_date = elem0.html(); // this.tr_date;

        // вес и количество коробок
        Element additional = doc.select("div.seccol18 div.secLvl.gradientGroup7.module1 div.secBody").first();
        Elements items = additional.select("dl dt>label,dd"); //dt label, dd

        boolean weightFound = false;
        boolean multiplePackagesFound = false;

        for (Element e : items)
        {
            String nodeText = e.html();
            String tagName = e.tagName();

            if (multiplePackagesFound) {
                this.tr_count = Integer.valueOf(nodeText);
                multiplePackagesFound = false;
                continue;
            }

            if (weightFound) {
                this.tr_weight = nodeText;
                weightFound = false;
                continue;
            }

            if ((tagName.equals("label"))&&(nodeText.contains("Multiple Packages")))
                multiplePackagesFound = true;

            if ((tagName.equals("label"))&&(nodeText.contains("Weight")))
                weightFound = true;
        }

        String[] lines = doc.select("#progressFormid").html().split("\n");
        String fullTag = null;
        for (String s : lines)
            if (s.contains("<input"))
                if (s.contains("HIDDEN_FIELD_SESSION")){
                    fullTag = s;
                    break;
                }

        int pos = fullTag.indexOf("value=");
        String reqTag = fullTag.substring(pos+7,fullTag.length()-3);
        System.out.println("tag:_" + reqTag);

        /*
        doc = Jsoup.connect(trackingDetailsLink + reqTag).get();
        // остальные треки
        additional = doc.select("div.seccol18 div.secLvl.gradientGroup7.module1 div.secBody").first();
        items = additional.select("*"); //dt label, dd
        for (Element e : items)
            System.out.println("extra:" + e.html());
        */




        System.out.println("tag:_" + reqTag);




        this.print();
    }

    private void print()
    {
        // статус
        System.out.println("Status: " + tr_status);
        // дата
        System.out.println("Date: " + tr_date);
        // вес
        System.out.println("Weight: " + tr_weight);
        // вытаскиваем список дополнительных треков (если есть)
        System.out.println("Package count: " + tr_count);
    }



}
