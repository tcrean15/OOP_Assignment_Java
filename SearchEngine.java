package com.Assignment1.test;

import java.io.File;//will allow for queries to be made on files
import java.io.IOException;//will throw an exception when an operation fails or is interrupted
import java.util.Scanner;//will analyzing and processing the files
import javax.swing.JOptionPane;// used to display messages

//inherits all the properties and methods of SearchEngineGUI
public class SearchEngine extends  SearchEngineGUI{

	//search for a specific directory path 
    public static void searchDirectory(String searchTerm, String directoryPath) throws IOException {
        File directory = new File(directoryPath);
        
        //check if users input is correct and if it is a invalid directory display error message and return
        if (!directory.isDirectory()) {
        	JOptionPane.showMessageDialog(frame, "Invalid directory path!");
            return;
        }

        File[] files = directory.listFiles();
        
        //check for files in directory and if empty display a error message and return
        if (files == null) {
        	JOptionPane.showMessageDialog(frame, "Directory is empty!");
            return;
        }

        boolean matchFound = false; // add flag for matches found

        //check for matches for search term
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                if (searchFile(searchTerm, file)) {
                    matchFound = true; // set flag to true if match found
                }
            }
        }

        if (!matchFound) { // check flag to see if match not found and display a message
        	JOptionPane.showMessageDialog(frame, "Search Term Not Found!");
        }
    }
    
    
    public static boolean searchFile(String searchTerm, File file) throws IOException {
        
    	//scanner used to read the file and check for search term 
    	Scanner scanner = new Scanner(file);

        int lineNumber = 0;

        boolean matchFound = false; // add flag for matches found
        
        //check each line of a file for the search term until end of file
        while (scanner.hasNextLine()) {
            
        	//increment the line number for each new line
        	lineNumber++;

        	//string created for the new line so that the search term can be checked for  
            String line = scanner.nextLine();
            
            //if term is found, it will be displayed in the result area of the GUI
            if (line.contains(searchTerm)) {
            	
            	//displays the file name, the number line of were the term is found, and the whole line.
            	resultsArea.append(file.getName() + " (" + lineNumber + "): " + line + "\n");
                matchFound = true; // set flag to true if match found
            }
        }

        scanner.close();

        return matchFound; // return flag for matches found
    }
}
