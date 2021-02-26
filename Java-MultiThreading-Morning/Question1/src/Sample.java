
public class Sample {

	public static void main(String[] args) throws InterruptedException {
		final Thread1 t = new Thread1();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try { 
                    t.producer(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
			}
		});
		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try { 
                    t.consumer(); 
                } 
                catch (InterruptedException e) { 
                    e.printStackTrace(); 
                } 
			}
		});
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();

	}

}
