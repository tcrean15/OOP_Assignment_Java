# OOP_Assignment_Java
Name 						: OOP Java Assignment 
Author 					: Thomas Crean 
Student Number and Year			: C21416014 TU857/2

Program Description + Requirements 	:
						
						3. My Search Engine
This tool will allow you to search for a term across a set of text sources – e.g. groups of text 
files. 
The user puts in a search term into a GUI and the tool will check the contents of a set of text 
files and tell you which ones contain the search term. The files that have the “strongest 
match” against the search term should be returned at the top of the list. 
The user should be able to search on a single word. But to make the search better, you 
should be able to search on multiple words – e.g. “Christmas day”.. although what rules you 
apply as to whether these are assumed to be together or separate words is up to you; 
Maybe you can use “*” and logic (e.g. this word AND this word OR this word) to make the 
search smarter. 
The above is just a basic spec. To make this more advanced for more marks, you will need 
to:
 Have more sophisticated searching - e.g. exact phrase matches, comma separate 
words, wild cards (such as walk* to find walked, walking, walk etc). 
 Have a way for the user to pick the search space (i.e. the text files to be searched). 
 Have a good ranking mechanism so the strongest match is returned first – and a ranking 
metric (e.g. a %) is calculated and the user can see this. 
 Spelling correction where it can correct wrong spelling of search terms
 What else can you come up with?

------------------------------------------------------------------------------------------------------------------

There are 3 classes being used in this project:
	- The 'Control' class
		- This is used to create a new GUI and run the program

	- The 'SearchEngineGUI' class
		- This class is used to create a GUI for the SearchEngine class.
		- A panel is created to hold all the components(input,button and results panel)
		- Main frame of the GUI is created and the the panel is added to it
      
	- The 'SearchEngine' class
		- Inherts properties from 'SearchEngineGUI'
		- The method searchDirectory uses if statements to check for correct directory path and if the directory has files
		- It then implements the searchFile method to check for the search term and using a flag it will let user know if no term was found.

------------------------------------------------------------------------------------------------------------------
If I had more time 
