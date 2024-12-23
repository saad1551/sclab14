package task4;

import java.util.concurrent.atomic.AtomicInteger;


public class BankTransactionSimulation {
	static class BankAccount {
	    private AtomicInteger balance = new AtomicInteger(0);

	    public void deposit(int amount) {
	        balance.addAndGet(amount);
	    }

	    public void withdraw(int amount) {
	        if (balance.get() >= amount) {
	            balance.addAndGet(-amount);
	        } else {
	            System.out.println("Insufficient funds!");
	        }
	    }

	    public int getBalance() {
	        return balance.get();
	    }
	}
	
	static class Client extends Thread {
	    private BankAccount account;

	    public Client(BankAccount account) {
	        this.account = account;
	    }

	    public void run() {
	        for (int i = 0; i < 5; i++) {
	            account.deposit(100);
	            account.withdraw(50);
	        }
	    }
	}
	
    public static void main(String[] args) throws InterruptedException {
        BankAccount account = new BankAccount();
        
        Thread client1 = new Client(account);
        Thread client2 = new Client(account);
        Thread client3 = new Client(account);

        client1.start();
        client2.start();
        client3.start();

        client1.join();
        client2.join();
        client3.join();

        System.out.println("Final account balance: " + account.getBalance());
    }
}

