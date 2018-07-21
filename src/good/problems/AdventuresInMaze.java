package good.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AdventuresInMaze {

	static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) {
		/*int[][] input = { { 1, 1, 3, 2, 1 }, { 3, 2, 2, 1, 2 }, { 1, 3, 3, 1, 3 }, { 1, 2, 3, 1, 2 },
				{ 1, 1, 1, 3, 1 } };
		int N = 4;
		String path = "";
		traverse(N, input, 0, 0, path, 0);

		List<Integer> list = new ArrayList<Integer>();
		list.addAll(map.values());
		Collections.sort(list);
		System.out.println(map.size() + " " + list.get(list.size() - 1));
*/	
		scanner();
		}

	static void scanner() {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			t--;
			traverse(n - 1, arr, 0, 0, "", 0);
			List<Integer> list = new ArrayList<Integer>();
			list.addAll(map.values());
			Collections.sort(list);
			System.out.println(map.size() + " " + list.get(list.size() - 1));
			map.clear();
		}
	}

	public static void traverse(int N, int[][] input, int i, int j, String path, int adventure) {
		if (i > N || j > N) {
			return;
		}

		path = path.concat(i + "," + j + " ");
		adventure += input[i][j];

		if (i == N && j == N) {
			map.put(path, adventure);
			return;
		}

		switch (input[i][j]) {
		case 1: {
			j++;
			traverse(N, input, i, j, path, adventure);
			break;
		}
		case 2: {
			i++;
			traverse(N, input, i, j, path, adventure);
			break;
		}
		case 3: {
			j++;
			traverse(N, input, i, j, path, adventure);
			j--;
			i++;
			traverse(N, input, i, j, path, adventure);
			break;
		}
		}

	}
}
