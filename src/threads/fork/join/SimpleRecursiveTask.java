package threads.fork.join;

import java.util.concurrent.RecursiveTask;

public class SimpleRecursiveTask extends RecursiveTask<Integer>{

	int simulatedWork;
	
	public SimpleRecursiveTask (int simulatedWork) {
		this.simulatedWork = simulatedWork;
	}
	
	@Override
	protected Integer compute() {
	
		if(simulatedWork >100) {
			System.out.println("Parallel exection and split task..."+ simulatedWork);
			SimpleRecursiveTask task1 = new SimpleRecursiveTask(simulatedWork/2);
			SimpleRecursiveTask task2 = new SimpleRecursiveTask(simulatedWork/2);
			
			task1.fork();
			task2.fork();
			
			int count =0;
			count += task1.join();
			count += task2.join();
			return count;
		}else {
			System.out.println("No need for parallel exection. The number sumlated action is "+ simulatedWork);
			return 2*simulatedWork;
		}
		
		
	}

}
