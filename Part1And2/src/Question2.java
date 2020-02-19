import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 
 * Program to extract the RefText values for the following RefCodes: ‘MWB’, ‘TRV’ and ‘CAR’
 * 
 * @author Derek McCarthy 
 * @version 1.0
 */
public class Question2 {
	
	//main method
	public static void main(String[] args) {
		
		//variables to store ref codes
		String carRefCode = "", mwbRefCode = "", trvRefCode = "";
		
		//try read in the xml file
		try {
			//create file instance with the path to file containing xml file
			File myFile = new File("q2.xml"); 
			//defines a factory to be able to parse the xml document
			DocumentBuilderFactory myDocFactory = DocumentBuilderFactory.newInstance();
			//use the factory to create a document builder
			DocumentBuilder docBuilder = myDocFactory.newDocumentBuilder();
			//create a new document from xml file
	        Document myDoc = docBuilder.parse(myFile);
	        //create a list to store the elements under the reference tag
	        NodeList myList = myDoc.getElementsByTagName("Reference");
	       
	        //iterate through the node list 
	        for (int i= 0; i < myList.getLength(); i++) {
	        	//store the item from the list at position i
	            Node node = myList.item(i);
	            if (node.getNodeType() == Node.ELEMENT_NODE) {
	            	//create an element from the node	            	
	            	Element eElement = (Element) node;
	            	
	            	//placeholder to hold the ref code
	            	String myRef = eElement.getAttribute("RefCode");
	            	
	            	//if the ref code is MWB
	            	if (myRef.equals("MWB")) {
	            		//placeholder to store the ref code content removing all white spaces
	            		mwbRefCode = eElement.getTextContent().replaceAll("\\s","");
	            		//print the ref code content
	            		System.out.println(mwbRefCode);
	            	}//end if
	            	
	            	//if the ref code is TRV
	            	if (myRef.equals("TRV")) {
	            		//placeholder to store the ref code content removing all white spaces
	            		trvRefCode = eElement.getTextContent().replaceAll("\\s","");
	            		//print the ref code content
	            		System.out.println(trvRefCode);
	            	}//end if
	            	
	            	//if the ref code is CAR
	            	if (myRef.equals("CAR")) {
	            		//placeholder to store the ref code content removing all white spaces
	            		carRefCode = eElement.getTextContent().replaceAll("\\s","");
	            		//print the ref code content
	            		System.out.println(carRefCode);
	            	}//end if
	            }//end if
	         }
		}//end try
		
		//catch exception
		catch (Exception e) {
			//print error message
			System.out.println("An error occurred");
			//print stackTrace
			e.printStackTrace();
		}//end catch
	}//end main method
}//end class
