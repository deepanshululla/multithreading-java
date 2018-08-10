package com.basics.multithreading;

import static com.basics.multithreading.ThreadColor.ANSI_BLUE;
import static com.basics.multithreading.ThreadColor.ANSI_CYAN;
import static com.basics.multithreading.ThreadColor.ANSI_RED;
import static java.lang.Thread.currentThread;

class MyRunnable2 implements Runnable{
    private void startRunning(){
        for (int i=0;i<10;i=i+2){
            System.out.println(ANSI_RED+"Runnable: printing "+i+" from thread name "+currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(ANSI_RED+"Another thread woke me up");
                return;
            }
            System.out.println(ANSI_RED+" 3 seconds done I am back");
        }
    }
    @Override
    public void run() {
        startRunning();
    }
}

class MyThread2 extends Thread{
    private void startRunning(){
        for (int i=0;i<10;i=i+2){
            System.out.println(ANSI_BLUE+"Non Runnable printing "+i+" from thread name "+currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println(ANSI_BLUE+"Another thread woke me up");
//                return;
            }
            System.out.println(ANSI_BLUE+" 2 seconds done I am back");
        }
    }

    @Override
    public void run() {
        startRunning();
    }
}
public class Joins {
    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable2());
        t1.setName("t1");
        t1.start();
        Thread t2=new MyThread();
        t2.setName("t2");
        t2.start();
        //t1.interrupt();
        Thread t3=new Thread(new MyRunnable2(){
            public void run(){
                System.out.println(ANSI_CYAN+"Running from "+currentThread().getName());
                try {
                    t1.join(2000);
                    //basically we can specify timeout when to ask our threads to wait
                    System.out.println(ANSI_CYAN+"t1 terminated or timeout exceeded");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN+currentThread().getName()+":I could not wait after all I was interrupted");
                }
            }
        });
        t3.setName("t3");
        t3.start();
    }
}
