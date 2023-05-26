import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class EsperaSegonsCalcul {
    private ExecutorService executor = Executors.newSingleThreadExecutor();
  
    public Future<Integer> calculate(Integer input) {        
        return executor.submit(() -> {
            long millis = (new Random()).nextInt(3000) + 1000;
            System.out.println("Trigarà: " + (millis / 1000.0) + " milisegons");
            Thread.sleep(millis);
            return input * input;
        });
    }

    public void shutdown () { executor.shutdown(); }
}
