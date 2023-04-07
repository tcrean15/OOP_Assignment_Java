/*
 * This class is used to create a GUI for the SearchEngine class.
 * 
 */

package com.Assignment1.test;

import java.awt.*;//used for the GUI to create each part of the interface  
import java.awt.event.*;//for the users input(mouse clicks, key presses, etc)
import java.io.IOException;//will throw an exception when an operation fails or is interrupted
import javax.swing.*;//extension of AWT for more advanced GUI components


public class SearchEngineGUI {
	
	//declaring variables
	protected static JFrame frame;
	private JLabel searchTermLabel, directoryPathLabel;
	private JTextField searchTermField, directoryPathField;
	private JButton searchButton;
	protected static JTextArea resultsArea;

	//constructor to initialize the GUI components and create event listeners for the search button 
	public SearchEngineGUI() {

		// Initialize components
		searchTermLabel = new JLabel("Search Term:");
		directoryPathLabel = new JLabel("Directory Path:");
		searchTermField = new JTextField(20);
		directoryPathField = new JTextField(20);
		searchButton = new JButton("Search");
		resultsArea = new JTextArea(10, 40);
		resultsArea.setEditable(false);

		// Create a panel to hold the input components
		JPanel inputPanel = new JPanel(new GridLayout(2, 2));
		inputPanel.add(searchTermLabel);
		inputPanel.add(searchTermField);
		inputPanel.add(directoryPathLabel);
		inputPanel.add(directoryPathField);

		// Create a panel to hold the search button
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		buttonPanel.add(searchButton);

		// Add action listener to the search button so that the searchDirectory class will perform
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				try {
					SearchEngine.searchDirectory(searchTermField.getText(), directoryPathField.getText());
				} catch (IOException ex) {
					JOptionPane.showMessageDialog(frame, "Error searching directory: " + ex.getMessage());
				}
			}
		});

		// Create a panel to hold the results area
		JScrollPane resultsPanel = new JScrollPane(resultsArea);

		// Create the main panel to hold all the components
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.add(inputPanel, BorderLayout.NORTH);
		mainPanel.add(buttonPanel, BorderLayout.CENTER);
		mainPanel.add(resultsPanel, BorderLayout.SOUTH);

		// Create the main frame and add the main panel to it
		frame = new JFrame("Search Engine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new SearchEngineGUI();
	}

}
