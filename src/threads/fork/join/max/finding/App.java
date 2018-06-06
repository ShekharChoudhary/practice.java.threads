package threads.fork.join.max.finding;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class App {

	/*
	 * Here we conclude that if the array length is 10000 (i.e for small amount of data then sequential approach is better and faster
	 * but if we have huge data set as we have here as 300000000 then we should use parallel approach which is faster and better.
	 */
	public static int ARRAY_LENGTH = 300000000;
	public static int THRESHOLD = 0;

	public static void main(String[] args) {
		int [] nums = initializeNums();
		THRESHOLD = nums.length / Runtime.getRuntime().availableProcessors();
		
		SequentialMaxFinding sequentialMaxFinding = new SequentialMaxFinding();
		
		long start = System.currentTimeMillis();
		System.out.println("Sequential Max Finding Max value : "+sequentialMaxFinding.findMaxSequentially(nums, nums.length));
		System.out.println("Time taken : "+(System.currentTimeMillis()-start)+" ms");
		
		System.out.println();
		
		ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
		ParallelMaxFinding parallelMaxFinding = new ParallelMaxFinding(nums, 0, nums.length);
		
		start = System.currentTimeMillis();
		System.out.println("Parallel Max Finding Max value : " +pool.invoke(parallelMaxFinding));
		System.out.println("Time taken : "+(System.currentTimeMillis()-start)+" ms");
		
	}

	private static int[] initializeNums() {

		Random random = new Random();
		int [] nums = new int [ARRAY_LENGTH];
		
		for(int i =0;i<nums.length;i++) {
			nums[i] = random.nextInt(1000);
		}
		return nums;
	}
}
