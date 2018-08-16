package pramp;

public class BracketMatch {

	static int bracketMatch(String text) {
		int required = 0;
		int difference = 0;

		for (int i = 0; i < text.length(); i++) {
			if (text.charAt(i) == '(') {
				difference = difference + 1;
			} else {
				difference = difference - 1;
			}
			if (difference < 0) {
				required++;
				difference = 0;
			}
		}

		required = required + difference;
		return required;

	}

	public static void main(String[] args) {
		System.out.println(bracketMatch("(()"));
		System.out.println(bracketMatch("(())"));
		System.out.println(bracketMatch("())("));
	}

}