package threads.basics;
/**
 * Here since the class NewThread overrides run() method hence when we call start() 
 * the run method of NewThread class is called instead of the run() method of runnable class.
 * But if we remove the run() method of NewThread class then run() method of Thread2 class is
 * called which implements Runnable interface.
 * @author choudshe
 *
 */
public class NewThread extends Thread{

	
	public NewThread(Runnable run) {
		super(run);
	}

	public static void main(String[] args) {
	
		NewThread t = new NewThread(new Thread2());
		t.start();
	}
	
	public void run() {
		System.out.println("This is new thread");
	}
}


class Thread1 extends Thread{
	public void run() {
		System.out.println("This is thread1");
	}
}


class Thread2 implements Runnable{

	@Override
	public void run() {
		System.out.println("this is thread2");
		
	}
	
}
