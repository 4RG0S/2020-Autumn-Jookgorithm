package September;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class September_18_16508 {

	static int result = Integer.MAX_VALUE;
	static HashMap<Character, Integer> find;
	static HashMap<Character, Integer> book[];
	static int prices[];

	static void combination(boolean[] visited, int start, int n, int r) {
		if (r == 0) {
			calculation(visited);
			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;
			combination(visited, i + 1, n, r - 1);
			visited[i] = false;
		}
	}

	static HashMap<Character, Integer> toMap(String input) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < input.length(); i++) {
			if (map.containsKey(input.charAt(i))) {
				map.put(input.charAt(i), map.get(input.charAt(i)) + 1);
			} else {
				map.put(input.charAt(i), 1);
			}
		}
		return map;
	}

	static void calculation(boolean[] visited) {
		boolean valid = true;
		for (Entry<Character, Integer> entry : find.entrySet()) {
			Character key = entry.getKey();
			Integer value = entry.getValue();
			int value_sum = 0;
			for (int i = 0; i < book.length; i++) {
				if (visited[i] && book[i].containsKey(key)) {
					value_sum += book[i].get(key);
				}
			}
			if (value_sum < value)
				valid = false;
		}
		if (valid) {
			int sum = 0;
			for (int i = 0; i < visited.length; i++) {
				if (visited[i])
					sum += prices[i];
			}

			if (sum < result) {
				result = sum;
			}

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		int N = scan.nextInt();
		scan.nextLine();
		find = null;
		book = new HashMap[N];
		prices = new int[N];

		find = toMap(line);
//		System.out.println(find);
		for (int i = 0; i < N; i++) {
			line = scan.nextLine();
			String split[] = line.split(" ");
			prices[i] = Integer.parseInt(split[0]);
			book[i] = toMap(split[1]);
		}
		boolean isvisit[] = new boolean[N];

		for (int i = 1; i <= N; i++) {
			combination(isvisit, 0, N, i);
		}
		if(result != Integer.MAX_VALUE)
			System.out.println(result);
		else
			System.out.println(-1);
	}

}
