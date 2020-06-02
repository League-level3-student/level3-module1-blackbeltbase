package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> strings = new ArrayList<String>();
		//2. Add five Strings to your list
		strings.add("one.x");
		strings.add("two.exe");
		strings.add("three.exe");
		strings.add("four.exe");
		strings.add("five.x");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i<strings.size();i++) {
			String s = strings.get(i);
			System.out.println(s);
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : strings){
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = strings.size(); i>0;i--) {
			String s = strings.get(i);
			System.out.println(s);
		}
		//6. Print all the Strings in reverse order.
		
		//7. Print only the Strings that have the letter 'e' in them.
		for(int i = 0; i< strings.size(); i++) {
			String s = strings.get(i);
		int no = s.indexOf('e');
			if(no == 1) {
			System.out.println(strings.get(i));}
		}
	}
}
