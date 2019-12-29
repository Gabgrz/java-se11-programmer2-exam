package com.company;

import java.util.concurrent.*;

public class DistanceTracker {

    private int km;
    private double mi;
    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void incrementKm(){
        synchronized(lock1){
            km++;
        }
    }

    public void incrementMi(){
        synchronized(lock2){
            mi = mi + 1*0.621371;
        }
    }

    public int getKm() {
        return km;
    }

    public double getMi() {
        return mi;
    }

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        DistanceTracker tracker = new DistanceTracker();

        for(int i = 0; i < 10; i++){
            executor.submit(() -> {
                tracker.incrementKm();
                tracker.incrementMi();
                System.out.println("Current distance in Kilometers: "+tracker.getKm());
                System.out.println("Current distance in Miles: "+tracker.getMi());
                System.out.println("Running Thread: "+Thread.currentThread().getName());
            });
        }

        executor.shutdown();
        try{
            executor.awaitTermination(60,TimeUnit.SECONDS);
        }
        catch(InterruptedException ie){
            ie.printStackTrace();
        }
        System.out.println("Final distance in Kilometers: "+tracker.getKm());
        System.out.println("Final distance in Miles: "+tracker.getMi());
    }
}