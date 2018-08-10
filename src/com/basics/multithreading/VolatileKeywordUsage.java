package com.basics.multithreading;

class Worker implements Runnable{
    private volatile boolean isTerminated=false;
    @Override
    public void run() {
        while (!isTerminated){
            System.out.println("hello from worker class");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean isTerminated() {
        return isTerminated;
    }

    public void setTerminated(boolean terminated) {
        isTerminated = terminated;
    }
}
public class VolatileKeywordUsage {
    public static void main(String[] args) {
        Worker worker1=new Worker();
        Thread t1=new Thread(worker1);
        t1.start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker1.setTerminated(true);
        System.out.println("task finished...");
    }
}
