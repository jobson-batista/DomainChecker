package com.tecnologiadevalor.domainchecker.services;

import com.tecnologiadevalor.domainchecker.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;

public class WebScraper {

    String page = "https://kworb.net/spotify/artists.html";
    Logger log = LogManager.getLogger(WebScraper.class);

    String currentDirectory  = System.getProperty("user.dir");
    String filePathOutputV2 = currentDirectory + "/src/main/resources/output/artists.txt";

    Utils util = new Utils();

    public void start() {
        try {
            log.info("[Reading Page Web]\t{}", page);
            Document doc = Jsoup.connect(page).get();

            StringBuilder result = new StringBuilder();

            Elements links = doc.select("td").select("div").select("a[href]");
            for (Element link : links) {
                result.append(util.formatString(link.text())).append(".com\n");
            }
            util.saveFile(filePathOutputV2, result.toString() );
            log.info("File saved in {}", filePathOutputV2);
        } catch (IOException e) {
            log.error(e.getMessage());
        }

    }

}
