package threads.busyspining;


public class ConsumerThread implements Runnable{

	
	ProducerThread pt;
	public ConsumerThread(ProducerThread pt)
	{
		System.out.println("Constructor ConsumerThread");
		this.pt = pt;
	}
	@Override
	public void run() {

		while (this.pt.flag) 
		{
			System.out.println("Waiting busy spining");
		}
		System.out.println("Consumer Starting");
		for(Integer i : this.pt.sharedObjs)
		{
			System.out.println(i);
		}
	}
}
