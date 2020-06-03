package _01_IntroToArrayLists;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;


//Copyright The League of Amazing Programmers, 2015

public class _06_IPodShuffle implements ActionListener{
	JFrame frame = new JFrame();
	JButton button = new JButton();
	 ArrayList<Song> songs = new ArrayList<Song>();
	public _06_IPodShuffle() {
		// 1. Use the Song class the play the demo.mp3 file.
				Song song = new Song("demo.mp3");
				
		/**
		 * 2. Congratulations on completing the sound check! * Now we want to make an
		 * iPod Shuffle that plays random music. * Create an ArrayList of Songs and a
		 * "Surprise Me!" button that will play a random song when it is clicked. * If
		 * you're really cool, you can stop all the songs, before playing a new one on
		 * subsequent button clicks.
		 */
				button.addActionListener(this);
				button.setText("PLAY A RANDOM SONG");
				frame.setSize(100, 300);
				frame.add(button);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				 songs.add(song);
				 songs.add(new Song("Bass.mp3"));
				 songs.add(new Song("othersong.mp3"));
				 
	}
	
	public static void main(String[] args) {
		new _06_IPodShuffle();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Random ran = new Random();
		int rannum = ran.nextInt(3);
		if(rannum==0) {
			songs.get(0).setDuration(10);
			songs.get(0).play();
		}
		else {
		songs.get(rannum).play();
		}
	}
}