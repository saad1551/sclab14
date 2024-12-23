package task2;

public class ThreadSynchronizationExample {
	static class Counter {
	    private int count = 0;

	    public synchronized void increment() {
	        count++;
	    }

	    public int getCount() {
	        return count;
	    }
	}
	
	static class IncrementThread extends Thread {
	    private Counter counter;

	    public IncrementThread(Counter counter) {
	        this.counter = counter;
	    }

	    public void run() {
	        for (int i = 0; i < 100; i++) {
	            counter.increment();
	        }
	    }
	}
	
	
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        
        Thread t1 = new IncrementThread(counter);
        Thread t2 = new IncrementThread(counter);
        Thread t3 = new IncrementThread(counter);

        t1.start();
        t2.start();
        t3.start();

        t1.join();
        t2.join();
        t3.join();

        System.out.println("Final Counter Value: " + counter.getCount());
    }
}
