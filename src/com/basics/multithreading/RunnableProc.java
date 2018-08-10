package com.basics.multithreading;


import static com.basics.multithreading.ThreadColor.ANSI_GREEN;
import static com.basics.multithreading.ThreadColor.ANSI_RED;

/*
A Runnable is basically a type of class (Runnable is an Interface)
that can be put into a thread, describing what the thread is supposed to do.
This interface is designed to provide a common protocol for objects that wish to execute code while they are active. For example, Runnable is implemented by class Thread. Being active simply means that a thread has been started and has not yet been stopped.

In addition, Runnable provides the means for a class to be active while not subclassing Thread. A class that implements Runnable can run without subclassing
 Thread by instantiating a Thread instance and passing itself in as the target.
 In most cases, the Runnable interface should be used if you are only planning to override the run() method and no other Thread methods. This is important because classes should not be subclassed unless the programmer intends on modifying or enhancing the fundamental behavior of the class.

The Runnable Interface requires of the class to implement the method run() like so:

public class MyRunnableTask implements Runnable {
     public void run() {
         // do stuff here
     }
}
 */
class RunnerRunnable1 implements Runnable {
    public void startRunning() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ANSI_RED + "Runner1 is printing " + i);
        }
    }

    @Override
    public void run() {
        startRunning();
    }
}

class RunnerRunnable2 implements Runnable {
    public void startRunning() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ANSI_GREEN + "Runner2 is printing " + i);
        }
    }

    @Override
    public void run() {
        startRunning();
    }

}

public class RunnableProc {

    public static void main(String[] args) {
        // write your code here
        RunnerRunnable1 runner1 = new RunnerRunnable1();
        Thread t1 = new Thread(runner1);
        RunnerRunnable2 runner2 = new RunnerRunnable2();
        Thread t2 = new Thread(runner2);
        t1.start();
        t2.start();

    }
}
