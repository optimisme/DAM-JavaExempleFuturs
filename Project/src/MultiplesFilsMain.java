import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class MultiplesFilsMain {

    public static void main(String args[]) {
        MultiplesFilsCalcul obj = new MultiplesFilsCalcul();
        Future<Integer> f0 = obj.calculate(1);
        Future<Integer> f1 = obj.calculate(2);
        Future<Integer> f2 = obj.calculate(4);
        Future<Integer> f3 = obj.calculate(8);
        String txt = "";

        while (!f0.isDone() || !f1.isDone() || !f2.isDone() || !f3.isDone()) {
            // Esperar a que estiguin llestos
            txt = String.format(
                "Estats: f0 %s, f1 %s, f2 %s, f3 %s", 
                f0.isDone() ? "llest" : "calculant", 
                f1.isDone() ? "llest" : "calculant",
                f2.isDone() ? "llest" : "calculant",
                f3.isDone() ? "llest" : "calculant"
            );
            System.out.println(txt);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }    

        try {
            txt = String.format(
                "Resultat: f0=%s, f1=%s, f2=%s, f3=%s", 
                f0.get(), f1.get(), f2.get(), f3.get()
            );
            System.out.println(txt);
            obj.shutdown();
        } catch (InterruptedException e) { e.printStackTrace();
        } catch (ExecutionException e) { e.printStackTrace(); }
    }
}
