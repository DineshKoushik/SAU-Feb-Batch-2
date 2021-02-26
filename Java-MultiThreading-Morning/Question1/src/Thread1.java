import java.util.LinkedList;

public class Thread1 {
	LinkedList<Integer> l = new LinkedList<>();
	int Q_Size = 4;
	
	public void producer() throws InterruptedException {
		int init = 0;
		while(true)
		{
			synchronized (this) {
				while(l.size() == Q_Size)
					wait();
				System.out.println("Items produced" +" "+ init);
				l.add(init+1);
				notify();
				Thread.sleep(1000);
			}
		}
	}
	
	public void consumer() throws InterruptedException {
		while(true)
		{
			synchronized (this) {
				while(l.size() == 0)
					wait();
				System.out.println("Items consumed"+" " + l.removeFirst());
				notify();
				Thread.sleep(1000);
				
			}
		}
	}

}
