package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
 JFrame frame = new JFrame();
 JPanel panel = new JPanel();
 JButton addEntry = new JButton();
 JButton searchByID = new JButton();
 JButton viewList = new JButton();
 JButton removeEntry = new JButton();
 String list = "People:";
 HashMap<Integer, String> people = new HashMap<Integer, String>();
 public static void main(String[] args) {
	 _02_LogSearch log = new _02_LogSearch();
	 log.run();
 }
 void run() {
	 removeEntry.addActionListener(this);
	 addEntry.addActionListener(this);
	searchByID.addActionListener(this);
	viewList.addActionListener(this);
	removeEntry.setText("Remove Entry");
	addEntry.setText("Add Entry");
	searchByID.setText("Search By ID");
	viewList.setText("View List");
	 panel.add(addEntry);
	 panel.add(searchByID);
	 panel.add(viewList);
	 panel.add(removeEntry);
	 frame.add(panel);
	 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 frame.pack();
	 frame.setVisible(true);
 
 }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	JButton buttonPressed = (JButton) e.getSource();

//	  Crate a HashMap of Integers for the keys and Strings for the values.
//	  Create a GUI with three buttons. 
//	  Button 1: Add Entry
//	  				When this button is clicked, use an input dialog to ask the user to enter an ID number.
//	  				After an ID is entered, use another input dialog to ask the user to enter a name.
//	  				Add this information as a new entry to your HashMap.
	if(buttonPressed==addEntry) {
		String id = JOptionPane.showInputDialog("Enter an ID number");
		String name = JOptionPane.showInputDialog("Enter a name");
		people.put(Integer.parseInt(id),name);
	}
	else if(buttonPressed == searchByID) {
		String id = JOptionPane.showInputDialog("Enter a valid ID number");
		if(people.containsKey(Integer.parseInt(id))) {
			for(Integer i : people.keySet()){
				if(Integer.parseInt(id)==i) {
				JOptionPane.showMessageDialog(null, "The person acquainted with the ID | "+id+" | is "+people.get(i));
				}
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "This ID is invalid");
		}
	}
	else if(buttonPressed==viewList) {
		for(Integer i : people.keySet()){
			list += "\n ID: "+i+" Name: "+people.get(i);
		}
		System.out.println(list);
		JOptionPane.showMessageDialog(null, list);
	}
	else if(buttonPressed == removeEntry) {
		String id = JOptionPane.showInputDialog("Enter a valid ID number to remove");
		if(people.containsKey(Integer.parseInt(id))) {
			for(Integer i : people.keySet()){
				if(Integer.parseInt(id)==i) {
				JOptionPane.showMessageDialog(null, "Removing entry at ID "+i);
				people.remove(i);
				}
			}
			
		}
		else {
			JOptionPane.showMessageDialog(null, "This ID is invalid");
		}
	}
//	  
//	  Button 2: Search by ID
//	  				When this button is clicked, use an input dialog to ask the user to enter an ID number.
//	  				If that ID exists, display that name to the user.
//	  				Otherwise, tell the user that that entry does not exist.
//	  
//	  Button 3: View List
//	  				When this button is clicked, display the entire list in a message dialog in the following format:
//	  				ID: 123  Name: Harry Howard
//	  				ID: 245  Name: Polly Powers
//	  				ID: 433  Name: Oliver Ortega
//	  				etc...
//	  
//	  When this is complete, add a fourth button to your window.
//	  Button 4: Remove Entry
//	  				When this button is clicked, prompt the user to enter an ID using an input dialog.
//	 			If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
//	 				is not in the list. 
}
}
