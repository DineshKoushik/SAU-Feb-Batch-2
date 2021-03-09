package mavenBatch.junit;

public class Log4jTest {
	
	private String message;
	   
	public void setMessage(String message){
		this.message  = message;
	}
	public void getMessage() {
		System.out.println("Your Message : " + message);
	}

}
