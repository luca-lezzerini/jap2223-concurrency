/*
 */
package al.polis.jap2223concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 * @author use
 */
public class Jap2223Concurrency {

    public static void main(String[] args) {
        System.out.println("Program started!");

//        ExecutorService exes = Executors.newSingleThreadExecutor();
//        ExecutorService exes = Executors.newFixedThreadPool(3);
        ExecutorService exes = Executors.newCachedThreadPool();
        Future f1 = exes.submit(() -> {
            String t = Thread.currentThread().toString();
            try {
                System.out.println(t + "The very long query started now ...");
                Thread.sleep(5_000);
                System.out.println(t + "The very long query has finished!");
            } catch (Exception e) {
            }
        });
        exes.submit(() -> {
            String t = Thread.currentThread().toString();
            try {
                System.out.println(t + "The second very long query started now ...");
                Thread.sleep(6_000);
                System.out.println(t + "The second very long query has finished!");
            } catch (Exception e) {
            }
        });
        exes.submit(() -> {
            String t = Thread.currentThread().toString();
            try {
                System.out.println(t + "The 3rd very long query started now ...");
                Thread.sleep(7_000);
                System.out.println(t + "The 3rd very long query has finished!");
            } catch (Exception e) {
            }
        });
        exes.submit(() -> {
            String t = Thread.currentThread().toString();
            try {
                System.out.println(t + "The 4th very long query started now ...");
                Thread.sleep(8_000);
                System.out.println(t + "The 4th very long query has finished!");
            } catch (Exception e) {
            }
        });
        System.out.println("Let me wait f1 is done ...");
        try {
            f1.get();
        } catch (Exception e) {
        }
        System.out.println("Program Has finished! (but the query is yet running)");
    }
}
