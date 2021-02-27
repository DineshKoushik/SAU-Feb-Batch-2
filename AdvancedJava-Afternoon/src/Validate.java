import java.io.*;
import java.util.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Validate {
public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerFactoryConfigurationError, TransformerException, ParseException {
		Date d = new Date();
		String date = new SimpleDateFormat("dd/MM/yyyy").format(d);
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		Document doc = db.parse("NewMerged.xml");
		NodeList lst1 = doc.getElementsByTagName("CSR_Producer");
		for(int i = 0; i < lst1.getLength(); i++) {
			Node n1 = lst1.item(i);
			
			if(n1.getNodeType() == Node.ELEMENT_NODE) {
				Element ele1 = (Element) n1;
				NodeList lst2 = ele1.getElementsByTagName("License");
				
				for(int j = 0; j < lst2.getLength(); j++) {
					Node n2 = lst2.item(j);
					
					if(n2.getNodeType() == Node.ELEMENT_NODE) {
						Element ele2 = (Element) n2;	
						SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
							if(sdf.parse(ele2.getAttribute("License_Expiration_Date")).before(sdf.parse(date))) {
								String filename= "invalid.txt";
							    FileWriter f = new FileWriter(filename,true);
							    f.write("Date_Status_Effective: " + ele2.getAttribute("Date_Status_Effective") + ", License_Class: " + 
						    		ele2.getAttribute("License_Class") + ", License_Class_Code: " + 
						    		ele2.getAttribute("License_Class_Code") + ", License_Expiration_Date: " + 
						    		ele2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: " + 
						    		ele2.getAttribute("License_Issue_Date") + ", License_Number: " + 
						    		ele2.getAttribute("License_Number") + ", License_Status: " + 
						    		ele2.getAttribute("License_Status") + ", Resident_Indicator: " + 
						    		ele2.getAttribute("Resident_Indicator") + ", State_Code: " +
						    		ele2.getAttribute("State_Code") + ", State_ID: " +
						    		ele2.getAttribute("State_ID") + "\n\n\n"
						    	);
							    f.close();
							}
							else if(sdf.parse(ele2.getAttribute("License_Expiration_Date")).after(sdf.parse(date))) {
								String filename= "valid.txt";
							    FileWriter f = new FileWriter(filename,true);
							    f.write("Date_Status_Effective: " + ele2.getAttribute("Date_Status_Effective") + ", License_Class: " + 
						    		ele2.getAttribute("License_Class") + ", License_Class_Code: " + 
						    		ele2.getAttribute("License_Class_Code") + ", License_Expiration_Date: " + 
						    		ele2.getAttribute("License_Expiration_Date") + ", License_Issue_Date: " + 
						    		ele2.getAttribute("License_Issue_Date") + ", License_Number: " + 
						    		ele2.getAttribute("License_Number") + ", License_Status: " + 
						    		ele2.getAttribute("License_Status") + ", Resident_Indicator: " + 
						    		ele2.getAttribute("Resident_Indicator") + ", State_Code: " +
						    		ele2.getAttribute("State_Code") + ", State_ID: " +
						    		ele2.getAttribute("State_ID") + "\n\n\n"
						    	);
							    f.close();
							}
					}					
				}
			}
		}
		TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer = tf.newTransformer();
        DOMSource ds = new DOMSource(doc);
        StreamResult res = new StreamResult(new File("NewMerged.xml"));
        transformer.transform(ds, res);
	}
}
