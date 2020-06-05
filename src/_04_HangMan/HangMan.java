package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener{
	static Stack<String> words = new Stack<String>();
 JLabel[] life = new JLabel[5];
	static Utilities wordReader;
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	static JLabel lives = new JLabel();
	static JLabel numLetters = new JLabel();
	int hearts = 5;
	String word = "";
	CharSequence guess;
	String text = "";
	public static void main(String[] args) {
		HangMan startup = new HangMan();
	}
	public HangMan() {
		lives.setText("Lives:");
		panel.add(lives);
		for(int i = 0; i<life.length;i++) {
			life[i] = new JLabel();
			life[i].setText("<3");
			panel.add(life[i]);
		}
		panel.add(numLetters);
		frame.add(panel);
		frame.setSize(500, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		String userNum = JOptionPane.showInputDialog("Enter a number");
		getWords(Integer.parseInt(userNum));

		frame.addKeyListener(this);
		wordReader = new Utilities();
			word = words.pop();
			System.out.println(word);
		JOptionPane.showMessageDialog(null, "Guess letters to guess the word");
		text = getWordLength(word);
		numLetters.setText("Number of Letters: "+text);
		
		
	}
	String getWordLength(String word) {
		String text = "";
		for(int i = 0; i< word.length();i++) {
			text += "|";
		}
		return text;
	}
  void getWords(int numberWords) {
		for(int i = 0; i<numberWords;i++) {
			words.push(wordReader.readRandomLineFromFile("dictionary.txt"));
		}
	}
  
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		String characters = "";
		 characters += e.getKeyChar();
		String textHolder = "";
		guess = characters;
		int moreLetters = 0;
		System.out.println(guess);
		if(word.contains(guess)) {
			JOptionPane.showMessageDialog(null, "Correct!");
			System.out.println("correct");
			System.out.println(e.getKeyChar());
			for(int i = 0; i<word.length();i++) {
				if(word.indexOf(e.getKeyChar())+moreLetters ==i) {
					textHolder += e.getKeyChar();
					System.out.println("letterAdded");
				}
				else {
					textHolder += text.substring(i, i+1);
				}
				moreLetters++;
			}
			text = "";
		}
		else {
			life[life.length-1].remove(life.length-1);;
		}
		text = textHolder;
		numLetters.setText("Number of Letters: "+text);
		frame.add(panel);
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
