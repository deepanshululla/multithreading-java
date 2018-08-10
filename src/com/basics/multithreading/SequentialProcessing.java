package com.basics.multithreading;


class Runner1 {
    public void startRunning(){
        for (int i=0;i<10;i++){
            System.out.println("Runner1 is printing "+i);
        }
    }
}
class Runner2 {
    public void startRunning(){
        for (int i=0;i<10;i++){
            System.out.println("Runner2 is printing "+i);
        }
    }
}
public class SequentialProcessing {

    public static void main(String[] args) {
        // write your code here
        Runner1 runner1=new Runner1();
        Runner2 runner2 = new Runner2();
        runner1.startRunning();
        runner2.startRunning();

    }
}
