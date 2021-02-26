import java.util.*;
import java.io.*;

class TopStudents{
	private static HashMap helper(HashMap map)   
    {   
        List l = new LinkedList(map.entrySet());  
        Collections.sort(l, new Comparator() {
        public int compare(Object obj1, Object obj2)
        {
        	return ((Comparable)((Map.Entry)(obj2)).getValue()).compareTo(((Map.Entry)(obj1)).getValue());
        }  
        });
        HashMap sortedHashMap = new LinkedHashMap();  
        for (Iterator it = l.iterator(); it.hasNext();)   
        {  
        Map.Entry ent = (Map.Entry) it.next();  
        sortedHashMap.put(ent.getKey(), ent.getValue());  
        }   
        return sortedHashMap;  
    }  
	
	static void finder() {
		HashMap<Integer, Integer> h = new HashMap<Integer, Integer>();
	    Map<Integer, String> map;
	    try{  
	    ObjectInputStream oin=new ObjectInputStream(new FileInputStream("student.txt"));  
	    Student s=(Student)oin.readObject();  
	    h.put(s.roll,s.marks);
	    while(s!=null){
	        System.out.println(s.roll+" "+s.marks);
	        s=(Student)oin.readObject();
	        h.put(s.roll,s.marks);
	    }
	    oin.close();  
	    }catch(Exception e){
	    	System.out.println(e);
	    }  
	    map = helper(h); 
	    try (PrintWriter pw = new PrintWriter(new File("./top5.csv"))) {

	      StringBuilder b = new StringBuilder();

	      Set s=map.entrySet();
	    
	    Iterator itr = s.iterator();
	    while(itr.hasNext()){
	        Map.Entry ent=(Map.Entry) itr.next();
	        b.append(""+ent.getKey());
	        b.append("->");
	        b.append(""+ent.getValue());
	        b.append('\n');
	    }
	      pw.write(b.toString());

	    } catch (FileNotFoundException e) {
	      System.out.println(e.getMessage());
	    }
	}
	public static void main(String[] args) {
		
	}
}