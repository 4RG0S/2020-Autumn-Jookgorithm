package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class November_06_2042 {
	
	static class RMQ {
		int n;
		long sum[];
		public RMQ(ArrayList<Long> list) {
			n = list.size();
			sum = new long[list.size()*4];
			init(list, 0, n-1, 1);
		}
		long init(ArrayList<Long> list, int left, int right, int node) {
			if(left == right) 
				return sum[node] = list.get(right);
			int middle = (left + right) / 2;
			long leftSum = init(list, left, middle, node*2);
			long rightSum = init(list, middle + 1, right, node*2+1);
			return sum[node] = leftSum + rightSum;
		}
		long query(int left, int right, int node, int nodeLeft, int nodeRight) {
			if(right < nodeLeft | nodeRight < left)
				return 0;
			if(left <= nodeLeft && nodeRight <= right)
				return sum[node];
			int nodeMiddle = (nodeLeft + nodeRight) / 2;
			return query(left, right, node*2, nodeLeft, nodeMiddle) + query(left, right, node*2+1, nodeMiddle+1, nodeRight);
		}
		long update(int index, long newValue, int node, int nodeLeft, int nodeRight) {
			if(index < nodeLeft || nodeRight < index)
				return sum[node];
			if(nodeLeft == nodeRight) {
				return sum[node] = newValue;
			}
			int nodeMiddle = (nodeLeft + nodeRight) / 2;
			return sum[node] = (update(index, newValue, node*2, nodeLeft, nodeMiddle) + update(index, newValue, node*2+1, nodeMiddle + 1, nodeRight));
		}
		void print_sum() {
			for(int i=1;i<sum.length;i++) {
				System.out.print(sum[i] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(line.nextToken());
		int M = Integer.parseInt(line.nextToken());
		int K = Integer.parseInt(line.nextToken());
		ArrayList<Long> list = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			list.add(Long.parseLong(br.readLine()));
		}
		RMQ rmq = new RMQ(list);
		for (int i = 0; i < M+K; i++) {
			line = new StringTokenizer(br.readLine(), " ");
			int val = Integer.parseInt(line.nextToken());
			int left = Integer.parseInt(line.nextToken()) - 1;
			int right = Integer.parseInt(line.nextToken()) - 1;
			if(val == 1) {
				rmq.update(left, right + 1, 1, 0, N-1);
				//rmq.print_sum();
			} else if(val == 2) {
				System.out.println(rmq.query(left, right, 1, 0, N-1));
			}
		}
	}

}
