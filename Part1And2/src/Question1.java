import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * Program to parse out the all the LOC segments and populate an array with the 2nd and 3rd element of each segment.
 * @author Derek McCarthy B00007439
 *
 */
public class Question1 {
	
	//main method
	public static void main(String[] args) {
		
		//variable to store line data
		String myLine ="";
		//arrayList to store the second and third element of the LOC segment
		ArrayList<String> myLocSegmentList = new ArrayList<String>();
		
		//try read in the EDIFACT message from the text file
		try {
			//create file instance with the path to file containing EDIFACT message 
			File myFile = new File("q1.txt");
			//create a scanner instance to read in file
			Scanner myScanner = new Scanner(myFile);
			
			//read in each line of file
			while (myScanner.hasNextLine()) {
				//temp place holder to hold each line of the file while its being read in
				myLine = myScanner.nextLine();
				//pattern object for extracting the LOC segments 
				Pattern pat = Pattern.compile("LOC");
				//matcher object to check for LOC segments
				Matcher match = pat.matcher(myLine);
				
				//while there is a match to the LOC segment
				while(match.find()) {
					//split the line with the '+' delimiter into tokens
					String tokens[] = myLine.split("\\+");
					//add the second element of the line to an arrayList
					myLocSegmentList.add(tokens[1]);
					//add the third element of the line to an arrayList
					myLocSegmentList.add(tokens[2]); 
				}//end inner while loop
			}//end outer while loop
			
			//close the scanner
			myScanner.close();
		
		//catch exception	
		} catch (FileNotFoundException e) {
			//print error message
			System.out.println("An error occurred");
			//print stackTrace
			e.printStackTrace();
		}//end catch block
		
		//iterate through array list
		for (int i = 0; i < myLocSegmentList.size(); i++) {
			//print contents of array list
			System.out.println(myLocSegmentList.get(i));
		}//end for loop
	}//end main method
}//end class
