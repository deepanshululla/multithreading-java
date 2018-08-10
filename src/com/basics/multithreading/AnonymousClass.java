package com.basics.multithreading;

import static com.basics.multithreading.ThreadColor.ANSI_BLUE;
import static com.basics.multithreading.ThreadColor.ANSI_CYAN;
import static com.basics.multithreading.ThreadColor.ANSI_RED;
import static java.lang.Thread.currentThread;

public class AnonymousClass {
    public static void main(String[] args) {

        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(ANSI_RED+"Hello from the  runnable "+currentThread().getName());
            }
        });
        t1.setName("t1");
        t1.start();
        System.out.println(ANSI_BLUE+"Hello from main thread");
        new Thread(() -> System.out.println(ANSI_CYAN+"Hello from non runnable thread")).start();
    }
}
