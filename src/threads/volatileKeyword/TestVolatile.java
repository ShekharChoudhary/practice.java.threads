package threads.volatileKeyword;

/**
 * when a variable is marked volatile then every time a thread reads the variable it reads it from the main memory instead
 * of the cached memory.
 * Here in our example if we do not make a 
 * @author choudshe
 *
 */
public class TestVolatile {

	public static int count = 0;
	
	public static void main(String[] args) {

		Thread t1 = new Thread(()-> {
			for(int i =0 ;i<1000;i++) {
			 	if(count <1000) {
			 		count ++;
			 	}
			}
		});
		
		Thread t2 = new Thread(()-> {
			for(int i =0 ;i<1000;i++) {
			 	if(count <1000) {
			 		count ++;
			 	}
			}
		});
	}
	
	
}
