package gfg.string;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility classes
import java.util.*;
*/

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
import java.util.Scanner;

public class Transformation {
	static String[] words;
	static int minPath = Integer.MAX_VALUE;

	public static void main(String args[]) throws Exception {
		/*
		 * Sample code to perform I/O: Use either of these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String name = br.readLine(); //
		 * Reading input from STDIN System.out.println("Hi, " + name + "."); //
		 * Writing output to STDOUT
		 * 
		 * //Scanner Scanner s = new Scanner(System.in); String name =
		 * s.nextLine(); // Reading input from STDIN System.out.println("Hi, " +
		 * name + "."); // Writing output to STDOUT
		 * 
		 */

		// Write your code here

		Scanner s = new Scanner(System.in);
		String start = s.nextLine();
		String end = s.nextLine();
		int t = s.nextInt();
		words = new String[t];
		for (int i = 0; i < t; i++) {
			words[i] = s.next();
		}

		findTransformationPath(start, end, 0, 0);
		System.out.println(minPath);

	}

	static void findTransformationPath(String start, String end, int pathLength, int startCtr) {
		if (checkDifference(start, end) == 0) {
			minPath = Math.min(minPath, pathLength);
			return;
		}
		if (checkDifference(start, end) == 1) {
			minPath = Math.min(minPath, 1 + pathLength);
			return;
		}
		for (int i = startCtr; i < words.length; i++) {
			if (!(start.equals(words[i])) && checkDifference(start, words[i]) == 1) {
				findTransformationPath(words[i], end, 1 + pathLength, i + 1);
			}
		}

	}

	static int checkDifference(String start, String end) {
		int count = 0;
		for (int i = 0; i < start.length(); i++) {
			if (start.charAt(i) != end.charAt(i)) {
				count++;
			}
		}
		return count;
	}
}
