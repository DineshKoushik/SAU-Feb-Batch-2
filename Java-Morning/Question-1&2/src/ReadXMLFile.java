import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.io.File;
import java.io.*;
import java.util.*;

public class ReadXMLFile {

  public static void main(String argv[]) {
	  HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	  int roll,marks,prev;

    try {

    File fXmlFile = new File("student.xml");
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(fXmlFile);
    doc.getDocumentElement().normalize();
            
    NodeList nList = doc.getElementsByTagName("student");


    for (int temp = 0; temp < nList.getLength(); temp++) {

        Node nNode = nList.item(temp);
                
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {

            Element eElement = (Element) nNode;
            roll=Integer.parseInt(eElement.getElementsByTagName("roll").item(0).getTextContent());   

            marks=Integer.parseInt(eElement.getElementsByTagName("marks").item(0).getTextContent()); 
            if(!map.containsKey(roll)){
                map.put(roll,marks);
            }else{
                prev=map.get(roll);
                map.put(roll,marks+prev);
            }
        }
    }
    } catch (Exception e) {
    e.printStackTrace();
    }
    try{  
    	  FileOutputStream fout=new FileOutputStream("student.txt");  
    	  ObjectOutputStream out=new ObjectOutputStream(fout); 

    	  Iterator itr = map.entrySet().iterator(); 

    	  while (itr.hasNext()) { 
    	            Map.Entry mapElement = (Map.Entry)itr.next(); 
    	            marks = (int)mapElement.getValue() ; 
    	            roll=(int)mapElement.getKey();  
    	            out.writeObject(new Student(roll,marks));  
    	        } 

    	    out.flush(); 
            
    	    TopStudents.finder();
    	     }catch(Exception e){
    	    	 System.out.println(e);
    	    } 
  }
}