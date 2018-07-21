package gfg.string;

public class RemoveAllAdjacentElements {

	public static void main(String[] args) {

		String str = "mississipie";

		String output = removeAllAdjacentElements(str.substring(0, 1), str.substring(1), false);

		System.out.println(removeAllAdjacentElements(output.substring(0, 1), output.substring(1), false));

	}

	static String removeAllAdjacentElements(String result, String modified, boolean removeFlag) {
		if (modified.equals("")) {
			if (removeFlag) {
				return result.substring(0, result.length() - 1);
			}
			return result;
		}
		if (result.charAt(result.length() - 1) != modified.charAt(0)) {
			if (removeFlag) {
				result = result.substring(0, result.length() - 1);
			}
			result = result + String.valueOf(modified.charAt(0));
			modified = modified.substring(1);
			return removeAllAdjacentElements(result, modified, false);
		} else {
			modified = modified.substring(1);
			removeFlag = true;
			return removeAllAdjacentElements(result, modified, removeFlag);
		}
	}

}
