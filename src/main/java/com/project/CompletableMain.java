package com.project;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class CompletableMain {
    public static void main(String args[]) {

        // Declarar els processos asíncrons al codi directament
        CompletableFuture<Void> futureA = CompletableFuture.runAsync(getRunnable("A"));
        CompletableFuture<Void> futureB = CompletableFuture.runAsync(getRunnable("B"));

        // Posar els 'CompletableFuture' en una llista per esperar-los tots alhora
        // tots han de retornar el mateix tipus (en aquest cas String)
        System.out.println("Esperant futurs");
        List<CompletableFuture<Void>> futureList = new ArrayList<>();
        futureList.add(futureA);
        futureList.add(futureB);
        futureList.forEach(CompletableFuture::join); 
        System.out.println("Futurs llestos");
    }

    static Runnable getRunnable (String type) {
        return new Runnable () {
            @Override
            public void run () {
                try {
                    long millis = (new Random()).nextInt(4000) + 500;
                    System.out.println("futur" + type + " trigarà " + (millis / 1000.0) + " milisegons");
                    int cnt = 10;
                    while (cnt > 0) {
                        Thread.sleep(millis / 10);
                        System.out.println(" - " + type + " " + cnt);
                        cnt = cnt - 1;
                    }
                    System.out.println("future" + type + " acabat");
                    
                } catch (InterruptedException e) { e.printStackTrace(); }
            }
        };
    }
}
