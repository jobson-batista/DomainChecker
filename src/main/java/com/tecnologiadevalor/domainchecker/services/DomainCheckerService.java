package com.tecnologiadevalor.domainchecker.services;

import com.tecnologiadevalor.domainchecker.enums.URLS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DomainCheckerService {

    private final String apiKey = "YOUR_API_KEY_GODADDY";
    private final String apiSecret = "YOUT_API_SECRET_GODADDY";

    Logger log = LogManager.getLogger(DomainCheckerService.class);


    private List<String> domains;

    public DomainCheckerService() {

    }

    public void check() {
        System.out.println("Running Domain Check ...");
        domains = readFileDomains();
        for(String domain : domains) {
            domain = domain.replaceAll("[^a-zA-Z0-9.]", "");
            if(isAvailableDomain(domain)) {
                //System.out.println("\t[Available]\t\t" + domain);
                log.info("[Avaliable]\t" + domain);
            }
        }

    }

    public String getUrlBase() {
        return URLS.GODADDY_OTE_BASE.getValue() + URLS.GODADDY_AVALIABLE.getValue();
    }

    public boolean isAvailableDomain(String domain) {
        String authHeader = "sso-key " + apiKey + ":" + apiSecret;
        try {
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(getUrlBase() + "?domain=" + domain))
                    .timeout(Duration.ofMinutes(2))
                    .header("Accept", "application/json")
                    .header("Authorization", authHeader)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            client.close();
            return response.body().contains("\"available\":true");
        } catch (Exception e ) {
            e.printStackTrace();
            return false;
        }
    }

    private List<String> readFileDomains() {

        String diretorioAtual = Paths.get("").toAbsolutePath().toString();
        System.out.println("Diretório atual: " + diretorioAtual);
        String filePath = "/Users/eniac/Projects/tecnologiadevalor/DomainChecker/src/main/resources/input/domains.txt";
        System.out.println("Reading file... " + filePath);
        List<String> domains = new ArrayList<>();

        try(BufferedReader buff = new BufferedReader(new FileReader(filePath))) {
            String line;
            while( (line = buff.readLine()) != null) {
                domains.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return domains;
    }
}