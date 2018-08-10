package com.basics.multithreading;

import static com.basics.multithreading.ThreadColor.ANSI_BLUE;
import static com.basics.multithreading.ThreadColor.ANSI_CYAN;
import static com.basics.multithreading.ThreadColor.ANSI_RED;
import static java.lang.Thread.currentThread;

/*
The purpose of implementing a sleep operation is to
simulate a blocking call.
Also interrupt are used to interrupt a running thread.

 */
class MyRunnable implements Runnable{
    private void startRunning(){
        for (int i=0;i<10;i=i+1){
            System.out.println(ANSI_RED+"Runnable is printing "+i+" from thread name "+currentThread().getName());
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println(ANSI_RED+"Another thread woke me up");
                return;
                // return here stops the execution of the thread once an interrupt is called
                // if return is not called after thread runs it continues to run
            }
            System.out.println(ANSI_RED+" 3 seconds done I am back");
        }
    }
    @Override
    public void run() {
        startRunning();
    }
}

class MyThread extends Thread{
    private void startRunning(){
        for (int i=0;i<10;i=i+1){
            System.out.println(ANSI_BLUE+"Runner1 is printing "+i+" from thread name "+currentThread().getName());
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

public class Interrupts{
    public static void main(String[] args) {
        Thread t1=new Thread(new MyRunnable());
        t1.setName("t1");
        t1.start();
        Thread t2=new MyThread();
        t2.setName("t2");
        t2.start();
        t1.interrupt();

    }
}
