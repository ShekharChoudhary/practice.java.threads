package threads.executor.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NormalExecutorServiceTest {

	public static void main(String[] args) {
		
		ExecutorService service = Executors.newFixedThreadPool(2);
		service.execute(new NewRunnable("one",1000));
		service.execute(new NewRunnable("two",2000));
		service.execute(new NewRunnable("three",3000));
		service.execute(new NewRunnable("four",1000));
		service.execute(new NewRunnable("five",1000));
		service.shutdown();
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
		System.out.println("Thread "+name+" starts");
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Thread "+name+" ends");
	}
}
