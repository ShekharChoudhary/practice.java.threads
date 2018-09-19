package threads.busyspining;

import java.util.ArrayList;
import java.util.List;

public class ProducerThread implements Runnable{

	
	List<Integer> sharedObjs;
	boolean flag;
	
	public ProducerThread()
	{
		this.sharedObjs = new ArrayList<Integer>();
		this.flag = true;
	}

	@Override
	public void run() {
		
		System.out.println("Producre Thread runs...");
		for(int i=0; i<10; i++)
		{
			System.out.println("Adding : " +i);
			sharedObjs.add(i);
		}
		flag = false;
	}
}
