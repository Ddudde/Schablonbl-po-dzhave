package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.*;

@Component
public class Hashd {

    @Autowired
    private ApplicationArguments args;
    private String hash;

    public Hashd() {
        this.hash = "";
    }

    @PostConstruct
    public void init() throws IOException {
        try (InputStream inputFile = new FileInputStream(args.getNonOptionArgs().get(0) +
                ".txt")) {
            hash = DigestUtils.md5DigestAsHex(inputFile);
            File outputFile = new File(args.getNonOptionArgs().get(1) + ".txt");
            if (!outputFile.exists()) outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile);
            writer.write(hash);
            writer.close();
        } catch (FileNotFoundException e) {
            File outputFile = new File(args.getNonOptionArgs().get(1) + ".txt");
            if (!outputFile.exists()) outputFile.createNewFile();
            FileWriter writer = new FileWriter(outputFile);
            writer.write("null");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PreDestroy
    public void deleteInputFile() {
        File inputFile = new File(args.getNonOptionArgs().get(0) + ".txt");
        if (inputFile.exists()) {
            inputFile.delete();
        }
    }
}