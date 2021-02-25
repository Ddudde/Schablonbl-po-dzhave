package com.work.package4;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class Pelbmenb{
    private int cout = 0;
    private ExecutorService exe;

    public Pelbmenb(int cout) {
        this.cout = cout;
        exe = Executors.newFixedThreadPool(cout);
        exe.submit(() -> {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("1");
        });
        exe.submit(() -> System.out.println("2"));
    }

}
