package com.tecnologiadevalor.domainchecker;

import com.tecnologiadevalor.domainchecker.services.DomainCheckerService;
import com.tecnologiadevalor.domainchecker.services.WebScraper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

public class Main {

    static Logger log = LogManager.getLogger(WebScraper.class);

    public static void main(String[] args) throws IOException, InterruptedException {

        DomainCheckerService service = new DomainCheckerService();
        WebScraper scraper = new WebScraper();

        log.info("Scraper inicialized...");
        scraper.start();
        log.info("Checking if it is available ...");
        service.check();
    }
}