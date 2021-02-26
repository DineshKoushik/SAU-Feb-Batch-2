import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WithoutThread{
	private static long startTime = System.nanoTime();
	BufferedReader br;
	public void count() throws IOException {
		int count=0;
		String s;
		while((s = br.readLine()) != null) {  
            
            String words[] = s.split(" ");  
           
            count = count + words.length;  
        }  
        System.out.println("Total words:"+" "+count);
        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " ns");
	}
	
	public static void main(String[] args) throws IOException {
		WithoutThread wt = new WithoutThread();
		FileReader file = new FileReader("file.txt");  
        BufferedReader b = new BufferedReader(file);
        wt.br = b;
		wt.count();
	}

}
