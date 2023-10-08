package com.project;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NumeroQuadratCalcul {

    private ExecutorService executor = Executors.newSingleThreadExecutor();
  
    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
            Thread.sleep(1000);
            return input * input;
        });
    }
    public void shutdown () { executor.shutdown(); }
}