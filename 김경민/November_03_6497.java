package November;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class November_03_6497 {
	
	static int parent[];
	
	static class Node implements Comparable<Node> {
		int a, b, c;
		public Node(int a, int b, int c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}
		@Override
		public int compareTo(Node o) {
			return this.c - o.c;
		}
		
	}
	static int find(int a) {
		if(a == parent[a])
			return a;
		parent[a] = find(parent[a]);
		return parent[a];
	}
	
	static void union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if(aRoot != bRoot)
			parent[aRoot] = bRoot;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer line;
		while(true) {
			line = new StringTokenizer(br.readLine(), " ");
			PriorityQueue<Node> q = new PriorityQueue<>();
			int sum = 0;
			int result = 0;
			int M = Integer.parseInt(line.nextToken());
			int N = Integer.parseInt(line.nextToken());
			if(M == 0 && N == 0)
				break;
			parent = new int[M+1];
			for(int i=1;i<=M;i++) {
				parent[i] = i;
			}
			for(int i=0;i<N;i++) {
				line = new StringTokenizer(br.readLine(), " ");
				q.add(new Node(Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken()), Integer.parseInt(line.nextToken())));
			}
			while(!q.isEmpty()) {
				Node temp = q.poll();
				sum += temp.c;
				if(find(temp.a) == find(temp.b)) {
					continue;
				}
				union(temp.a, temp.b);
				result += temp.c;
			}
			System.out.println(sum - result);
		}
		
	}

}
