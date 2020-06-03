package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	Stack<Character> chars = new Stack<Character>();
	Stack<Character> charsHolder = new Stack<Character>();
	 static JFrame frame = new JFrame();
	 static JPanel panel = new JPanel();
	 static JLabel label = new JLabel();
	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label);
		frame.add(panel);
		_02_TextUndoRedo frames= new _02_TextUndoRedo();
		frame.pack();
		frame.setVisible(true);
	}
	public _02_TextUndoRedo() {
		frame.addKeyListener(this);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyChar());
		chars.push(e.getKeyChar());
		charsHolder = chars;
		String text = "";
for(int i = 0; i<chars.size();i++) {
	text +=chars.pop().toString();
		label.setText(text);
		System.out.println("textAdded");
}
frame.pack();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	/* 
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character is erased from the JLabel.
	 * Save that deleted character onto a Stack of Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed, the top Character is popped 
	 * off the Stack and added back to the JLabel.
	 * 
	 * */
	
	
}
