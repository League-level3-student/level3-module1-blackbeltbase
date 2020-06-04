package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	Stack<Character> chars = new Stack<Character>();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel label = new JLabel();

	public static void main(String[] args) {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel.add(label);
		frame.add(panel);
		frame.setSize(200, 200);
		_02_TextUndoRedo frames = new _02_TextUndoRedo();
		frame.pack();
		frame.setVisible(true);
		JOptionPane.showMessageDialog(null, "Type. use backspace to delete and control to undo");
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
	
		String text = "";

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			if (label.getText().length() != 0) {
				text = label.getText().substring(0, label.getText().length() - 1);
				chars.push(label.getText().charAt(label.getText().length() - 1));
				System.out.println(label.getText().charAt(label.getText().length() - 1));
			}
		} else if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
			if (chars.size() != 0) {
				text = label.getText() + chars.pop();
			}
		} else {
			text = label.getText() + e.getKeyChar();
		}
		System.out.println(text);
		label.setText(text);
		frame.pack();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	/*
	 * Create a JFrame with a JPanel and a JLabel.
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

}
