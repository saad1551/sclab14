package task3;

import java.util.concurrent.*;

public class ConcurrentDataStructuresExample {
    public static void main(String[] args) throws InterruptedException {
        // Using CopyOnWriteArrayList for thread-safe operations
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>();
        
        // Creating threads for reading and writing
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                list.add(i);
                System.out.println("Thread 1 added: " + i);
            }
        });
        
        Thread t2 = new Thread(() -> {
            for (int i = 10; i < 20; i++) {
                list.add(i);
                System.out.println("Thread 2 added: " + i);
            }
        });
        
        Thread t3 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Thread 3 read: " + list.get(i));
            }
        });

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();
    }
}
