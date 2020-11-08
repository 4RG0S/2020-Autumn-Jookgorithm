package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class November_06_2357 {

	static class RMQ {
		static int n;
		static int rangeMin[];
		static int rangeMax[];

		public RMQ(ArrayList<Integer> list) {
			n = list.size();
			rangeMin = new int[list.size() * 4];
			rangeMax = new int[list.size() * 4];
			init_min(list, 0, n - 1, 1);
			init_max(list, 0, n - 1, 1);
		}

		int init_min(ArrayList<Integer> list, int left, int right, int node) {
			if (left == right)
				return rangeMin[node] = list.get(left);
			int middle = (left + right) / 2;
			int leftMin = init_min(list, left, middle, node * 2);
			int rightMin = init_min(list, middle + 1, right, node * 2 + 1);
			return rangeMin[node] = Integer.min(leftMin, rightMin);
		}

		int init_max(ArrayList<Integer> list, int left, int right, int node) {
			if (left == right)
				return rangeMax[node] = list.get(left);
			int middle = (left + right) / 2;
			int leftMax = init_max(list, left, middle, node * 2);
			int rightMax = init_max(list, middle + 1, right, node * 2 + 1);
			return rangeMax[node] = Integer.max(leftMax, rightMax);
		}

		int min_query(int left, int right, int node, int nodeLeft, int nodeRight) {
			if (right < nodeLeft || nodeRight < left) {
				return Integer.MAX_VALUE;
			}
			if (left <= nodeLeft && nodeRight <= right)
				return rangeMin[node];
			int nodeMiddle = (nodeLeft + nodeRight) / 2;
			return Integer.min(min_query(left, right, node * 2, nodeLeft, nodeMiddle),
					min_query(left, right, node * 2 + 1, nodeMiddle + 1, nodeRight));
		}

		int max_query(int left, int right, int node, int nodeLeft, int nodeRight) {
			if (right < nodeLeft || nodeRight < left)
				return Integer.MIN_VALUE;
			if (left <= nodeLeft && nodeRight <= right)
				return rangeMax[node];
			int nodeMiddle = (nodeLeft + nodeRight) / 2;
			return Integer.max(max_query(left, right, node * 2, nodeLeft, nodeMiddle),
					max_query(left, right, node * 2 + 1, nodeMiddle + 1, nodeRight));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		ArrayList<Integer> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		RMQ rmq = new RMQ(list);
		for (int i = 0; i < M; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int left = Integer.parseInt(line.nextToken()) - 1;
			int right = Integer.parseInt(line.nextToken()) - 1;
			if (left > right) {
				int temp = left;
				left = right;
				right = temp;
			}
			System.out.println(rmq.min_query(left, right, 1, 0, N - 1) + " " + rmq.max_query(left, right, 1, 0, N - 1));
		}
	}

}
