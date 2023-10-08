package com.project;
import java.util.*;

public class Main {

    static Scanner in = new Scanner(System.in); // System.in és global, Scanner també ho a de ser

    // Main
    public static void main(String[] args) {
        
        boolean running = true;

        while (running) {

            String menu = "Escull una opció:";
            menu = menu + "\n 0) CompletableLambda";
            menu = menu + "\n 1) EsperaSegons";
            menu = menu + "\n 2) MultiplesFils";
            menu = menu + "\n 3) NumeroQuadrat";
            menu = menu + "\n 4) Sortir";
            System.out.println(menu);

            int opcio = Integer.valueOf(llegirLinia("Opció:"));
            
            switch (opcio) {
                case 0: CompletableLambdaMain.main(args);   break;
                case 1: EsperaSegonsMain.main(args);        break;
                case 2: MultiplesFilsMain.main(args);       break;
                case 3:	NumeroQuadratMain.main(args);       break;			
                case 4: running = false;                    break;
                default: break;
            }
        }

		in.close();
    }

    static public String llegirLinia (String text) {
        System.out.print(text);
        return in.nextLine();
    }
}