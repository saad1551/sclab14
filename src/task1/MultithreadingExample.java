package task1;

public class MultithreadingExample {
	static class SquareThread extends Thread {
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            System.out.println("Square: " + (i * i));
	            try {
	                Thread.sleep(100); // Simulating some delay
	            } catch (InterruptedException e) {
	                System.out.println(e);
	            }
	        }
	    }
	}
	
	static class NumberThread extends Thread {
	    public void run() {
	        for (int i = 1; i <= 10; i++) {
	            System.out.println("Number: " + i);
	            try {
	                Thread.sleep(100); // Simulating some delay
	            } catch (InterruptedException e) {
	                System.out.println(e);
	            }
	        }
	    }
	}
	
    public static void main(String[] args) {
        NumberThread t1 = new NumberThread();
        SquareThread t2 = new SquareThread();

        t1.start();
        t2.start();
    }
}
