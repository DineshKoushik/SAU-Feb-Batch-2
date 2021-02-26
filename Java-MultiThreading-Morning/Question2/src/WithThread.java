import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WithThread extends Thread{
	private static long startTime = System.nanoTime();
	BufferedReader br;
	@Override
	public void run() {
		int count=0;
		String s;
		try {
			while((s = br.readLine()) != null) {  
			    
			    String words[] = s.split(" ");  
			   
			    count = count + words.length;  
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
        System.out.println("Total words:"+" "+count);
        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " ns");
	}
	
	public static void main(String[] args) throws IOException {
		WithThread wt = new WithThread();
		FileReader file = new FileReader("file.txt");  
        BufferedReader b = new BufferedReader(file);
		wt.br = b;
		wt.start();
	}

}
