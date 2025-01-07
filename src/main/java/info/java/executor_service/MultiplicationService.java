package info.java.executor_service;

import java.util.Random;

public class MultiplicationService {

    public long multiply(int a) throws InterruptedException {
        long waitTime  = new Random().nextInt(5000-1000)+1000;
        System.out.println("Thread " + Thread.currentThread().getName() + " , waiting for " + waitTime + " "+"Multiplying : "+ a);
        Thread.sleep(waitTime);
        if(a==10) throw new RuntimeException("Cannot multiply");
        return a * 10L;
    }
}
