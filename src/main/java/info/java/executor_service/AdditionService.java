package info.java.executor_service;

import java.util.Random;

public class AdditionService {

    public Integer add(int a , int b) throws InterruptedException {
        long waitTime  = new Random().nextInt(10000-1000)+1000;
        System.out.println("Thread " + Thread.currentThread().getName() + " , waiting for " + waitTime + " adding"+a+" : "+b);
        Thread.sleep(waitTime);
        return a+b;
    }
}
