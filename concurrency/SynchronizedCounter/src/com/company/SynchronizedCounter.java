package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedCounter {

    private int km;
    private double mi;

    public synchronized void incrementKm(){
        km++;
    }

    public int getKm(){
        return this.km;
    }

    public synchronized void incrementMi(){
        mi = mi+1.60934;
    }

    public double getMi(){
        return this.mi;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);

        SynchronizedCounter theCounter = new SynchronizedCounter();

        for(int i = 0; i < 1000; i++){
            executor.submit(() -> {
                theCounter.incrementKm();
                theCounter.incrementMi();
                System.out.println("Running thread: "+Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        try{
            executor.awaitTermination(60l, TimeUnit.SECONDS);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }

        System.out.println("Distance covered in km: "+theCounter.getKm());
        System.out.println("Distance covered in mi: " +theCounter.getMi());
    }
}