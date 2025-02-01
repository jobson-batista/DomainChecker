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

        if (args.length < 2 && !"-d".equals(args[0])) {
            log.info("Usage With File: java -jar domain-checker.jar -f <path/file.txt>");
            log.info("Usage Default Mode: java -jar domain-checker.jar -d");
        } else if ("-f".equals(args[0])) {
            log.info("Checking domains file ...");
            service.check(args[1]);
        } else if ("-d".equals(args[0])) {
            log.info("Scraper started ...");
            scraper.start();
            log.info("Checking domains in website ...");
            service.check(null);
        }

    }
}