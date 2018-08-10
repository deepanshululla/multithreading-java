package com.basics.multithreading;
/*
Example of race condition
Both threads are trying to change value of i

This is also called thread interface
 */
class CountDown{
    private int i;
    public void doCountDown(){
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
class CountDownThread extends Thread{
    private CountDown countDown;
    public CountDownThread(CountDown countDown){
        this.countDown=countDown;
    }
    @Override
    public void run() {
       countDown.doCountDown();
    }
}

public class CounterRaceCondition {
    public static void main(String[] args) {
        CountDown countDown=new CountDown();

        CountDownThread thread1=new CountDownThread(countDown);
        thread1.setName("Thread 1");

        CountDownThread thread2=new CountDownThread(countDown);
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }
}
