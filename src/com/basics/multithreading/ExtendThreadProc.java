package com.basics.multithreading;


import static com.basics.multithreading.ThreadColor.ANSI_BLACK;
import static com.basics.multithreading.ThreadColor.ANSI_BLUE;
import static com.basics.multithreading.ThreadColor.ANSI_RED;

class RunnerThread1 extends Thread {
    public void startRunning(){
        for (int i=0;i<10;i=i+2){
            System.out.println(ANSI_BLUE+"Runner1 is printing "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        startRunning();
    }
}

class RunnerThread2 extends Thread{
    public void startRunning(){
        for (int i=1;i<10;i=i+2){
            System.out.println(ANSI_RED+"Runner2 is printing "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void run() {
        startRunning();
    }
}

public class ExtendThreadProc {

    public static void main(String[] args) throws InterruptedException {
        // write your code here

        Thread t1=new RunnerThread1();
        Thread t2=new RunnerThread2();
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(ANSI_BLACK+"Tasks finshed..>main thread ending");

    }
}
