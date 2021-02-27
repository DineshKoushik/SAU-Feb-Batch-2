
import java.io.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Merge {
	private static boolean check(Element a, Element b) {
	       if (a.getAttribute("State_Code").equals(b.getAttribute("State_Code")) 
	    		   && a.getAttribute("License_Number").equals(b.getAttribute("License_Number"))
	    		   && a.getAttribute("Date_Status_Effective").equals(b.getAttribute("Date_Status_Effective"))) {
	    	   return true;
	       }
	           return false;
	     }
	private static void helper(Document d, Element ele, Element curr) {
        try {
            Node valid_license = d.importNode(curr, true);
            ele.appendChild(valid_license);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public static void main(String[] args)throws Exception {
        try{
            File in1 = new File("License1.xml");
            File in2 = new File("License2.xml");
            
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbuilder = dbf.newDocumentBuilder();
            
            Document doc1 = dbuilder.parse(in1);
            Document doc2 = dbuilder.parse(in2);
            
            Document doc = dbuilder.newDocument();
            
            Element ele = doc.createElement("CSR_Producer");
            doc.appendChild(ele);
            
            doc1.getDocumentElement().normalize();
            NodeList lst1 = doc1.getElementsByTagName("CSR_Producer");
            
            doc2.getDocumentElement().normalize();
            NodeList lst2 = doc1.getElementsByTagName("CSR_Producer");
           for (int i = 0; i < lst1.getLength(); i++){
        	   Node a = lst1.item(i);
               Element ele1 = (Element) a;
               for (int j = 0; j < lst2.getLength(); j++) {
                   Node b = lst2.item(j);
                   Element ele2 = (Element) b;
                   if (ele1.getAttribute("NIPR_Number").equals(ele2.getAttribute("NIPR_Number"))) {
                       NodeList lst3 = ele1.getElementsByTagName("License");
                       for (int k = 0; k < lst3.getLength(); k++) {
                           Element ele3 = (Element) lst3.item(k);
                           NodeList lst4 = ele2.getElementsByTagName("License");
                           for (int l = 0; l < lst4.getLength(); l++) {
                               Element n = (Element) lst4.item(l);
                               if (check(ele3, n)) {
                                   helper(doc, ele, n);
                               }
                           }
                       }
                   }
               }
           }
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource ds = new DOMSource(doc);
            StreamResult file = new StreamResult(new File("NewMerged.xml"));
            t.transform(ds, file);
        }catch(Exception e){
            e.printStackTrace();
        }
	}
}
