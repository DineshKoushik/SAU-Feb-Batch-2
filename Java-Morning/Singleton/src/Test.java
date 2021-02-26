class Test  
{   
	public static void main(String args[])   
	{    
	Singleton a = Singleton.getInstance();    
	Singleton b = Singleton.getInstance();   
	Singleton c = Singleton.getInstance();      
	System.out.println("1." + a.str);   
	System.out.println("2." + b.str);   
	System.out.println("3." + c.str);   
	}   
}   