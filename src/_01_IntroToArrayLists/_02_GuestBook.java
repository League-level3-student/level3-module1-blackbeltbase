package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_GuestBook implements ActionListener {
	// Create a GUI with two buttons. One button reads "Add Name" and the other button reads "View Names". 
	// When the add name button is clicked, display an input dialog that asks the user to enter a name. Add
	// that name to an ArrayList. When the "View Names" button is clicked, display a message dialog that displays
	// all the names added to the list. Format the list as follows:
	// Guest #1: Bob Banders
	// Guest #2: Sandy Summers
	// Guest #3: Greg Ganders
	// Guest #4: Donny Doners
	JButton addName;
	JButton viewName;
	JFrame frame;
	JPanel panel;
	ArrayList<String> names = new ArrayList<String>();
	public static void main(String[] args) {
		new _02_GuestBook().start();
	}
	void start() {
names.add("");
		addName = new JButton();
		viewName = new JButton();
		panel = new JPanel();
		frame = new JFrame();
		addName.setText("Add Name");
		viewName.setText("View Names");
		addName.addActionListener(this);
		viewName.addActionListener(this);
		panel.add(addName);
		panel.add(viewName);
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton buttonPressed = (JButton) e.getSource();
		if(buttonPressed == viewName) {
			String list ="";
			for(int i = 1; i< names.size(); i++) {
				list =list+ "\nGuest #"+i+": "+names.get(i);
			}
			System.out.println(list);
			JOptionPane.showMessageDialog(null, list);
		}
		else if(buttonPressed == addName) {
			String guest = JOptionPane.showInputDialog("Add a guest");
			names.add(guest);
		}
	}
}
