
public class Singleton {
	private static Singleton s = null;      
	public String str;   
	private Singleton()   
	{   
	    str = "Singleton Example.";   
	}   
	public static Singleton getInstance()   
	{    
	if (s== null)   
	s = new Singleton();   
	return s;   
	}   
}