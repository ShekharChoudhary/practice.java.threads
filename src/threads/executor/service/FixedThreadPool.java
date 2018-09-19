package threads.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPool {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(1);
		service.execute(new NewRunnable("one",5000));
		service.execute(new NewRunnable("two",5000));
		service.execute(new NewRunnable("three",5000));
		service.execute(new NewRunnable("four",5000));
		service.execute(new NewRunnable("five",5000));
		service.shutdown();
		
		ExecutorService s = Executors.newWorkStealingPool(2);
		
	}
	
}

class NewRunnable implements Runnable{
	String name;
	int time;
	public NewRunnable(String name, int time){
		this.name = name;
		this.time = time;
	}
	public void run(){
		Thread.currentThread().setName(name);
		System.out.println("Thread "+name+" starts");
		System.out.println("Thread id is :"+Thread.currentThread().getId());
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread "+name+" ends");
	}
}
