package good.problems;

public class RatInMaze {

	public static void main(String[] args) {

	}

	void moveRight(String path, int[][] input, int x, int y) {
		if (x < input.length && input[x][y] == 1) {
			path = path + "R";
			x++;
		}
	}

	void moveDown(String path, int[][] input, int x, int y) {
		if (y < input.length && input[x][y] == 1) {
			path = path + "D";
			y++;
		}
	}

	void moveUp(String path, int[][] input, int x, int y) {
		if (y > 0 && input[x][y] == 1) {
			path = path + "U";
			y--;
		}
	}

	void moveLeft(String path, int[][] input, int x, int y) {
		if (x > 0 && input[x][y] == 1) {
			path = path + "L";
			x--;
		}
	}

}
