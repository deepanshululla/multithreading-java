package com.basics.multithreading;
/*
Example of race condition
Both threads are trying to change value of i

This is also called thread interface
 */
class CountDown1{
    private int i;
    public synchronized void doCountDown(){
        String color;
        switch (Thread.currentThread().getName()){
            case "Thread 1":
                color=ThreadColor.ANSI_CYAN;
                break;
            case "Thread 2":
                color=ThreadColor.ANSI_PURPLE;
                break;
            default:
                color=ThreadColor.ANSI_GREEN;
        }
        for(i=10;i>0;i--){
            System.out.println(color+Thread.currentThread().getName()+": i="+i);
        }

    }
}

class CountDownThread1 extends Thread{
    private CountDown1 countDown;
    public CountDownThread1(CountDown1 countDown){
        this.countDown=countDown;
    }
    @Override
    public void run() {
       countDown.doCountDown();
    }
}

public class CounterRaceConditionSynchronized {
    public static void main(String[] args) {
        CountDown1 countDown=new CountDown1();

        CountDownThread1 thread1=new CountDownThread1(countDown);
        thread1.setName("Thread 1");

        CountDownThread1 thread2=new CountDownThread1(countDown);
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }
}
