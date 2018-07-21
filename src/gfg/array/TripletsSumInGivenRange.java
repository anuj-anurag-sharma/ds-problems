package gfg.array;

import java.util.Arrays;

public class TripletsSumInGivenRange {

	public static void main(String[] args) {
		int[] input = { 2, 7, 5, 3, 8, 4, 1, 9 };
		int inRange = findTripletsInGivenRange(input, 8, 16);
		System.out.println(inRange);
	}

	static int findTripletsInGivenRange(int[] input, int lower, int higher) {
		int triplets = 0;
		Arrays.sort(input);

		for (int i = 0; i < input.length - 2; i++) {
			int lowerIdx = i + 1;
			int higherIdx = input.length - 1;
			int hr = higher - input[i];
			int lr = lower - input[i];
			while (lowerIdx < higherIdx) {
				int sum = input[lowerIdx] + input[higherIdx];
				System.out.println("sum : " + sum + ", hr: " + hr + ", lr: " + lr);
				if (sum <= hr && sum >= lr) {
					System.out.println("Adding " + (higherIdx - lowerIdx));
					triplets = triplets + higherIdx - lowerIdx;
					lowerIdx++;
				} else {
					if (sum > hr) {
						higherIdx--;
					} else {
						lowerIdx++;
					}
				}
			}
		}
		return triplets;
	}

}
