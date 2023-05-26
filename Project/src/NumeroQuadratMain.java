import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class NumeroQuadratMain {
    public static void main(String args[]) {
        NumeroQuadratCalcul obj = new NumeroQuadratCalcul();
        Future<Integer> future = obj.calculate(7);

        while (!future.isDone()) {
            System.out.println("Calculant...");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        try {
            Integer result = future.get();
            System.out.println("Resultat: " + result);
            obj.shutdown();
        } catch (InterruptedException e) { e.printStackTrace();
        } catch (ExecutionException e) { e.printStackTrace(); }
    }
}
