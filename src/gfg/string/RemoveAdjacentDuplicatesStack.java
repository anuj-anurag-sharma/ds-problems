package gfg.string;

import java.util.Stack;

public class RemoveAdjacentDuplicatesStack {

	public static void main(String[] args) {
		System.out.println(removeDuplicates(removeDuplicates("mississipie")));
	}

	public static String removeDuplicates(String str) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(str.charAt(0));
		int i = 1;
		while (i < str.length()) {
			if (stack.peek().equals(str.charAt(i))) {
				stack.pop();
			} else {
				stack.push(str.charAt(i));
			}
			i++;
		}
		String output = "";
		while (!stack.isEmpty()) {
			output = String.valueOf(stack.pop()) + output;
		}
		return output;
	}

}
