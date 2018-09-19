package threads.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;
/*
 *  
In Java programming language ThreadLocal class provides another way of thread-safety apart from synchronization.
 Usually when we have multiple threads sharing an object we need to synchronize the critical section of 
 the code in order to make it thread safe.

How ThreadLocal class provides thread safety:

ThreadLocal class in Java provides thread-local variables where each thread that accesses one 
(via its get or set method) has its own, independently initialized copy of the variable. 
Since each and every thread has its own copy of the object so explicit synchronization is not needed to
 provide thread safety.
 Since SimpleDateFormat is not thread safe so in multi-threaded environment it needs to be synchronized like this

public class DateFormatDemo {
    private DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    public Date convertStringToDate(String dateString) throws ParseException {
    Date result;
    synchronized(df) {
       result = df.parse(dateString);
    }
    return result;
    }  
}
 
 */

public class ThreadLocalExample implements Runnable{

	private static final ThreadLocal<SimpleDateFormat> threadLocalSdf = new ThreadLocal<SimpleDateFormat>()
			{
	
	//@Override
	protected SimpleDateFormat initialValue()
	{
		return new SimpleDateFormat("yyyyMMdd HHmm");
	}
			};
	
	
	@Override
	public void run() {
		
		threadLocalSdf.set(new SimpleDateFormat());
		
		System.out.println("Thread name := " +Thread.currentThread().getName() + "default formatter = " +threadLocalSdf.get().toPattern());
		
		try {
			Thread.sleep(new Random().nextInt(1000));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		threadLocalSdf.set(new SimpleDateFormat());
		
		System.out.println("Thread name := " +Thread.currentThread().getName() + "default formatter = " +threadLocalSdf.get().toPattern());
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLocalExample threadLocal = new ThreadLocalExample();
		
		for(int i=0; i<10; i++)
		{
			Thread t = new Thread(threadLocal, ""+i);
			Thread.sleep(new Random().nextInt(1000));
			t.start();
		}
		
	}

}
