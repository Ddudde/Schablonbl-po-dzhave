package com.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
@Service
public class Schedule implements ScheduleMXBean {

    @Autowired
    private DepartureController departureController;

    @Autowired
    private PostOfficeController postOfficeController;

    @ManagedOperation
    @Scheduled(cron = "0 0/30 * * * *")
    public void doScheduledTask() throws IOException {
        log.info("Плановый бэкап...");
        log.info("Очистка директории...");
        String abspath = System.getProperty("user.dir");
        File index = new File(abspath + "\\backups");
        String[] entries = index.list();
            for(String s: entries)
            {
                log.info(s);
                Files.delete(Paths.get(abspath + "\\backups\\" + s));
            }
        log.info("Очистка директории успешно завершена!");
        log.info("Загрузка бэкапов...");
        for (String s: departureController.getAll()) {
            FileWriter writer = new FileWriter(new File(index.getPath() + "\\dep.txt"), true);
            writer.write(s);
            writer.append('\n');
            writer.flush();
            writer.close();
        }
        for (String s: postOfficeController.getAll()) {
            FileWriter writer = new FileWriter(new File(index.getPath() + "\\post.txt"), true);
            writer.write(s);
            writer.append('\n');
            writer.flush();
            writer.close();
        }
        log.info("Загрузка бэкапов успешно завершена!");
    }
}
