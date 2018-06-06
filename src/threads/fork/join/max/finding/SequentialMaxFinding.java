package threads.fork.join.max.finding;

public class SequentialMaxFinding {

	
	public int findMaxSequentially(int [] nums, int highIndex) {
		int max = nums[0];
		
		for(int i=0;i<highIndex;i++) {
			if(nums[i]>max) {
				max = nums[i];
			}
		}
		
		return max;
			
	}
}
