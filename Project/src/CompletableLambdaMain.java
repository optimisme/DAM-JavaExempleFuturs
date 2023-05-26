import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableLambdaMain {
    public static void main(String args[]) {

        // Declarar els processos asíncrons al codi directament
        CompletableFuture<String> futureA = CompletableFuture.supplyAsync(() -> {
            try {
                long millis = (new Random()).nextInt(4000) + 500;
                System.out.println("futurA trigarà " + (millis / 1000.0) + " milisegons");
                int cnt = 10;
                while (cnt > 0) {
                    Thread.sleep(millis / 10);
                    System.out.println(" - A " + cnt);
                    cnt = cnt - 1;
                }                    
            } catch (InterruptedException e) { e.printStackTrace(); }
            return "Done A";
        });

        CompletableFuture<String> futureB = CompletableFuture.supplyAsync(() -> {
            try {
                long millis = (new Random()).nextInt(4000) + 500;
                System.out.println("futurB trigarà " + (millis / 1000.0) + " milisegons");
                int cnt = 10;
                while (cnt > 0) {
                    Thread.sleep(millis / 10);
                    System.out.println(" - B " + cnt);
                    cnt = cnt - 1;
                }                    
            } catch (InterruptedException e) { e.printStackTrace(); }
            return "Done B";
        });

        // Posar els 'CompletableFuture' en una llista per esperar-los tots alhora
        System.out.println("Esperant resultats");
        List<CompletableFuture<String>> futureList = new ArrayList<>();
        futureList.add(futureA);
        futureList.add(futureB);
        futureList.forEach(CompletableFuture::join); 
        System.out.println("Resultats llestos");

        // Mostrar resultats
        try {
            String resultA = futureA.get(); 
            String resultB = futureB.get(); 
            System.out.println("Resultat A = " + resultA + ", Resultat B = " + resultB);
        } catch (InterruptedException e) { e.printStackTrace();
        } catch (ExecutionException e) { e.printStackTrace(); }
    }
}
