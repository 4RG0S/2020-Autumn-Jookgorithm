package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class November_06_10868 {
	
	static class RMQ {
		int n;
		int min[];
		public RMQ(ArrayList<Integer> list) {
			n = list.size();
			min = new int[list.size() * 4];
			init(list, 0, n-1, 1);
		}
		int init(ArrayList<Integer> list, int left, int right, int node) {
			if(left == right)
				return min[node] = list.get(left);
			int middle = (left + right) / 2;
			int leftMin = init(list, left, middle, node*2);
			int rightMin = init(list, middle + 1, right, node*2+1);
			return min[node] = Integer.min(leftMin, rightMin);
		}
		int query(int left, int right, int node, int nodeLeft, int nodeRight) {
			if(right < nodeLeft || nodeRight < left)
				return Integer.MAX_VALUE;
			if(left <= nodeLeft && nodeRight <= right)
				return min[node];
			int nodeMiddle = (nodeLeft + nodeRight) / 2;
			return Integer.min(query(left, right, node*2, nodeLeft, nodeMiddle), query(left, right, node*2+1, nodeMiddle+1, nodeRight));
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		
		for(int i=0;i<N;i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		RMQ rmq = new RMQ(list);
		for(int i=0;i<M;i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(line.nextToken()) - 1;
			int to = Integer.parseInt(line.nextToken()) - 1;
			System.out.println(rmq.query(from, to, 1, 0, N-1));
		}
	}

}
