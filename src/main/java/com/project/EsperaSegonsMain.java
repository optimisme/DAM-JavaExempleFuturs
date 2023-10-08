package com.project;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class EsperaSegonsMain {
    public static void main(String args[]) {
        EsperaSegonsCalcul obj = new EsperaSegonsCalcul();
        Future<Integer> future = obj.calculate(7);
        long start = System.currentTimeMillis();
        long finish = 0;

        while (!future.isDone()) {
            finish = System.currentTimeMillis();
            double segons = (finish - start) / 1000.0;
            System.out.println("Esperant ... " + segons + " segons");
            if (segons > 2) {
                // Si esperem més de 2 segons, ja no volem el resultat
                future.cancel(true);
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        try {
            if (future.isCancelled()) {
                System.out.println("El resultat ha trigat massa");
            } else {
                Integer result = future.get();
                System.out.println("Resultat: " + result);
            }
            obj.shutdown();
        } catch (InterruptedException e) { e.printStackTrace();
        } catch (ExecutionException e) { e.printStackTrace(); }
    }  
}
