package gfg.string;

public class LongestPalindrome {

	public static void main(String[] args) {
		System.out.println(longestPalindrome("arra"));
	}

	static String longestPalindrome(String input) {
		String maxLengthPalindrome = "";

		for (int i = 0; i < input.length(); i++) {
			String palindrome = String.valueOf(input.charAt(i));
			int j = i - 1;
			int k = i + 1;
			palindrome = String.valueOf(input.charAt(i));
			while (j >= 0 && k < input.length()) {

				if (input.charAt(j) == input.charAt(k)) {
					palindrome = String.valueOf(input.charAt(j)) + palindrome + String.valueOf(input.charAt(k));
				} else {
					break;
				}
				j--;
				k++;
			}
			if (palindrome.length() > maxLengthPalindrome.length()) {
				maxLengthPalindrome = palindrome;
			}
		}
		for (int i = 0; i < input.length() - 1; i++) {
			if (input.charAt(i) == input.charAt(i + 1)) {
				String palindrome = String.valueOf(input.charAt(i)) + String.valueOf(input.charAt(i + 1));
				int j = i - 1;
				int k = i + 2;
				while (j >= 0 && k < input.length()) {
					if (input.charAt(j) == input.charAt(k)) {
						palindrome = String.valueOf(input.charAt(j)) + palindrome + String.valueOf(input.charAt(k));
					} else {
						break;
					}
					j--;
					k++;
				}
				if (palindrome.length() > maxLengthPalindrome.length()) {
					maxLengthPalindrome = palindrome;
				}
			}
		}
		return maxLengthPalindrome;
	}

}
