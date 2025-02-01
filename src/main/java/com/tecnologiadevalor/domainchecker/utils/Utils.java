package com.tecnologiadevalor.domainchecker.utils;

import lombok.NoArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.Normalizer;

@NoArgsConstructor
public class Utils {

    Logger log = LogManager.getLogger(Utils.class);

    public String formatString(String text) {
        return Normalizer.normalize(text, Normalizer.Form.NFD)
                .replaceAll("\\p{M}", "")
                .replaceAll("\\$", "s")
                .toLowerCase();
    }

    public void saveFile(String fileName, String content) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            log.error(e.toString());
        }
    }
}
