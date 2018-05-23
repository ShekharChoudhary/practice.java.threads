package threads.volatileKeyword;

/**
 * When a variable is marked volatile then every time a thread reads the variable it reads it from the main memory instead
 * of the cached memory. Here please note that every thread has its own cache memory.
 * Here in our example if we do not make the value of the variable 'count' as volatile then we can see that every time we run it
 * we get different value. This is due to fact that each thread stores the value of count in its own cache and does not fetch the
 * value from the main memory and hence it gets changed every time. 
 * This problem can be resolved by making count as volatile.
 * 
 * The disadvantage is that since it fetches the data from the main memory every time rather than the cache hence system performance is
 * impacted by it. Hence it should be used wisely.
 * 
 * Also one main use of volatile is that it prevents instruction reordering. Instruction reordering is used to boost the performance of
 * a code and this is prevented by volatile.
 * @author choudshe
 *
 */
public class TestVolatile {

//	public static int count = 0;
	
	public volatile static int count =0;
	
	public static void main(String[] args) {

		Thread t1 = new Thread(()-> {
			for(int i =0 ;i<10000;i++) {
			 	if(count <10000) {
			 		count ++;
			 	}
			}
		});
		
		Thread t2 = new Thread(()-> {
			for(int i =0 ;i<10000;i++) {
			 	if(count <10000) {
			 		count ++;
			 	}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("The final value of count is :"+count);
	}
	
	
}
