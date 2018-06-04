package threads.fork.join;

import java.util.concurrent.ForkJoinPool;

public class App1 {

	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		SimpleRecursiveTask task = new SimpleRecursiveTask(120);
		System.out.println(pool.invoke(task));
	}
}
