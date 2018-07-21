
public class Histogram {

	public static void main(String[] args) {
		int[] input = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		System.out.println(new Histogram().findMaxWaterTrapped(input));

	}

	public int findMaxWaterTrapped(int[] input) {

		int[] leftHighest = new int[input.length];
		int[] rightHighest = new int[input.length];

		leftHighest[0] = input[0];
		for (int i = 1; i < input.length; i++) {
			leftHighest[i] = Math.max(input[i], leftHighest[i - 1]);
		}

		rightHighest[rightHighest.length - 1] = input[input.length - 1];
		for (int i = input.length - 2; i >= 0; i--) {
			rightHighest[i] = Math.max(input[i], rightHighest[i + 1]);
		}

		int water = 0;

		for (int i = 0; i < input.length; i++) {
			water = water + Math.min(leftHighest[i], rightHighest[i]) - input[i];
		}

		return water;

	}

}
