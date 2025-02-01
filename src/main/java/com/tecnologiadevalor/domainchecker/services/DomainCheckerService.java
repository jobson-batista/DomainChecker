package com.tecnologiadevalor.domainchecker.services;

import com.tecnologiadevalor.domainchecker.enums.RecordType;
import com.tecnologiadevalor.domainchecker.enums.URLS;
import com.tecnologiadevalor.domainchecker.utils.Utils;
import io.github.cdimascio.dotenv.Dotenv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DomainCheckerService {

    Dotenv dotenv = Dotenv.load();

    private final String apiKey = dotenv.get("API_KEY");
    private final String apiSecret = dotenv.get("SECRET_KEY");

    String currentDirectory = System.getProperty("user.dir");
    String filePathOutputV2 = currentDirectory + "/src/main/resources/output/domains-available.txt";

    Logger log = LogManager.getLogger(DomainCheckerService.class);
    Utils util = new Utils();

    public DomainCheckerService() {
    }

    public void check(String filePath) throws IOException, InterruptedException {
        log.info("Running Domain Check ...");
        StringBuilder result = new StringBuilder();
        List<String> domains = readFileDomains(filePath);
        for (String domain : domains) {
            if (isAvailableDomain(util.formatString(domain).replace(" ", ""))) {
                log.info("[Available]\t{}\t in {}", domain, domain.contains(".com.br") ? "Registro BR" : "GoDaddy");
                result.append(domain).append("\n");
            }
        }

        util.saveFile(filePathOutputV2, result.toString());
        log.info("File Saved in {}", filePathOutputV2);
    }

    public String getUrlBase(RecordType type) {
        if (type.equals(RecordType.GODADDY)) {
            return URLS.GODADDY_OTE_BASE.getValue() + URLS.GODADDY_AVALIABLE.getValue();
        }
        return URLS.REGISTRO_BR_BASE.getValue() + URLS.REGISTRO_BR_DOMAIN_URL.getValue();
    }

    public boolean isAvailableDomain(String domain) throws IOException, InterruptedException {
        String authHeader = "sso-key " + apiKey + ":" + apiSecret;
        String uriString = "";
        if (domain.contains(".com.br")) {
            uriString = getUrlBase(RecordType.REGISTRO_BR) + "/" + domain;
        } else {
            uriString = getUrlBase(RecordType.GODADDY) + "?domain=" + domain;
        }
        URI uri = URI.create(uriString);
        try {
            HttpClient client = HttpClient.newBuilder()
                    .followRedirects(HttpClient.Redirect.NORMAL)
                    .connectTimeout(Duration.ofSeconds(20))
                    .build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(uri)
                    .timeout(Duration.ofMinutes(2))
                    .header("Accept", "application/json")
                    .header("Authorization", authHeader)
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            client.close();
            if (domain.contains(".com.br")) {
                return response.statusCode() == 404;
            }
            return response.body().contains("\"available\":true");
        } catch (IllegalArgumentException e) {
            if (log.isErrorEnabled()) {
                log.error("Error to request at {}", uri.toString());
                log.error(e.getMessage());
            }
            return false;
        }
    }

    private List<String> readFileDomains(String filePath) {

        String currentDirectory = System.getProperty("user.dir");
        if (filePath == null) {
            filePath = currentDirectory + "/src/main/resources/output/artists.txt";
        } else {
            filePath = currentDirectory + "/" + filePath;
        }
        log.info("Reading file... {}", filePath);
        List<String> domains = new ArrayList<>();

        try (BufferedReader buff = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = buff.readLine()) != null) {
                domains.add(line);
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        return domains;
    }


}