import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MultiplesFilsCalcul {
    private ExecutorService executor = Executors.newFixedThreadPool(4);

    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
            long millis = (new Random()).nextInt(4000) + 500;
            System.out.println("Calcular " + input + " trigarà " + (millis / 1000.0) + " milisegons");
            Thread.sleep(millis);
            return input * input;
        });
    }
    public void shutdown () { executor.shutdown(); }
}
