package gfg.array;

public class MatrixSpiralTraversal {

	static int count = 0;

	public static void main(String[] args) {

		int[][] input = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 }, { 16, 17, 18, 19, 20 },
				{ 21, 22, 23, 24, 25 } };
		count = 25;
		spiralTraversal(input, 0, 0, 5, 5, 0, 0, 1);

	}

	static void spiralTraversal(int[][] input, int xLower, int yLower, int xUpper, int yUpper, int xStart, int yStart,
			int dir) {
		if (count <= 0) {
			return;
		}
		// RIGHT
		if (dir == 1) {
			for (int j = yStart; j < yUpper; j++) {
				System.out.print(input[xStart][j] + " ");
				yStart++;
				count--;
			}
			yStart--;
			xStart++;
			xLower++;
			spiralTraversal(input, xLower, yLower, xUpper, yUpper, xStart, yStart, 2);
		}

		// DOWN
		else if (dir == 2) {
			for (int i = xStart; i < xUpper; i++) {
				System.out.print(input[i][yStart] + " ");
				xStart++;
				count--;
			}
			xStart--;
			yStart--;
			yUpper--;
			spiralTraversal(input, xLower, yLower, xUpper, yUpper, xStart, yStart, 3);
		}

		// LEFT
		else if (dir == 3) {
			for (int j = yStart; j >= yLower; j--) {
				System.out.print(input[xStart][j] + " ");
				yStart--;
				count--;
			}
			yStart++;
			xStart--;
			xUpper--;
			spiralTraversal(input, xLower, yLower, xUpper, yUpper, xStart, yStart, 4);
		} else if (dir == 4) {
			for (int i = xStart; i >= xLower; i--) {
				System.out.print(input[i][yStart] + " ");
				xStart--;
				count--;
			}
			xStart++;
			yLower++;
			yStart++;
			spiralTraversal(input, xLower, yLower, xUpper, yUpper, xStart, yStart, 1);
		}
	}

}
